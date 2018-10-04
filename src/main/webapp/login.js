$(function () {
    var verifyCode = new GVerify("v_container");
    $('#signInForm').bootstrapValidator({})
        .on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target);
            var res = verifyCode.validate(document.getElementById("code").value);
            if (res) {
                $.ajax({
                    url: 'user/signIn',
                    type: 'post',
                    data: $form.serialize(),
                    dataType: 'json',
                    success: function (result) {
                        if (result !== null && typeof (result) !== "undefined") {
                            if (result.success === true && typeof (result.data) !== 'undefined' ) {
                                localStorage.jwt = result.data.userToken;
                                localStorage.setItem('username',result.data.userName);
                                localStorage.setItem('userId',result.data.userId);
                                //session ?
                                localStorage.setItem('stationId',result.data[3]);
                                // window.location.href = "/workbench.html";
                                window.location.href = "dataTableDemo/dataTableDemo.html";
                            } else {
                                bootbox.alert({
                                    message: '<i class="fa fa-question-circle-o"></i> <b class="customer-title">用户名或密码错误</b>',
                                    buttons: {
                                        ok: {
                                            label: '<i class="fa fa-check"></i> 确定',
                                            className: 'btn btn-primary btn-flat'
                                        }
                                    }
                                });
                                $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);2
                            }
                        } else {
                            bootbox.alert({
                                message: '<i class="fa fa-question-circle-o"></i> <b class="customer-title">系统错误，请于系统管理员联系</b>',
                                buttons: {
                                    ok: {
                                        label: '<i class="fa fa-check"></i> 确定',
                                        className: 'btn btn-primary btn-flat'
                                    }
                                }
                            });
                            $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);
                        }
                    }
                });
            }
            else {
                $.messageBox("验证码错误!");
                /*bootbox.alert({
                    message: '<i class="fa fa-question-circle-o"></i> <b class="customer-title">验证码错误！！</b>',
                    buttons: {
                        ok: {
                            label: '<i class="fa fa-check"></i> 确定',
                            className: 'btn btn-primary btn-flat'
                        }
                    }
                });*/
                $("#code").val("").focus();
                $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);
            }
        });
});

function display() {
    if ($("#password").attr("type") === "input") {
        $("#password").attr('type', 'password');
        $("#display").css("background-image", "url(assets/images/common/icon-1.png)");
    }
    else {
        $("#password").attr('type', 'input');
        $("#display").css("background-image", "url(assets/images/common/icon2.png)");
    }
}
