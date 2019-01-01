//$(document).ready(function ()
$(function () {

    let $DataTable = $('#informationTable'), $DataTableAPI = null;
    let $addAndEditModal = $('#informationModal'), $dataTableForm = $("#dataTableForm"), editPrimaryKey = '';
    //var messageTypeList = null, bufferMap = new Map();
    const editor = {
        itemDescEditor : null,
        msgDescEditor: null
    }

    let {username, jumperAndParser, divWrap, showLimitLenStr} = initPage(editor);

    if ($DataTableAPI != null) {
        $DataTableAPI.destroy();
    }

    $DataTableAPI = $DataTable.DataTable({
        ajax: {
            type: 'post',
            dataType: 'json',
            async: true,
            data: function (d) {
                d.search = $DataTable.DataTable().search(this.value);
                d.userDevice = 'web';
            },
            url: "/subject/queryPage"
        },
        columns: [
            {
                /*data: null*/
                data: "msgTitle",
                render: (data, type, row) => {
                    // return divWrap('<img src="' + (isValidVar(data) ? data : NO_PIC_URL) + '" style="width: 50%;">');
                    return divWrap(
                        "<span class='clickable subject'"
                        + "messageId='" + parseInt(row.messageId) + "'"
                        + "itemName='" + row.itemName + "'>"
                        + showLimitLenStr(data, 10)
                        + "</span>"
                    );
                    /*divWrap('<span class="clickable subject" messageId="' + parseInt(row.messageId) + '" >'
                        //+ row.messageType + ": " + row.itemName +
                        + data +
                        '</span>');*/
                }
            }, {
                data: "itemName",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "messageType",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "publishTime",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "messageId",
                render: (data, type, row) => {
                    /*
                    itemName:"小明的校园卡"
                    messageDesc:"又捡了一张"
                    messageId:9
                    messageType:"拾取物品"
                    msgTitle:"../lib/plugins/assets/images/common/2011060400304367.jpg"
                    publishTime:"2018-10-09 00:00:00"
                    userUsername:"admin"
                    userNickname:"昵称"
                    */
                    const isPublisher = row.userUsername === username;
                    const publisherStr = "<span class='clickable option-col subject-opt-del' msgId='" + data + "'> 删除 </span>";
                    const visitErStr = "";
                    return divWrap(
                        isPublisher ? publisherStr : visitErStr,
                        isPublisher ? "option-col" : "pre-del-col"
                    );
                }
            }
        ],
        "columnDefs": [
            {
                render: function (data, type, row, meta) {
                    //渲染 把数据源中的标题和url组成超链接
                    return '<a href="' + data + '" target="_blank">' + row.itemName + '</a>';
                },
                //指定是第1列
                targets: 0
            },
            {"visible": true, "targets": 0}
        ],
        drawCallback: function (settings) {
            //前台添加序号
            /*$DataTableAPI.column(0, {
                "search": 'applied',
                "order": 'applied'
            }).nodes().each(function (cell, i) {
                cell.innerHTML = i + 1;
            });*/
            $(".subject").on('click', function () {
                const currentMsgId = this.getAttribute("messageId");
                const currentItemName = this.getAttribute("itemName");
                localStorage.setItem("pastPagePar", JSON.stringify({title: this.innerHTML, itemName: currentItemName}));
                jumperAndParser.jumperToTarget('topic.html', {
                    messageId: currentMsgId
                });
            });

            $('.subject-opt-del').on('click', function () {
                const $currentNode = $(this);
                const msgId = $currentNode.attr("msgId");
                deleteRowClosure(
                    $DataTableAPI
                    , "/subject/delete"
                    , "</br>  PS: 只能删除主题以及对应物品 无法直接删除别人的回复")(msgId);
                /*$.ajax({
                    type: 'post',
                    dataType: 'json',
                    data: {
                        primaryKey: msgId
                    },
                    url: "/subject/delete",
                    success: callbackClosure((data) => {
                        $.messageBox("删除成功!" + data);
                        $DataTableAPI.ajax.reload();
                    }, (data) => {
                        $.messageBox("删除失败!");
                    }),
                });*/
            });
        },
        // dom: "<'row'<'col-md-5'B>r>t<'row'<'col-md-5'l><'col-md-3'i><'col-md-4'p>>",
        processing: true,
        // sortable: true,
        serverSide: true,
        ordering: false,
        //使之向后台传请求页面时附加当前的 页码: start, 页长: length
        select: true,
        autoFill: true,
        selectPage: true,
        pageLength: 5,
        displayLength: 5,
        lengthMenu: [[5, 10, 15, 20, 50, 100, 150, -1], [5, 10, 15, 20, 50, 100, 150, "All"]],
        language: {url: "./datatable_zh_cn.json"}
    });

    AsyncLinkBufferChangeFactory({
        triggerSelector: 'select[id=onlyToTrigger]'
        , linkerSelector: 'select[name=messageType]'
        // , linkerBufferMap : bufferMap
        // , linkRequestUrl: '/subject/listSubjectType'
        , idName: 'value'
        , dataName: 'name',
        customLinkRequestFun: (triggerSelectIdParam, successCallback) => {
            $.ajax({
                type: 'post',
                dataType: 'json',
                async: true,
                data: {},
                url: '/subject/listSubjectType',
                success: function (result) {
                    if (result.success) {
                        let dataList = new Array();
                        result.data.forEach(ele => {
                            if(ele.name === '普通消息'){
                                // do nothing
                            }else{
                                dataList.push(ele);
                            }
                        });
                        successCallback(dataList);
                    } else {
                        console.error("数据请求失败!");
                    }
                },
            });
        }
    }).trigger('change', {selectLinkList: [0, -1]});

    // currentPage="subject" $('#topInfo').val()

    $('input[name=itemPickUpTime]').initDatePicker().val(new Date().format(DATE_FORMAT));

    initDraggableModal($($('.btn-modal-show').get(0)), $addAndEditModal, "发布主题");


    $dataTableForm.bootstrapValidator({
        feedbackIcons: {
            valid: 'fa fa-ok',
            invalid: 'fa fa-remove',
            validating: 'fa fa-refresh'
        },
        fields: {
            msgTitle: {
                validators: {
                    notEmpty: {
                        message: '非空！'
                    },
                },
                stringLength: {
                    min: 1,
                    max: 500,
                    message: '长度必须在1到500位之间'
                },
            },
            // 如果验证的名称填写错误不会造成jQuery堆栈溢出 但出现name相同的不同标签会
            // jQuery.Deferred exception: Maximum call stack size exceeded RangeError: Maximum call stack size exceeded
            messageDescBuffer: {
                validators: {
                    notEmpty: {
                        message: '非空！'
                    },
                },
                stringLength: {
                    min: 1,
                    max: 500,
                    message: '长度必须在1到500位之间'
                },
            },
            itemName: {
                validators: {
                    notEmpty: {
                        message: '非空！'
                    },
                },
                stringLength: {
                    min: 1,
                    max: 25,
                    message: '长度必须在1到25位之间'
                },
            }
        }
    }).on('success.form.bv', function (e) {
        e.preventDefault();

        // 将富文本编辑器中无法serialize的部分存到隐藏的input中
        // $('input[name=messageDesc]').val($('textarea[name=messageDescBuffer]').val());
        // $('input[name=itemDesc]').val($('textarea[name=itemDescBuffer]').val());
        editor.msgDescEditor.sync();
        editor.itemDescEditor.sync();

        $.ajax({
            type: 'post',
            dataType: 'json',
            data: $dataTableForm.serialize() + editPrimaryKey,
            url: (editPrimaryKey == "") ? "../subject/save" : "../subject/update",
            success: tipsCallbackClosure($DataTableAPI, (editPrimaryKey == "" ? '主题发布' : '编辑'), $addAndEditModal),
        });
        $dataTableForm.resetFormValidCheck();
    });

    $('select[name=messageType]').on('change', function () {
        const NORMAL_MESSAGE_VALUE = '0';
        const $currentNode = $(this);
        if ($currentNode.val() === NORMAL_MESSAGE_VALUE) {
            $('.item-info').domHideSubInvalid();
        } else {
            $('.item-info').domDisplaySubValid();
        }
    });

});

