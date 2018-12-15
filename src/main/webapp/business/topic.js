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

    // ============ init end ===============

    function divWrap(data) {
        return "<div style='text-align: center' class='flex-box-div'> " + data + "</div>";
    }

    const noPicUrl = 'plugins/assets/images/common/nopic.jpg';
    if ($DataTableAPI != null) {
        $DataTableAPI.destroy();
    }

    const jumperAndParser = new JumperAndParser();
    const currentPar = jumperAndParser.parseQueryString(window.location.href);
    const currentMsgId = currentPar.messageId;

    // 标题是上一次点击的html
    document.title = localStorage.getItem("pastPagePar");
    $('#topInfo').text('物品名');

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
                data: "msgImgUrls",
                render: (data, type, row) => {
                    return divWrap('<img src="' + (isValidVar(data) ? data : noPicUrl) + '" style="width: 50%;">');
                }
            }, {
                data: "messageDesc",
                render: (data, type, row) => {
                    return divWrap('<span>' + data + '</span>');
                }
            }, {
                data: "createTime",
                render: (data, type, row) => {
                    return divWrap(data);
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

    $.ajax({
        type: 'post',
        dataType: 'json',
        // url: "/item/query",  primaryKey
        url: "/subject/listMessage" + jumperAndParser.parserQueryJSON(currentPar),
        success: callbackClosure(function (data) {
            data.forEach(ele => {
                // 0 表示不是普通消息
                if (ele.messageType != 0) {
                    $('#currentSubjectInfo').text(ele.messageDesc);
                } else {
                    let counter = 'row';
                    $DataTableAPI.row.add( [
                        counter +'.1',
                        counter +'.2',
                        counter +'.3',
                    ] ).draw();
                }
            });
        }),
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
