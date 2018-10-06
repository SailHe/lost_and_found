/**
 * Descriptions: 最短6位，最长16位 {6,16}
 * 可以包含小写大母 [a-z] 和大写字母 [A-Z]
 * 可以包含数字 [0-9]
 * 可以包含下划线 [ _ ] 和减号 [ - ]<p>
 *
 * @author SailHe
 * @date 2018/9/10 20:39
 */
const PATTERN_PASSWORD = /^[\w_-]{6,16}$/;
const DATE_FORMAT_DATEPICKER = "yy-mm-dd";
const DATE_FORMAT = "yyyy-MM-dd";


//p1
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "H+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

/**
 * Descriptions: 初始化一个固定格式化的jQUI时间选择输入框<p>
 *
 * @author SailHe
 * @date 2018/10/6 10:00
 */
$.fn.initDatePicker = function () {
    return this.prop("readonly", true).datepicker({
        changeMonth: true,
        dateFormat: DATE_FORMAT_DATEPICKER,
    });
}

$.fn.rangeDatePicker = function ($endDatePickerInput) {

    function initRangeDatePicker($start, $end) {
        //设置默认时间
        // $start.val(new Date().format(DATE_FORMAT));
        // $end.val(new Date().format(DATE_FORMAT));
        $start.prop("readonly", true).datepicker({
            changeMonth: true,
            dateFormat: DATE_FORMAT_DATEPICKER,
            onClose: function (selectedDate) {
                $end.datepicker("option", "minDate", selectedDate);
            }
        });
        $end.prop("readonly", true).datepicker({
            changeMonth: true,
            dateFormat: DATE_FORMAT_DATEPICKER,
            onClose: function (selectedDate) {
                $start.datepicker("option", "maxDate", selectedDate);
                $end.val($(this).val());
            }
        });
    }

    initRangeDatePicker(this, $endDatePickerInput);
    //批量设置默认时间
    $('.date-time-picker').val(new Date().format(DATE_FORMAT));
}

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
                            if (result.success === true && typeof (result.data) !== 'undefined') {
                                localStorage.jwt = result.data.userToken;
                                localStorage.setItem('username', result.data.userName);
                                localStorage.setItem('userId', result.data.userId);
                                //session ?
                                localStorage.setItem('stationId', result.data[3]);
                                // window.location.href = "/workbench.html";
                                window.location.href = "/business/lafmessage.html";
                            } else {
                                $.messageBox(result.msg);
                                $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);
                            }
                        } else {
                            $.messageBox("系统错误，请与管理员联系!");
                            $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);
                        }
                    }
                });
            } else {
                $.messageBox("验证码错误!");
                $("#code").val("").focus();
                $('#signInForm').bootstrapValidator('disableSubmitButtons', false).bootstrapValidator('resetForm', true);
            }
        });

    const fields = {
        userUsername: {
            //可以有多个验证信息
            validators: {
                //非空验证
                notEmpty: {
                    //提示信息，当你不写这里时它会自动的调用自带的提示信息，默认是英文，可导入language下的中文JS文件
                    message: "请输入用户名！！！"
                },
                //长度限制（中文字符算一个）
                stringLength: {
                    min: 4,
                    max: 16,
                    message: "长度在4到16位之间！！！"
                }
            }
        },
        userPassword: {
            validators: {
                notEmpty: {
                    message: "请输入密码！！！"
                }, regexp: {
                    regexp: PATTERN_PASSWORD,
                    message: "最短6位，最长16位, "
                }, identical: {
                    field: 'confirmPassword',
                    message: "两次输入的密码不一致！！！"
                }
            }
        },
        confirmPassword: {
            validators: {
                notEmpty: {
                    message: "请输入确认密码！！！"
                },
                //用来判断制定的字段和当前字段一致与否
                identical: {
                    field: 'userPassword',
                    message: "两次输入的密码不一致！！！"
                }
            }
        },
        idCard: {
            validators: {
                notEmpty: {
                    message: "请输入身份证号！！！"
                },
                regexp: {
                    regexp: /^[1-9]\d{14}(\d{2}[0-9x])?$/,
                    message: "输入的身份证号不对！！！"
                }
            }
        },
        userEmailAddress: {
            validators: {
                notEmpty: {
                    message: "请输入邮箱！！！"
                },
                emailAddress: {
                    message: "输入的邮箱格式不对！！！"
                }
            }
        }
    }

    $('input[name=userBirthday]').initDatePicker().val(new Date().format(DATE_FORMAT));

    $('#signUpForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'fa fa-ok',
            invalid: 'fa fa-remove',
            validating: 'fa fa-refresh'
        },
        fields: fields
    }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target);
        $.ajax({
            url: 'user/signUp',
            type: 'post',
            data: $form.serialize(),
            dataType: 'json',
            success: function (result) {
                if (result !== null && typeof (result) !== "undefined") {
                    if (result.success === true && typeof (result.msg) !== 'undefined') {
                        $.messageBox(result.msg);
                    } else {
                        $.messageBox("系统异常!");
                    }
                } else {

                }
            }
        });
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
