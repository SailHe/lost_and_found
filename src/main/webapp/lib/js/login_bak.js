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

$('input[name=loginInButton]').on('click', () => {
    $.messageBox("欢迎回来!");
    $.messageBox("用户" + $('.sign-in-htm input[name=username]').val());
    $('#fiel').load("./home.html");
});

$('input[name=loginUpButton]').on('click', () => {
    $.messageBox("登录成功!");
    $.messageBox("你的生日: ", 'alert');
    let birthday = $('input[name=idCard]').val().substring(6, 6 + 8);
    $.messageBox(
        birthday.substring(0, 4) + "年"
        + birthday.substring(4, 4 + 2) + "月"
        + birthday.substring(4 + 2) + "日"
        , 'alert'
    );
});

//下面就是bootstrapValidator的初始化 定义你需要的哪些表单需要验证，验证什么内容
$("#defaultForm").bootstrapValidator({
    //这里是用来对应三种不同状态时，在输入框后面添加的图标
    feedbackIcons: {
        valid: 'fa fa-ok',
        invalid: 'fa fa-remove',
        validating: 'fa fa-refresh'
    },
    //哪些字段需要验证，和html中的输入框，下拉框等等表单name属性所对应。
    fields: {
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
        }, password: {
            validators: {
                notEmpty: {
                    message: "请输入密码！！！"
                }, regexp: {
                    regexp: PATTERN_PASSWORD,
                    message: "最短6位，最长16位, "
                }, regexp: {
                    regexp: "[\\w_-]{6,16}",
                    message: "最短6位，最长16位的大小写字母"
                }
            }
        }, confirmPassword: {
            validators: {
                notEmpty: {
                    message: "请输入确认密码！！！"
                },
                //用来判断制定的字段和当前字段一致与否
                identical: {
                    field: 'password',
                    message: "两次输入的密码不一致！！！"
                }
            }
        }, idCard: {
            validators: {
                notEmpty: {
                    message: "请输入身份证号！！！"
                },
                regexp: {
                    regexp: '^[1-9]\\d{14}(\\d{2}[0-9x])?$',
                    message: "输入的身份证号不对！！！"
                }
            }
        }, emailAddress: {
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
});
