/**
 * Descriptions: 请求跳转与参数解析器<p>
 *
 * @author SailHe
 * @date 2018/12/13 14:29
 * @see https://www.w3cschool.cn/json/1koy1piy.html
 */
function JumperAndParser() {
    var baseUrl = "/business";

    /**
     * Descriptions: 解析url参数 为JSON对象<p>
     *
     * new JumperAndParser().parseQueryString(window.location.href)
     * @author SailHe
     * @date 2018/12/13 14:29
     * @see https://blog.csdn.net/AinUser/article/details/78882492
     */
    this.parseQueryString = function (url) {
        var obj = {};
        var keyvalue = [];
        var key = "", value = "";
        var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
        for (var i in paraString) {
            keyvalue = paraString[i].split("=");
            key = keyvalue[0];
            value = keyvalue[1];
            obj[key] = value;
        }
        return obj;
    }

    /**
     * Descriptions: 将参数JSON对象解析为BodyString<p>
     *
     * @author SailHe
     * @date 2018/12/13 14:47
     */
    this.parserQueryJSON = function (paramsJSON) {
        let paramsBody = null;
        let parKeyList = Object.keys(paramsJSON);
        if (parKeyList.length === 0) {
            paramsBody = "";
        } else {
            paramsBody = "?";
        }

        paramsBody += parKeyList.map(function (key) {
            // body...
            return encodeURIComponent(key) + "=" + encodeURIComponent(paramsJSON[key]);
        }).join("&");

        return paramsBody;
    }

    /**
     * Descriptions: 跳转至目标页面<p>
     *
     * 可以跟参数对象
     * new JumperAndParser().jumperToTarget("topic.html", {})
     * @author SailHe
     * @date 2018/12/13 14:27
     */
    this.jumperToTarget = function (targetPage, paramsJSON) {
        if (targetPage.indexOf('/') > 0) {
            // do nothing
        } else {
            baseUrl += '/';
        }
        window.location.href = baseUrl + targetPage + this.parserQueryJSON(paramsJSON);
    }

}

/**
 * Descriptions: ajax请求结果判断闭包<p>
 *
 * @author SailHe
 * @date 2018/12/13 15:20
 */
function callbackClosure(successFun, failureFun, tipsMessagePrefix) {
    tipsMessagePrefix == undefined ? tipsMessagePrefix = "操作" : '';
    return function tipsCallBack(result) {
        if (result.success) {
            debugLog(tipsMessagePrefix + "成功！");
            if (isValidVar(successFun)) {
                successFun(result.data);
            } else {
                debugLog("成功处理方法错误");
            }
        }
        else {
            debugLog(tipsMessagePrefix + "失败！", "alert");
            if (isValidVar(failureFun)) {
                failureFun(result.data);
            } else {
                debugLog("失败处理方法错误");
            }
        }
    }
}

/**
 * Descriptions: 初始化一个论坛页面 当然, 标记什么的得相同<p>
 *  若editor未定义或者为null 则不会初始化KindEditor(富文本编辑器)
 * @author SailHe
 * @date 2019/1/1 18:05
 */
function initPage(editor) {
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

    // $('input[name=userId]').val(username);
    $('input[name=userUsername]').val(username);

    const jumperAndParser = new JumperAndParser();

    if (isValidVar(editor)) {
        // @see
        // http://datatables.club/
        // https://my.oschina.net/ShaneJhu/blog/172956
        // http://kindeditor.net/doc.php
        // http://kindeditor.net/docs/option.html#id70
        const editorSetting = {width: '100%', height: '100%', resizeType: 1};
        // git tracking 后就变为function的颜色了
        KindEditor.ready(function (K) {
            // 其实editor 在方法返回时并没有被初始化 因此使用一个对象引用
            editor.msgDescEditor = K.create('#msgDescEditorContent', editorSetting);
            editor.itemDescEditor = K.create('#itemDescEditorContent', editorSetting);
        });
    } else {
        // do nothing
    }

    $('#userSingA').on('click', function () {
        const $currentNode = $(this);
        if (isValidVar($currentNode.text())) {
            //$.messageBox(username + "欢迎使用失物招领互助论坛!");
            jumperAndParser.jumperToTarget("userInfo.html", {username: username});
        } else {
            window.location.href = '/login.html';
        }
    });

    /**
     * Descriptions: 返回一个居中显示的div Dom<p>
     *
     * @author SailHe
     * @date 2019/1/1 20:02
     */
    const divWrap = (data, customClass = "") => {
        return "<div style='text-align: center' class='flex-box-div " + customClass + "'> " + data + "</div>";
    }

    const showLimitLenStr = (data, maxShowLen) => {
        // keywords: [js judge text html]
        // @see https://stackoverflow.com/questions/15458876/check-if-a-string-is-html-or-not
        const isHtml = /<[a-z][\s\S]*>/i.test(data);
        // 防止html分割显示错误
        return (isHtml ? "'" + data.substring(0, maxShowLen)
            + "'" : data.substring(0, maxShowLen))
            + (data.length > maxShowLen ? "..." : "");
    }
    const NORMAL_MESSAGE_VALUE = '0';
    const NO_PIC_URL = '/lib/plugins/assets/images/common/nopic.jpg';

    // ============ init end ===============
    return {username, jumperAndParser, divWrap, showLimitLenStr, NO_PIC_URL, NORMAL_MESSAGE_VALUE};
}
