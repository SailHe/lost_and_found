$(function () {
    var $DataTable = $('#informationTable'), $DataTableAPI = null;
    var $addAndEditModal = $('#informationModal'), $dataTableForm = $("#dataTableForm"), editPrimaryKey = '';
    //var messageTypeList = null, bufferMap = new Map();
    //$(document).ready(function ()
    let itemDescEditor = null;
    let msgDescEditor = null;
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
            url: "/user/signOut",
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

    // $('input[name=userId]').val(username);
    $('input[name=userUsername]').val(username);

    // @see https://my.oschina.net/ShaneJhu/blog/172956
    // http://kindeditor.net/doc.php
    const editorSetting = {width: '100%', height: '100%', resizeType: 1};
    // git tracking 后就变为function的颜色了
    KindEditor.ready(function (K) {
        msgDescEditor = K.create('#msgDescEditorContent', editorSetting);
        itemDescEditor = K.create('#itemDescEditorContent', editorSetting);
    });

    // ============ init end ===============

    function divWrap(data) {
        return "<div style='text-align: center' class='flex-box-div'> " + data + "</div>";
    }

    const noPicUrl = '/lib/plugins/assets/images/common/nopic.jpg';
    if ($DataTableAPI != null) {
        $DataTableAPI.destroy();
    }

    const jumperAndParser = new JumperAndParser();
    const currentPar = jumperAndParser.parseQueryString(window.location.href);
    const currentMsgId = currentPar.messageId;

    // 标题是上一次点击的html
    const pastPar = JSON.parse(localStorage.getItem("pastPagePar"));
    document.title = pastPar.title;
    $('#topInfo').text("关联物品: " + pastPar.itemName);

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
                data: "msgTitle",
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
                            $('#currentSubjectInfo').html(ele.messageDesc);
                            currentItemId = $('input[name=itemId]').val(ele.itemId);
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
            }),
        });
    }

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
                            if (ele.name === '普通消息') {
                                dataList.push(ele);
                            } else {
                                // do nothing
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

    $('input[name=itemPickUpTime]').initDatePicker().val(new Date().format(DATE_FORMAT));

    initDraggableModal($($('.btn-modal-show').get(0)), $addAndEditModal);


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
        msgDescEditor.sync();
        itemDescEditor.sync();
        e.preventDefault();
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: $dataTableForm.serialize() + editPrimaryKey,
            url: (editPrimaryKey == "") ? "../subject/save" : "../subject/update",
            success: function (result) {
                tipsCallbackClosure($DataTableAPI, (editPrimaryKey == "" ? '添加' : '编辑'), $addAndEditModal, false)(result);
                // $DataTableAPI.ajax.url().reload(null, false);
                $DataTableAPI.clear();
                reloadData();
                $DataTableAPI.draw();
            },
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
