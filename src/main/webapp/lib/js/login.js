$(() => {

});

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
const PATTERN_EMAIL_ADDRESS = /^[-\w.]{0,64}@([a-zA-Z0-9]{1,63}\.)*[-a-zA-Z0-9]{1,63}$/;
let isValid = true;

$('input[name=loginInButton]').on('click', () => {
    $.messageBox("欢迎回来!");
    $.messageBox("用户" + $('.sign-in-htm input[name=username]').val());
    $('#fiel').load("./home.html");
});

$('input[name=loginUpButton]').on('click', () => {
    $.messageBox("登录成功!");
    $.messageBox("你的生日: ", 'alert_');
    let birthday = $('input[name=idCard]').val().substring(6, 6 + 8);
    $.messageBox(
        birthday.substring(0, 4) + "年"
        + birthday.substring(4, 4 + 2) + "月"
        + birthday.substring(4 + 2) + "日"
        , 'alert_'
    );
});

//blur
$('form').on('onkeyup', function () {

}).find(':input').on('input', function () {
    //$.messageBox(`触发${$(this).prev('label').text()}验证!`);
    const feedbackIcons = {
        valid: 'fa fa-ok',
        invalid: 'fa fa-remove',
        validating: 'fa fa-refresh'
    }
    isValid = true;
    const fields = {
        username: {
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
        loginInPassword: {
            validators: {
                notEmpty: {
                    message: "请输入密码！！！"
                }, regexp: {
                    regexp: PATTERN_PASSWORD,
                    message: "最短6位，最长16位, "
                }/*, regexp: {
                    regexp: /"[\\w_-]{6,16}"/,
                    message: "最短6位，最长16位的大小写字母"
                }*/
            }
        },
        loginUpPassword: {
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
                    field: 'loginUpPassword',
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
        emailAddress: {
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
    const validatorField = fields[this.name];
    if (isValidVar(validatorField)) {
        //$.messageBox(`验证名: ${this.name}`);
        const validators = validatorField['validators'];
        if (isValidVar(validators)) {
            //$.messageBox(`验证结果: ${ PATTERN_PASSWORD.test(this.value)}`);
            for (let validatorName in validators) {
                let validator = validators[validatorName];
                let validSuccess = false;
                switch (validatorName) {
                    case 'notEmpty' :
                        validSuccess = isValidVar(this.value);
                        break;
                    case 'identical' :
                        validSuccess = $(this).closest('form').find(`:input[name=${validator['field']}]`).val() === (this.value);
                        break;
                    case 'stringLength' :
                        validSuccess = betweenNumLORC(
                            validator['min'], this.value.length
                            , parseFloat(validator['max']) + 1
                        );
                        break;
                    case 'regexp' :
                        validSuccess = validator['regexp'].test(this.value);
                        break;
                    case 'emailAddress' :
                        validSuccess = PATTERN_EMAIL_ADDRESS.test(this.value);
                        break;
                    default :
                        "";
                        break;
                }
                isValid = isValid &&validSuccess;
                if (!validSuccess) {
                    $.messageBox(`${validator['message']}`);
                }
            }
        }
    }
    $.messageBox(`验证${isValid ? "成功" : "失败"}`);
});
