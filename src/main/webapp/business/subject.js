var $DataTable = $('#informationTable'), $DataTableAPI = null;
var $addAndEditModal = $('#informationModal'), $dataTableForm = $("#dataTableForm"), editPrimaryKey = '';
//var messageTypeList = null, bufferMap = new Map();
//$(document).ready(function ()
$(function () {

    // ============ init start ===============

    let username = localStorage.getItem('username');
    if (isValidVar(username)) {
        $('#userSingA').html(username);
    } else {
        // 强制返回
        window.location.href = '/login.html';
    }

    $('#signOutSpan').on('click', function () {
        const $currentNode = $(this);
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: username,
            url: "../user/signOut",
            success: function (result) {
                console.log(result);
                localStorage.clear();
                window.location.href = '/login.html';
            },
        });
    });

    $('#userSingA').on('click', function () {
        const $currentNode = $(this);
        if (isValidVar($currentNode.text())) {
            $.messageBox(username + "欢迎使用失物招领互助论坛!");
        } else {
            window.location.href = '/login.html';
        }
    });

    $('input[name=userId]').val(username);

    const jumperAndParser = new JumperAndParser();

    // ============ init end ===============

    function divWrap(data) {
        return "<div style='text-align: center' class='flex-box-div'> " + data + "</div>";
    }

    const noPicUrl = 'plugins/assets/images/common/nopic.jpg';
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
            url: "../subject/queryPage"
        },
        columns: [
            {
                /*data: null*/
                data: "msgImgUrls",
                render: (data, type, row) => {
                    return divWrap('<img src="' + (isValidVar(data) ? data : noPicUrl) + '" style="width: 50%;">');
                }
            }, {
                data: "itemName",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "messageDesc",
                render: (data, type, row) => {
                    debugLog(row);
                    /*
                    itemName:"小明的校园卡"
                    messageDesc:"又捡了一张"
                    messageId:9
                    messageType:"拾取物品"
                    msgImgUrls:"../lib/plugins/assets/images/common/2011060400304367.jpg"
                    publishTime:"2018-10-09 00:00:00"
                    userNickname:"昵称"
                    */
                    return divWrap('<span class="clickable subject" messageId="' + parseInt(row.messageId) + '" >'
                        //+ row.messageType + ": " + row.itemName +
                        + data.substring(0, 5) +
                        '</span>');
                }
            }/*, {
            //详情里面加载
                data: "msgImgUrls"
            }*/, {
                data: "messageType",
                render: (data, type, row) => {
                    return divWrap(data);
                }
            }, {
                data: "publishTime",
                render: (data, type, row) => {
                    return divWrap(data);
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
                localStorage.setItem("pastPagePar", currentMsgId);
                jumperAndParser.jumperToTarget('topic.html', {
                    messageId: currentMsgId
                });
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
        , linkRequestUrl: '../subject/listSubjectType'
        , idName: 'value'
        , dataName: 'name'
    }).trigger('change', {selectLinkList: [0, -1]});

    $('input[name=itemPickUpTime]').initDatePicker().val(new Date().format(DATE_FORMAT));

    initDraggableModal($($('.btn-modal-show').get(0)), $addAndEditModal);


    $dataTableForm.bootstrapValidator({
        feedbackIcons: {
            valid: 'fa fa-ok',
            invalid: 'fa fa-remove',
            validating: 'fa fa-refresh'
        },
        fields: {
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
        e.preventDefault();
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: $dataTableForm.serialize() + editPrimaryKey,
            url: (editPrimaryKey == "") ? "../subject/save" : "../subject/update",
            success: tipsCallbackClosure($DataTableAPI, (editPrimaryKey == "" ? '添加' : '编辑'), $addAndEditModal),
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

