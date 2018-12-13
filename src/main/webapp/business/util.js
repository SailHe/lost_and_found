
/**
 * Descriptions: 请求跳转与参数解析器<p>
 *
 * @author SailHe
 * @date 2018/12/13 14:29
 */
function RequestParser() {
    var baseUrl = "/business";

    /**
     * Descriptions: 跳转至目标页面<p>
     *
     * 可以跟参数对象
     * new RequestParser().toTarget("topic.html", {})
     * @author SailHe
     * @date 2018/12/13 14:27
     */
    this.toTarget = function (targetPage, paramsJSON) {
        if (targetPage.indexOf('/') > 0) {
            // do nothing
        } else {
            baseUrl += '/';
        }

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
        window.location.href = baseUrl + targetPage + paramsBody;
    }

    /**
     * Descriptions: 解析url参数<p>
     *
     * new RequestParser().parseQueryString(window.location.href)
     * @author SailHe
     * @date 2018/12/13 14:29
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
}
