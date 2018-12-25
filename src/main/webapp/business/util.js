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
