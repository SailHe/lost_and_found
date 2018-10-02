$(function () {
    // 全局异步异常处理
    $.ajaxSetup({
        headers: {
            "MaYoung_Token": localStorage.jwt
        },
        complete: function (xhr, status) {
            if (localStorage.jwt !== null && localStorage.jwt !== undefined) {
                xhr.setRequestHeader("MaYoung_Token", localStorage.jwt);
            }
            else {
                bootbox.confirm({
                    buttons: {
                        confirm: {
                            label: '<i class="fa fa-check"></i> 确定',
                            className: 'btn btn-primary btn-flat'
                        },
                        cancel: {
                            label: '<i class="fa fa-close"></i> 取消',
                            className: 'btn btn-warning btn-flat pull-left'
                        }
                    },
                    message: '<i class="fa fa-question-circle-o"></i> <b class="customer-title">登录信息已过期，请重新登录！</b>',
                    callback: function () {
                        localStorage.clear();
                        window.location.replace("../login.html");
                    }
                });
            }
        }
    });
    $.getAuthorityByIds();
});
