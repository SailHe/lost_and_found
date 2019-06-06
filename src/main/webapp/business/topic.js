$(function () {
    let $DataTable = $('#informationTable'), $DataTableAPI = null;
    let $addAndEditModal = $('#informationModal'), $dataTableForm = $("#dataTableForm"), editPrimaryKey = '';
    //var messageTypeList = null, bufferMap = new Map();
    //$(document).ready(function ()
    const editor = {
        itemDescEditor: null,
        msgDescEditor: null
    }

    let {username, jumperAndParser, divWrap, NORMAL_MESSAGE_VALUE} = initPage(editor);

    if ($DataTableAPI != null) {
        $DataTableAPI.destroy();
    }

    const currentPar = jumperAndParser.parseQueryString(window.location.href);
    const currentMsgId = currentPar.messageId;
    // 标题是上一次点击的html
    let pastPar = JSON.parse(localStorage.getItem("pastPagePar"));

    $DataTableAPI = $DataTable.DataTable({
        /*ajax: {
            type: 'post',
            dataType: 'json',
            async: true,
            data: function (d) {
                d.search = $DataTable.DataTable().search(this.value);
                d.userDevice = 'web';
            },
            url: "/subject/listMessage" + jumperAndParser.parserQueryJSON(currentPar)
        },*/
        columns: [
            {
                data: "userUsername",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "messageDesc",
                render: (data, type, row) => {
                    return divWrap('<span>' + data + '</span>');
                }
            }, {
                data: "createTime",
                render: (data, type, row) => {
                    return divWrap(new Date(data).toLocaleString());
                }
            }
        ],
        processing: true,
        // sortable: true,
        // 服务器模式，把本来客户端所做的事情交给服务器去处理， 比如排序（order）、分页（paging）、过滤（filter）
        // 但如果服务器没有做这些事情的话显示的时候就会出问题 @see http://datatables.club/manual/server-side.html
        // serverSide: true,
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

    let isNotInited = true;

    const reloadData = () => {
        $.ajax({
            type: 'post',
            dataType: 'json',
            // url: "/item/query",  primaryKey
            url: "/subject/listMessage" + jumperAndParser.parserQueryJSON(currentPar),
            success: callbackClosure(function (data) {
                let currentItemId = -1;
                data.forEach(ele => {
                    if (isValidVar(ele.itemId)) {
                        // 0 表示不是普通消息
                        if (ele.messageType != 0) {
                            // $('#currentSubjectInfo').text(ele.messageDesc);
                            // 哈哈 区别出现啦 text 是将其转换为文本了的
                            $('#currentSubjectInfo').html(`<div style="background-color: aquamarine">${pastPar.publisher} 于 ${pastPar.publishTime} : </div> ${ele.messageDesc}`);
                            currentItemId = $('input[name=itemId]').val(ele.itemId);
                            if (ele.userUsername === username && isNotInited) {
                                $('.publish-new-msg').after(
                                    // "<span class='clickable option-col msg-opt-del' msgId='" + currentMsgId + "'> 编辑 </span>"
                                    "<span class='clickable option-col btn-modal-show subject-opt-edit'> 编辑主题 </span>"
                                );
                            }
                        } else {
                            // @see http://datatables.club/example/api/add_row.html
                            // https://cse.google.com/cse?cx=001171264216576386016:xim4af2d2ik&q=Datatable%20%E6%B7%BB%E5%8A%A0%E8%A1%8C&oq=Datatable%20%E6%B7%BB%E5%8A%A0%E8%A1%8C&gs_l=partner-generic.3..0l6.4791812.4805097.0.4805346.14.14.0.0.0.0.1500.7008.0j1j0j4j5j0j1j1j1.13.0.gsnos%2Cn%3D13...0.14057j24435291j27j1...1j4.34.partner-generic..7.7.2513.DAAsmkJdBww
                            // 没有列名的情况下
                            /*$DataTableAPI.row.add([
                                'col' + '1',
                                'col' + '2',
                                'col' + '3',
                            ]).draw();*/
                            $DataTableAPI.row.add(ele).draw();
                        }
                    } else {
                        console.assert(currentItemId === ele.itemId);
                    }
                });
                if (isNotInited) {
                    let $editModalBtn = $('.btn-modal-show.subject-opt-edit');
                    initDraggableModal($($editModalBtn.get(0)), $addAndEditModal, "编辑主题");
                    $editModalBtn.on('click', function () {
                        const $currentNode = $(this);
                        editPrimaryKey = currentMsgId;
                        $('textarea[name=messageDesc]').val($('#currentSubjectInfo').text());
                        editor.msgDescEditor.sync();
                        // $.messageBox("编辑呀");
                    });

                    // 这里是要求对两个模态框的消息类型做订制: 发布消息只能有普通消息类型, 编辑主题有除了普通消息外的类型
                    $('.btn-modal-show').on('click', function () {
                        $dataTableForm.resetFormValidCheck();
                        const $currentNode = $(this);
                        const $messageType = $('select[name=messageType]');
                        const optionList = $messageType.find('option');
                        let hasNotSelected = true;
                        // 判断是 发布消息 还是 编辑主题
                        if ($currentNode.text().indexOf("编辑") < 0) {
                            // 发布消息
                            $('.msg-title-dom').domHideSubInvalid();
                            optionList.each(i => {
                                const currentOp = optionList[i];
                                if (currentOp.value.toString() === NORMAL_MESSAGE_VALUE) {
                                    $(currentOp).domDisplaySubValid();
                                    if (hasNotSelected) {
                                        currentOp.selected = true;
                                        $(currentOp).trigger('change');
                                        hasNotSelected = false;
                                    } else {
                                        // do nothing
                                    }
                                } else {
                                    $(currentOp).domHideSubInvalid();
                                }
                            });
                        } else {
                            // 编辑主题
                            $('.msg-title-dom').domDisplaySubValid();
                            optionList.each(i => {
                                const currentOp = optionList[i];
                                if (currentOp.value.toString() === NORMAL_MESSAGE_VALUE) {
                                    $(currentOp).domHideSubInvalid();
                                } else {
                                    if (hasNotSelected) {
                                        currentOp.selected = true;
                                        $(currentOp).trigger('change');
                                        hasNotSelected = false;
                                    } else {
                                        // do nothing
                                    }
                                    $(currentOp).domDisplaySubValid();
                                }
                            });
                        }
                    });

                    isNotInited = false;
                } else {
                    // do nothing
                }
                // 标题是上一次点击的html
                localStorage.setItem("pastPagePar", JSON.stringify(pastPar))
                document.title = pastPar.title;
                $('#topInfo').text("关联物品: " + pastPar.itemName);
            }),
        });
    }

    initDraggableModal($($('.btn-modal-show').get(0)), $addAndEditModal, "发布消息");
    reloadData();

    AsyncLinkBufferChangeFactory({
        triggerSelector: 'select[id=onlyToTrigger]'
        , linkerSelector: 'select[name=messageType]'
        // , linkerBufferMap : bufferMap
        // , linkRequestUrl: '../subject/listSubjectType'
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
                            dataList.push(ele);
                            /*if (ele.name === '普通消息') {
                                dataList.push(ele);
                            } else {
                                // do nothing
                            }*/
                        });
                        successCallback(dataList);
                    } else {
                        console.error("数据请求失败!");
                    }
                },
            });
        }
    }).trigger('change', {selectLinkList: [0, -1]});

    const currentDate = new Date();
    // 只能选择[now-365天, now]范围内的日期
    $('input[name=itemPickUpTime]').initDateTimePickerBetween(calcNextDate(currentDate, -365), currentDate)
        .val(currentDate.format(DATE_TIME_FORMAT));


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
            messageDesc: {
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
        editor.msgDescEditor.sync();
        editor.itemDescEditor.sync();
        e.preventDefault();
        const tmpTitle =$('input[name=msgTitle]').val();
        const tmpItemName = $('input[name=itemName]').val();
        pastPar.title = isValidVar(tmpTitle) ? tmpTitle : pastPar.title;
        pastPar.itemName = isValidVar(tmpItemName) ? tmpItemName : pastPar.itemName;
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: $dataTableForm.serialize() + editPrimaryKey,
            url: (editPrimaryKey == "") ? "../subject/save" : "../subject/update",
            success: function (result) {
                tipsCallbackClosure($DataTableAPI, (editPrimaryKey == "" ? '发表消息' : '编辑'), $addAndEditModal, false)(result);
                editPrimaryKey = "";
                // $DataTableAPI.ajax.url().reload(null, false);
                $DataTableAPI.clear();
                reloadData();
                $DataTableAPI.draw();
            },
        });
        $dataTableForm.resetFormValidCheck().clearForm();
    });

    $('select[name=messageType]').on('change', function () {
        const $currentNode = $(this);
        if ($currentNode.val() === NORMAL_MESSAGE_VALUE) {
            $('.item-info').domHideSubInvalid();
        } else {
            $('.item-info').domDisplaySubValid();
        }
    });

});
