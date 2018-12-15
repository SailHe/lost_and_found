//一个dataTable中 API 实例
// @see http://localhost:8989/demo/dataTableDemo/dataTableDemo.html
var $DataTableAPI = $('#example').DataTable({
    // 初始化请求
    ajax: {
        // 1.可以直接指定json数据源
        // url: "data.json",

        // 2.也可以请求服务器数据
        type: 'post',
        dataType: 'json',
        async: true,
        data: {
            search: '%%'
        },
        url: "/user/fuzzyQuery"
    },
    //每页显示4条数据
    pageLength: 4,
    columns: [
        {
            //此列不绑定数据源，用来显示序号
            data: null
        }, {
            data: "userUsername"
        }, {
            data: "userRealname"
        }, {
            data: "userSex"
        }
    ],
    //解决冲突 columns 定义的属性将始终优先于在 columnDefs 中定义的属性的任何值。
    "columnDefs": [{
        /*
            0或一个正整数 - 列索引从左边开始计数
            一个负整数 - 列索引从右边算起
            一个字符串类的名字将在列上与TH匹配
            字符串_all- 所有列（即分配一个默认值）
        targets可以是上面列表中的单个选项，也可以是选项数组（如果需要，可以在数组中混合使用不同的类型）。
            例如，targets: [ -1, -2 ]将针对表格中的最后一列和最后一列。
        */
        /*在第一列上禁用筛选：
            "targets": 0,
            "searchable": false
        */
        /*第一列和第二列将在表格中可见，而所有其他列将被隐藏。
            { targets: [0, 1], visible: true},
            { targets: '_all', visible: false }
        */
        /*隐藏第一列
            "visible": false,
            "targets": 0
        */
    }, {
        "render": function (data, type, row, meta) {
            //渲染 把数据源中的标题和url组成超链接
            return '<a href="' + data + '" target="_blank">' + row.title + '</a>';
        },
        //指定是第三列
        "targets": 2
    }],

    /*
    "lengthChange": false, // 禁止选择每页显示条数
    "ordering": false, // 禁止排序
    "searching": false, // 禁止搜索
    */
    "columnDefs": [
        {"visible": true, "targets": 0}
    ],
    "displayLength": 25,
    /*
    preDrawCallback在重绘表格前执行，你可以用来显示之前做更新或者清除操作，比如移除事件。当方法返回false时, 还可以用来取消重绘操作
    Datatables每次重绘后执行的方法(当每次表格重绘的时候触发一个操作，比如更新数据后或者创建新的元素),
    需要注意的是，需要禁用dataTables的选择每页显示条数、排序和搜索功能，
    因为这几项都会修改table的展示，每一次都会调用drawCallback，从而会造成table变形和数据丢失的情况。*/
    "drawCallback": function (settings) {
    }
});

//前台添加序号
//关于order.dt: https://segmentfault.com/q/1010000004892790 或是 https://www.datatables.net/reference/event/
$DataTableAPI.on('order.dt search.dt',
    function () {
        $DataTableAPI.column(0, {
            "search": 'applied',
            "order": 'applied'
        }).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();

// 当初始化方式是json文件时可以 更换数据源（相同格式，但是数据内容不同）
$("#redraw").click(function () {
    var url = $DataTableAPI.ajax.url('./newData.json');
    url.load().on('order.dt search.dt', function () {
        console.log("新数据加载完毕");
    });
});

// 当初始化方式是ajax请求时 可以更换url发送请求
$("#redrawFromServer").on('click', function () {
    var url = $DataTableAPI.ajax.url('/user/fuzzyQuery');
    url.load().on('order.dt search.dt', function () {
        console.log("服务器数据加载完毕");
    });
});

// 重载
$("#reloadDataTable").on('click', function () {
    $DataTableAPI.ajax.reload( function(resultJson) {
        console.log(resultJson);
    }, true);
});
