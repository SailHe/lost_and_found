var $DataTable = $('#exampleTable'), $DataTableAPI = null;
$(document).ready(function () {
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
                    return divWrap('<a href="' + row.messageId + '">' + data + '</a>');
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
});

$(function () {
    /**
     * Descriptions: 初始化一个可拖拽的Bootstrap Modal<p>
     *
     * @author SailHe
     * @date 2018/9/12 11:21
     */
    const initDraggableModal = ($button, $modal) => {
        //设置初始化
        $modal.modal({
            //点击空白处关闭
            backdrop: 'static',
            //escape 键退出
            keyboard: false,
            focus: true,
            //初始化后显示与否
            show: false,
        }).on('show.bs.modal', function (e) {
            console.log('显示事件触发');
        })
            .on('shown.bs.modal', function () {
                $('#goodsSearchText').trigger('focus');
                console.log("显示完成");
            })
            //显示
            //.modal('aop')
            //触发一下就关闭
            //.modal('toggle')
            //.modal('hide')
            /*.modal('handleUpdate')
            .modal('dispose')*/
            .on('hide.bs.modal', function () {
                console.log('关闭事件触发');
            })
            .on('hidden.bs.modal', function () {
                console.log('已关闭');
            })
        ;//处理点击事件
        $button.on('click', function (event) {
            event.preventDefault();
            $modal.show(
                '500',
                function () {
                    const modal = $(this);
                    modal.find('.modal-title').text('可拖拽Modal');
                    $.ajax({});
                }
            );
            //完成拖拽 基于jQ-UI
            $modal.draggable({
                cursor: "move",
                handle: '.modal-header'
            });
            //显示
            $modal.modal('show');
        });
    }
    initDraggableModal($($('.btn-modal-show').get(0)), $('#exampleModal2'));
});

AsyncLinkBufferChangeFactory({
    triggerSelector: 'select[id=onlyToTrigger]'
    , linkerSelector: 'select[name=subjectType]'
    , linkRequestUrl: '../subject/listSubjectType'
    , idName: 'value'
    , dataName:'name'
}).trigger('change', {selectLinkList: [0, -1]});
