/**
 * Descriptions: 属性原型定义<p>
 * @param volume, taste || jsonString || {volume, taste}
 * @author SailHe
 * @date 2018/7/23 19:41
 */
function GoodsSkuAttr() {
    var args = arguments;
    this.goodsSkuVolume = -1;
    this.goodsSkuTaste = '未知';
    // 单位: (毫升) 当前这是个静态字段 若之后这个字段变为动态的 直接在此处构造即可
    this.goodsSkuUnit = 'ml';

    //引用类型
    if (typeof args[0] === "object" && typeof args[0] !== "undefined") {

        if (args[0] === null || args[0] === undefined) {
            console.error('参数错误 at GoodsSkuAttr:  object=' + args[0] + '; \n');
            debugger;
        }

        if (typeof args[0].goodsSkuVolume !== "undefined") {
            this.goodsSkuVolume = args[0].goodsSkuVolume;
        }

        if (typeof args[0].goodsSkuTaste !== "undefined") {
            this.goodsSkuTaste = args[0].goodsSkuTaste;
        }

    } else {

        if (typeof args[0] === "string" && typeof args[1] === "undefined") {
            //json constructor
            var goodsSkuAttrJson = args[0];
            if (goodsSkuAttrJson !== null) {
                try {
                    var tempGoodsSkuAttr = JSON.parse(goodsSkuAttrJson);
                    var volume = tempGoodsSkuAttr.goodsSkuVolume;
                    var taste = tempGoodsSkuAttr.goodsSkuTaste;
                    this.goodsSkuVolume = volume === undefined ? '未知' : volume;
                    this.goodsSkuTaste = taste === undefined ? '未知' : taste;
                } catch (e) {
                    console.error('JSON解析错误 at GoodsSkuAttr:  goodsSkuAttrJson=' + goodsSkuAttrJson + '; \n' + e);
                    debugger;
                }
            } else {
                console.error("goodsSkuAttrJson 为 null at GoodsSkuAttr");
                debugger;
            }
        } else {
            if (typeof args[0] !== "undefined") {
                this.goodsSkuVolume = args[0];
            }

            if (typeof args[1] !== "undefined") {
                this.goodsSkuTaste = args[1];
            }
        }

    }

    //@Override toString方法的重写
    GoodsSkuAttr.prototype.toString = function () {
        return '容量: ' + this.goodsSkuVolume + this.goodsSkuUnit + '; <br> 口味: ' + this.goodsSkuTaste;
    }
}

var DEBUG__ = undefined;

var enumIs = {
    NO: 0,
    YES: 1,
}

var enumCategoryGrade = {
    BIG: 0,
    MIDDLE: 1,
    SMALL: 2,
}

/**
 * Descriptions: 动态下拉框的success闭包构造函数<p>
 *
 * @param eventParam requestSuccessfulEvent(请求成功)事件的参数
 * @author SailHe
 * @date 2018/5/8 19:47
 */
function dynamicSuccessClosure($dropdownAble, iterativeProcessingFun, eventParam) {
    return function (result) {
        //var displayed = new Array(); indexOf
        $dropdownAble.empty();
        for (var i = 0; i < result.data.length; ++i) {
            iterativeProcessingFun($dropdownAble, result.data[i]);
        }
        //触发自定义请求成功事件
        $dropdownAble.trigger("requestSuccessfulEvent", eventParam);
    }
}

/**
 * Descriptions: 基础的分类请求函数<p>
 * @param $dropdownAble jQuery对象 其绑定的是一个可下拉的元素(比如select菜单)
 * @param gradeName 向后端请求的参数值 即类别级别名
 * @param iterativeProcessingFun($dropdownAble, dataDTO)
 * @author SailHe
 * @date 2018/4/16 9:38
 */
function dynamicLoadClassification($dropdownAble, gradeName, iterativeProcessingFun) {
    //异步动态请求 + success回调时加载
    return $.ajax({
        type: "post",
        dataType: "json",
        data: {
            typeOfClassificationName: gradeName
        },
        url: "goodsCategory/listSibling",
        success: dynamicSuccessClosure($dropdownAble, iterativeProcessingFun)
    });
}

$.fn.dynamicLoadPromotionType = function (appendFun, eventParam) {
    return $.ajax({
        type: "post",
        dataType: "json",
        url: "promotion/listAllType",
        success: dynamicSuccessClosure($(this), appendFun, eventParam)
    });
}

/**
 * Descriptions: 刷新所有带有.dynamic-load的css类的下拉菜单 下的第一个 下拉菜单   只支持两个下拉菜单
 * 动态加载的步骤: 初始化-加载-增删改后刷新<p>
 *     @TODO 缓存
 *
 * @param $DataTableAPI
 * @author SailHe
 * @date 2018/4/15 10:11
 */
function loadDropdownMenu($DataTableAPI, customSearcher) {
    console.assert(typeof $DataTableAPI != "undefined");
    var number = -1;

    $(".dynamic-load").each(function (index, value) {
        dynamicLoadClassification($(value).find('.dropdown-menu'), index == 0 ? "BIG" : "MIDDLE", function ($dropdownAble, dataDTO) {
            $dropdownAble.append("<li><span id='dropdownLi" + ++number + "' class='search-type'> " + dataDTO.goodsCategoryName + " </span> </li>");
            $dropdownAble.find('#dropdownLi' + number + '').on('click', function () {
                const __searcher = {
                    searchType: 'LHS_SEARCH',
                    searchValue: dataDTO.goodsCategoryId
                };
                if (isValidVar(customSearcher)) {
                    customSearcher.searchValue = __searcher;
                }
                $DataTableAPI.search(JSON.stringify(isValidVar(customSearcher) ? customSearcher : __searcher)).draw();
            });
        });
    });
    //激活下拉框 奇偶bug修复
    $('.dropdown-toggle').dropdown();
}

/**
 * Descriptions: 加载[分类]下拉选项框 请求成功后会选中与selectedValue相等的选项<p>
 *
 * @author SailHe
 * @date 2018/7/29 12:05
 */
function loadDropSelect($select, gradeName, selectedValue) {
    dynamicLoadClassification($select, gradeName, function ($appendAble, dataDTO) {
        $appendAble.append("<option value='" + dataDTO.goodsCategoryId + "'>" + dataDTO.goodsCategoryName + "</option>");
        if (dataDTO.goodsCategoryId == selectedValue) {
            $select.getSelectOption(selectedValue).selected = true;
        }
    });
}


/**
 * Descriptions: 自定义提示回调<p>
 * @param reloadTable 需要重载的表格
 * @param tipsMessagePrefix 提示消息前缀(默认是'操作')
 * @return 一个提示回调函数闭包 该函数会在服务器返回的result.success为真时提示成功 并触发表格的重载事件
 * @author SailHe
 * @date 2018/4/22 10:32
 */
/*function tipsCallbackClosure(reloadTable, tipsMessagePrefix, $informationModal) {
    tipsMessagePrefix == undefined ? tipsMessagePrefix = "操作" : '';
    return function tipsCallBack(result) {
        if (result.success) {
            //$.messageBox(message + "成功！");
            $.alert(tipsMessagePrefix + "成功！", 1);
            //initDataTable();
            reloadTable.ajax.reload(null, false);
        }
        else {
            $.alert(tipsMessagePrefix + "失败！", 0);
            //$.messageBox(message + "失败！", "alert");
        }

        if (typeof  $informationModal == "undefined") {
            //do nothing
        } else {
            //隐藏模态框
            $informationModal.modal('hide');
        }
    }
}*/

/**
 * Descriptions: 重置表格的有效性验证结果(使用时机貌似只能是在modal显示之后)<p>
 *
 * @PS: 可用于解决不能重复提交的问题
 * @eg: $informationModal.find('form').resetForm();
 * @author SailHe
 * @date 2018/7/28 21:11
 */
$.fn.resetFormValidCheck = function () {
    return this.bootstrapValidator('resetForm', true);
};

/**
 * Descriptions: 清除模态框内所有表格的所有内容(jQuery选择器版) 下拉框需要empty()<p>
 *
 * @eg: $informationModal.find('form').clearForm();
 * @author SailHe
 * @date 2018/7/27 22:14
 */
$.fn.clearForm = function () {
    return this.find(':input')
        .not(':button, :submit, :reset, :radio')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
};

/**
 * Descriptions: 范围日历选择器<p>
 *
 * @author SailHe
 * @date 2018/5/6 21:06
 */
function datetimePicker(startDateTextBox, endDateTextBox, endSelectCallback) {
    if ($('#ui-datepicker-div')) {
        /*解决首次加载后无法点击bug*/
        $('#ui-datepicker-div').remove();
    }

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
    //设置默认时间
    startDateTextBox.val(new Date().format("yyyy-MM-dd HH:mm:ss"));
    endDateTextBox.val(new Date().format("yyyy-MM-dd HH:mm:ss"));

    startDateTextBox.prop("readonly", true).datetimepicker({
        changeMonth: true,
        dateFormat: "yy-mm-dd",
        showSecond: true, //显示秒
        timeFormat: 'HH:mm:ss', //格式化时间
        onClose: function (selectedDate) {
            endDateTextBox.datetimepicker("option", "minDate", selectedDate);
        }
    });
    endDateTextBox.prop("readonly", true).datetimepicker({
        changeMonth: true,
        dateFormat: "yy-mm-dd",
        showSecond: true, //显示秒
        timeFormat: 'HH:mm:ss', //格式化时间
        onClose: function (selectedDate) {
            startDateTextBox.datetimepicker("option", "maxDate", selectedDate);
            endDateTextBox.val($(this).val());
            //回调
            endSelectCallback($(this).val());
        }
    });
}

/**
 * Descriptions: 若value不为undefine那么返回与其值相等的选项 否则 返回被选中的select选项 <p>
 * 若要获取select的值$('select[name=selectID]').val() 这样即可
 * @author SailHe
 * @date 2018/5/8 14:26
 */
$.fn.getSelectOption = function (value) {
    var selectIndex = 0;
    var opt = $(this).find('option');
    opt.each(function (i) {
        if (typeof value !== undefined) {
            if (opt[i].value == value) {
                selectIndex = i;
                return;
            }
        } else {
            if (opt[i].selected) {
                selectIndex = i;
                return;
            }
        }
    });
    return opt[selectIndex];
}

/**
 * Descriptions: 找到select框的所有选项中 与传入value相等的option 并选中; 如果没找到那么将其置为''若有''选项会选中''<p>
 *
 * @author SailHe
 * @date 2018/4/22 20:27
 */
$.fn.setSelectOption = function (value) {
    var selectedIndex = -1;
    var opt = this.find('option');
    opt.each(function (i) {
        if (opt[i].value == value) {
            selectedIndex = i;
            opt[i].selected = true;
            return;
        }
    });
    if (selectedIndex == -1) {
        //this.get(0).selectedIndex = invalidIndex;
        this.val('');
    } else {
        //do nothing
    }
    return this;
}

/**
 * Descriptions: 判断[选择器中所有的]type为checkbox的input是否被选中<p>
 *
 * @author SailHe
 * @date 2018/7/28 18:54
 */
$.fn.isChecked = function () {
    var result = true;
    this.each(function () {
        if (this.checked == false) {
            result = false;
            //中止each
            return false;
        }
    });
    return result;
}

/**
 * Descriptions: 返回[选择器中所有的]type为checkbox且被选中的input的jQuery对象<p>
 *
 * @author SailHe
 * @date 2018/7/28 19:09
 */
$.fn.checked$Obj = function () {
    return this.attr("checked", 'true');
}

/**
 * Descriptions: 选中[选择器中所有的]type为checkbox的input<p>
 *
 * @param enumState: bool
 * @return {newChecked: number, oldChecked: number} 最终被选中的checkbox的个数的情况 并触发相应事件
 * @author SailHe
 * @date 2018/7/28 19:09
 */
$.fn.setCheckboxAll = function (enumState) {
    if (enumState !== true && enumState != false) {
        throw new Error('传入异常参数: ' + enumState + "应当时bool");
    }
    var result = {
        changedCheckbox: 0,
        keepCheckbox: 0,
    }
    this.each(function () {
        if (this.checked == enumState) {
            ++result.keepCheckbox;
            //更改时就触发(无论值是否相同)
            $(this).trigger('input');
        } else {
            this.checked = enumState;
            ++result.changedCheckbox;
            $(this).trigger('change');
        }
    });
    return result;
}

/**
 * Descriptions: 改变选择器选择的input框的部分属性<p>
 * EG: $('input[name=inputName]').changeInputRadio(0, true, false); 表示将名字为inputName的input=元素的第一个 选中并将其置为可改变(可输入)的
 * @author SailHe
 * @date 2018/5/7 21:14
 */
$.fn.changeInputRadio = function (num, selectIt, disabled) {
    var obj = $(this.get(num));
    if (disabled) {
        obj.attr("disabled", "disabled");
    } else {
        obj.removeAttr("disabled");
    }

    if (selectIt) {
        obj.get(0).checked = true;
    } else {
        obj.get(0).checked = false;
    }
}

/**
 * Descriptions: 获取被第一个选中的input(包括Radio, checkbox等)的{index, value}<p>
 *
 * @author SailHe
 * @date 2018/8/27 11:57
 */
$.fn.getFirstCheckedInput = function () {
    let checkedInput = {index: -1, value: null};
    $(this).each(function (index, value) {
            if ($(value).is(':checked')) {
                checkedInput.value = value;
                checkedInput.index = index;
                return false;
            }
        }
    );
    return checkedInput;
}

/**
 * Descriptions: Dom显示 + 子:input有效 (确保可提交)<p>
 * 注意: display =  ''; 可能会引起一些错误, 此时建议手写已应对特定的情况 而不是直接调用此封装API
 * @author SailHe
 * @date 2018/5/8 16:05
 */
$.fn.domDisplaySubValid = function () {
    //块display .css('display', 'block');
    return $(this).css('display', '').find(':input').removeAttr('disabled').removeAttr('readonly');
}

/**
 * Descriptions: Dom隐藏 + 子:input无效(无效=只读+不提交); 并不会移除其它潜在的冲突属性<p>
 * 隐藏了选择器选择的元素在内的所有元素以及其子元素, 并将其子:input元素都置为无效
 * @author SailHe
 * @date 2018/5/8 16:05
 */
$.fn.domHideSubInvalid = function () {
    //隐藏 + 无效
    return $(this).css('display', 'none').find(':input').attr('disabled', 'disabled');
    //.removeAttr('readonly'); //只读不可编辑
}

/**
 * Descriptions: Dom隐藏 + 子:input只读; 并不会移除其它冲突属性<p>
 *
 * @author SailHe
 * @date 2018/9/30 19:06
 */
$.fn.domHideSubReadonly = function () {
    //隐藏 + 只读(不可编辑)
    return $(this).css('display', 'none').find(':input').attr('readonly');
    //.removeAttr('disabled');//移除更强的disabled属性
}

/**
 * Descriptions: 删除table中的一行<p>
 * jQuery选择的必须是一行(是一个<tr></tr>的子元素 即被其包裹)中的一个或多个元素
 * @author SailHe
 * @return 被删除之前的那行
 * @date 2018/5/28 19:14
 */
$.fn.deleteTableRow = function () {
    //closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上。
    var row = this.closest('tr');
    row.remove();
    //currentDom.parentElement.parentElement.remove(); //不通用
    //$(currentDom).parent("tr").remove(); //invalid
    return row;
}

/**
 * Descriptions: 获取指定table指定列的值
 * 注意: 若内部有input的话 该值仅仅与第一个input的value有关; img会返回src而不是value
 * @param colNum 列号
 * @param filterFun($cell, $row) 过滤方法
 * @author SailHe
 * @return any[] 包含了该列特定值的Array 如果不指定filterFun 默认获取所有值 否则获取返回值为true的cell的值
 * @date 2018/5/7 19:23
 */
$.fn.getTableColValue = function (colNum, filterFun) {
    var currentTable = this.get(0);
    var colValueArray = new Array();
    if (typeof filterFun == "undefined") {
        filterFun = function () {
            return true;
        }
    }
    for (var i = 0; i < currentTable.rows.length; ++i) {
        var $input = $(currentTable.rows[i].cells[colNum]).find('input');
        var $img = $(currentTable.rows[i].cells[colNum]).find('img');
        if ($input.length !== 0) {
            if (filterFun($input, $(currentTable.rows[i]))) {
                colValueArray.push($input.val());
            }
        } else if ($img.length !== 0) {
            if (filterFun($img, $(currentTable.rows[i]))) {
                colValueArray.push($img.attr('src'));
            }
        } else {
            if (filterFun($(currentTable.rows[i].cells[colNum]), $(currentTable.rows[i]))) {
                colValueArray.push(currentTable.rows[i].cells[colNum].textContent);
            }
        }
    }
    return colValueArray;
}

/**
 * Descriptions: 为一个表格的行元素添加删除线 选择器是任意cell
 *
 * @see http://www.cnblogs.com/zhouhongyu1989/p/3944847.html<p>
 * @author SailHe
 * @date 2018/5/28 20:38
 */
$.fn.tableRowDeleteLine = function () {
    var rows = $(this).closest('tr');
    if (rows.length == 0) {
        return;
    }
    var colLen = rows.get(0).cells.length;
    return rows.children("td").each(function (index) {
        //$(this).children().attr("disabled", "disabled").children().attr("disabled", "disabled");
        if (index % colLen == 0) {//重点部分
            $(this).children("*:first")
                .before("<div class='delete-line' style='position:absolute; width:100%; padding-top: 12px;'><div style='outline:#000 solid 1px; width:96%;'></div></div>");//5
        }
    });
}

/**
 * Descriptions: 移除表格中任意元素对应的的行删除线 选择器是任意cell<p>
 *
 * @author SailHe
 * @date 2018/5/28 21:14
 */
$.fn.tableRowDeleteLineRemove = function () {
    return this.closest('tr').find('.delete-line').remove();
}

/**
 * Descriptions: 返回一个无意义的id字符串<p>
 *
 * @author SailHe
 * @date 2018/9/11 16:50
 */
function identification(tipStr = '__') {
    //1ms后将会调用执行remind()函数 (保证ID的差异性)
    return tipStr + setTimeout(() => new Date().getTime(), 1);
}

/**
 * Descriptions: 自定义消息框(可显示多个 不会覆盖)
 * @param content: 内容
 * @param type: alert 警告, else 提示
 * @author SailHe
 * @date 2018/4/8 21:56
 */
$.messageBox = function (content, type) {
    let messagePlot = $("#boxSpot");
    if (messagePlot.length == 0) {
        $("body").append("<div id='boxSpot' style='position:fixed; top:1px; width:20%; margin-left:40%; z-index:1500; display:none;'></div>");
        //渐显: 使用淡入效果来显示被选元素
        $("#boxSpot").fadeIn();
    }
    messagePlot = $("#boxSpot");
    //1ms后将会调用执行remind()函数 (保证ID的差异性)
    const strId = 'messageBoxDiv' + setTimeout(function remind() {
        return new Date().getTime();
    }, 1);
    //&times;<i class='ace-icon fa fa-times'>      x和icon
    messagePlot.append(
        "<div id='" + strId
        + "' name='messageBoxDiv' ></button><span id='alertSpan'><strong><i class='ace-icon fa fa-check'></i>&nbsp;&nbsp;&nbsp;&nbsp;"
        + content
        + "</strong></span><button type='button' class='close' data-dismiss='alert'>&times;</i></div>"
    );
    if (type != "alert") {
        $('#' + strId).toggleClass('alert alert-success').delay(2000)
            .hide(0, function () {
                $(this).remove();
            });
    } else {
        $('#' + strId).toggleClass('alert alert-danger');
    }
};

/**
 * Descriptions: DataTable的删除行请求闭包生成函数 delete接口参数名必须叫做primaryKey<p>
 * @param dataTableApi deleteUrl
 * @author SailHe
 * @date 2018/5/8 19:26
 */
deleteRowClosure = function (dataTableApi, deleteUrl) {
    return function (primaryKey) {
        //确认框
        bootbox.confirm({
            buttons: {
                confirm: {
                    label: '确认',
                    className: 'btn-info'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-default'
                }
            },
            title: '提示',
            message: '确定删除么？',
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type: "post",
                        data: {
                            primaryKey: primaryKey,
                        },
                        dataType: "json",
                        url: deleteUrl,
                        success: tipsCallbackClosure(dataTableApi, '删除'),
                    });
                }
            }
        });
    }
};

/**
 * Descriptions: 返回对象的原型名(prototype, 不是数据的类型: typeof)<p>
 *
 * 已有的一些常用原型名: Dom; jQuery; String; Map; Set 其它对象返回else
 * ps: typeof 'str' -> "string"; 'str' instanceof String(string或'string'异常) -> false
 * @author SailHe
 * @date 2018/5/8 18:46
 */
function instanceOf(obj) {
    return
    obj instanceof Map ? 'Map' :
        obj instanceof Set ? 'Set' :
            obj instanceof HTMLElement ? 'Dom' :
                obj instanceof jQuery ? 'jQuery' :
                    obj instanceof String ? 'String' :
                        obj instanceof Array ? 'Array' :
                            obj instanceof Number ? 'Number' : 'else';
}

/**
 * Descriptions: 判断value是否是一个'有效'的js对象<p>
 *
 * @return boolean 若value是一个已定义不为空的值返回true
 * @author SailHe
 * @date 2018/7/29 17:04
 */
function isValidObj(value) {
    return (typeof value !== "undefined" && value !== null);
}

/**
 * Descriptions: 判断value是否是一个'有效'的js变量<p>
 *
 * @return boolean 若value是一个已定义不为空的值返回true (obj的null; string的''; number的NaN; 以及undefined视为空)
 * @author SailHe
 * @date 2018/7/30 21:42
 */
function isValidVar(value) {
    if ((typeof value === 'number')) {
        return !isNaN(value);
    } else {
        return (typeof value !== "undefined" && value !== null && value != '');
    }
}

/**
 * Descriptions: 若已过期 返回true<p>
 *
 * @author SailHe
 * @date 2018/5/9 20:21
 */
function isTimeOut(endTime) {
    var currentDate = new Date().format("yyyy-MM-dd HH:mm:ss");
    //当前时间在结束时间之前->已过期
    return endTime <= currentDate;
}

/**
 * Descriptions: 以传入的一个规则间隔的字符串 构造一个Array  实验方法<p>
 *
 * @author SailHe
 * @date 2018/5/10 10:17
 */
function structureArray(ruleStr, interval) {
    //1.正则表达式; 貌似只有实际间隔为空时才能正确 ruleStr.replace(/(.)(?=[^$])/g, "$1,").split(',');
    //2.split:
    return ruleStr.split(interval);
}

function debugLog(message) {
    if (isValidVar(DEBUG__)) {
        console.log(message);
    } else {
        //do nothing
    }
}

/**
 * Descriptions: 缓存式更新<p>
 *
 * @return boolean 若之前没有被添加返回true(即这次添加了缓存)
 * @param refresh true表示强制刷新缓存 否则在有缓存的情况下不更新
 * @author SailHe
 * @date 2018/7/29 21:36
 */
function bufferUpdate(bufferMap, key, value, refresh) {
    console.assert(bufferMap instanceof Map);
    console.assert(isValidObj(value));
    if (bufferMap.has(key) === false) {
        bufferMap.set(key, value);
        return true;
    } else {
        if (isValidObj(refresh) && refresh === true) {
            bufferMap.set(key, value);
        } else {
            //do nothing
        }
        return false;
    }
}

/**
 * Descriptions: 数组式批量缓存 调用bufferUpdate方法
 * 若key是一个字符串, 对于valueArray中的每一个元素, 都应包含key属性, 这个属性作为索引
 * 否则key作为索引<p>
 *
 * @author SailHe
 * @date 2018/8/27 17:15
 */
function bufferUpdateArray(bufferMap, key, valueArray, refresh) {
    console.assert(valueArray instanceof Array);
    let len = valueArray.length;
    if (typeof key === 'string') {
        for (let i = 0; i < len; ++i) {
            bufferUpdate(bufferMap, valueArray[i][key], valueArray[i], refresh);
        }
    } else {
        for (let i = 0; i < len; ++i) {
            bufferUpdate(bufferMap, key, valueArray[i], refresh);
        }
    }
}

/**
 * Descriptions: 查重缓存<p>
 *
 * @return boolean 重复返回true 不存在返回false
 * @author SailHe
 * @date 2018/8/2 20:29
 */
function duplicateChecking(bufferMap, key) {
    console.assert(bufferMap instanceof Map);
    var duplicateCheckingFlag = bufferMap.get(key);
    if (isValidVar(duplicateCheckingFlag) && duplicateCheckingFlag) {
        $.messageBox('请勿重复添加!');
        return true;
    } else {
        bufferMap.set(key, true);
        return false
    }
}

/**
 * Descriptions: 删除查重<p>
 *
 * @author SailHe
 * @date 2018/8/2 20:35
 */
function duplicateCheckingDelete(bufferMap, key) {
    console.assert(bufferMap instanceof Map);
    bufferMap.set(key, false);
}

function floatPlush(lhs, rhs) {
    var sum = parseFloat(lhs) + parseFloat(rhs);
    return parseFloat(sum).toFixed(3);
}

function floatMultiplication(lhs, rhs) {
    return parseFloat(parseFloat(lhs) * parseFloat(rhs)).toFixed(3);
}

function integerMultiplication(lhs, rhs) {
    return (parseInt(lhs) * parseInt(rhs));
}

/**
 * Descriptions: number作为字符串相加<p>
 *
 * mlj这种引入貌似每次切换页面时js下面的变量都会重新申明一遍
 * @return number
 * @author SailHe
 * @date 2018/9/29 21:14
 */
function nStrPlush(lhs, rhs) {
    return parseInt(lhs.toString() + rhs.toString());
}

/**
 * Descriptions: 带缓存的异步多级联动事件绑定工厂<p>
 *
 * 会在上一步的异步请求成功返回后自动选择 联动选择列表 第一个的idValue 并根据是否还有下一级选择自动触发下一级联动
 * @param selectLinkList 绑定事件trigger时的 联动选择列表
 * [0~end): linker的idValue; [end]: trigger的idIndex(若不设置就会触发默认的下级联动); 以此类推可设置任意多个(最后一个总表示trigger, 若无效请置为-1之类的值, 不要置为null, ''等无效值)
 * 注意 时apend在linker上而不是trigger上
 * @eg: customLinkRequestFun = (triggerSelectIdParam, successCallback) => {
            $.ajax({
                type: 'post',
                dataType: 'json',
                async: true,
                data: getLinkRequestParamDataFun(triggerSelectIdParam),
                url: linkRequestUrl,
                success: function (result) {
                    if (result.success) {
                        let dataList = result.data;
                        successCallback(dataList);
                    } else {
                        console.error("数据请求失败!");
                    }
                },
            });
        }
 * @author SailHe
 * @date 2018/7/31 15:40
 */
function AsyncLinkBufferChangeFactory(
    {
        //触发点的jQuery选择器的字符串
        triggerSelector = null
        //自定义触发事件 默认'change'
        , triggerEventName = 'change'
        //自定义联动事件 默认'change'
        , linkEventName = 'change'
        //联动点的jQuery选择器的字符串
        , linkerSelector = null
        //联动点的请求名 (非必需)
        , linkerRequestName = ""

        //允许使用外部定义的缓存Map 用于缓存 请求得到的数据
        , linkerBufferMap = new Map()
        //辨识每条数据的属性名(Number或可以parseInt 且必须不同) 这是默认向后台请求数据时的回调字段
        , idName = null
        //索引字段(不同联动级下允许相同; 默认与idName等价)
        , indexName = idName
        //option中的value属性名(定义送往服务器的选项值; 默认与idName等价)
        , valueName = idName
        , dataName = null

        //请求联动数据时获取请求参数的方法 默认参数为空
        , getLinkRequestParamDataFun = () => {
        return null
    }
        //请求联动数据的url
        , linkRequestUrl = null

        //获取自定义联动数据的方法(不能同时定义 linkRequestUrl 和 customLinkRequestFun
        //数据处理完毕必须回调给successCallback(dataList)
        , customLinkRequestFun = null
    }) {

    if (isValidVar(customLinkRequestFun) && isValidVar(linkRequestUrl)) {
        throw new Error("不能同时定义nextLinkRequestUrl 和 customLinkRequestFun");
    } else if (!isValidVar(customLinkRequestFun) && !isValidVar(linkRequestUrl)) {
        throw new Error("linkRequestUrl 和 customRequest必须定义两者之一");
    }
    let $triggerSelect = $(triggerSelector);
    let $linkerSelect = $(linkerSelector);
    const triggerLen = $triggerSelect.length, linkerLen = $linkerSelect.length;
    if (triggerLen === 0) {
        throw new Error("当确保传入的触发选择器至少可以选中一个Dom");
    }
    if (linkerLen === 0) {
        throw new Error("当确保传入的联动选择器至少可以选中一个Dom, 请求返回的数据将append在这上面");
    }
    //环路验证 @TODO 使用find
    for (let triggerIndex = 0; triggerIndex < triggerLen; ++triggerIndex) {
        for (let linkerIndex = 0; linkerIndex < linkerLen; ++linkerIndex) {
            let triggerDom = $triggerSelect.get(triggerIndex), linkerDom = $linkerSelect.get(linkerIndex);
            if (triggerDom === linkerDom) {
                throw new Error("触发选择器和联动选择器 选择的Dom任意dom不能是同一个dom 否则会构成联动环路!");
            }
        }
    }

    return $triggerSelect.on(triggerEventName, function (event, selectLinkList) {
        debugLog(linkerRequestName + '事件' + triggerEventName + '触发');
        $linkerSelect.empty();
        if (!isValidVar(selectLinkList)) {
            //没有传参时默认 自己已选中的值作为缓存索引 下一个选择第一项(id为空时或默认就是选择第一项)
            selectLinkList = {selectLinkList: new Array(undefined)}
        }
        selectLinkList = selectLinkList.selectLinkList;
        //当前值类型必须与使用的idName对应属性的类型相同
        let triggerSelectId = selectLinkList.pop();
        //在未指定联动的下一次的index时每次必须得push一个undefined才能无限联动下去(此时会自动读取当前选择的name, 因此当前必须选择一个才能正确联动, 而且可以清除上一次的影响 还有缓存的目的)
        let linkerSelectIndex = (((selectLinkList.length - 1) < 0) ? (selectLinkList.push(undefined), 0) : selectLinkList.length - 1);
        //下一个的值允许首先为index类型 索引完毕后会自动转为idName对应属性的类型
        let linkerSelectId = selectLinkList[linkerSelectIndex];
        if (isValidVar(triggerSelectId) === true) {
            //可以实现为在下一个选上一个 但貌似效率会略低 (用负数表示没有选择的选项会导致缓存错误)  因此第一个必须是外部触发选择
            if (typeof triggerSelectId !== 'number') {
                debugger;
                throw new Error("当前选择的id值类型必须是number");
            }
        } else {
            //name处储存用于缓存的id, 这可能与value的值不同 另外由于此处获取的始终是个string 这会对缓存造成影响 因此规定idValue只能是number
            let $selectedOption = $(triggerSelector + " option:selected");
            if ($selectedOption.length === 1) {
                //@TODO 考虑把name换成其它的自定义属性
                triggerSelectId = $selectedOption.attr("name");
                debugLog('从当前联动点选择的idValue: ');
                debugLog(triggerSelectId);
                if (!isValidVar(triggerSelectId)) {
                    debugger;
                    throw new Error("从当前联动点选择的idValue必须为有效值! 请检查是否使用了非select元素作为联动结点; 或是传入参数值错误");
                }
                triggerSelectId = parseInt(triggerSelectId);
            } else {
                //当前选项为空(理论上来说如果有的话必定选择了一个) 但仍需触发连锁 否则可能引起后续的连锁无法触发 导致数据错误
            }
        }
        debugLog('当前选择的idValue: ' + triggerSelectId + '(' + typeof triggerSelectId + ')' + '; 下一个选择时的indexValue: ' + linkerSelectId + '(' + typeof linkerSelectId + ')');
        debugLog('联动选择列表: ');
        debugLog(selectLinkList);
        debugLog(linkerRequestName + '缓存: ');
        debugLog(linkerBufferMap);

        function successCallback(data) {
            let selected = null;
            const dataLen = data.length;
            for (let i = 0; i < dataLen; i++) {
                if (linkerSelectId == data[i][indexName] || (i === 0 && !isValidObj(linkerSelectId))) {
                    selectLinkList[linkerSelectIndex] = linkerSelectId = data[i][idName];
                    selected = "selected";
                } else {
                    selected = "";
                }
                //@TODO 可以不要显式地将value存在html上
                const options = "<option name='" + data[i][idName] + "' value='" + data[i][valueName] + "'" + selected + ">" + data[i][dataName] + "</option>";
                $linkerSelect.append(options);
            }
            bufferUpdate(linkerBufferMap, triggerSelectId, data);
            /*if (isValidObj(selectLinkList[0]) === true)*/
            //加载联动选择用的数据
            $linkerSelect.trigger(linkEventName, {selectLinkList: selectLinkList});
        }

        let bufferData = linkerBufferMap.get(triggerSelectId);
        if (isValidObj(bufferData)) {
            debugLog("使用了缓存的" + linkerRequestName + "请求数据");
            successCallback(bufferData);
        } else {
            if (isValidObj(triggerSelectId) === true) {
                if (isValidVar(customLinkRequestFun)) {
                    customLinkRequestFun(triggerSelectId, successCallback)
                } else {
                    $.ajax({
                        type: 'post',
                        dataType: 'json',
                        async: true,
                        data: getLinkRequestParamDataFun(triggerSelectId),
                        url: linkRequestUrl,
                        success: function (result) {
                            if (result.success) {
                                successCallback(result.data);
                            } else {
                                console.error("数据请求失败!");
                            }
                        },
                    });
                }
            } else {
                throw new Error("传入的triggerSelectId无效!");
            }
        }
    });

}

//返回两个日期Date间的天数差
function calcDiffDay(startDate, endDate) {
    console.assert(startDate instanceof Date);
    console.assert(endDate instanceof Date);
    //一天的毫秒数
    var oneDayMSecond = 86400000;
    var diffDay = (endDate - startDate) / oneDayMSecond;
    return diffDay;
}


/**
 * Descriptions: 遍历指定table的指定列
 * 注意: 参数未经任何处理
 * @param colNum 列号
 * @param iteratorFun($cell, $row)
 * @author SailHe
 * @return $(this)
 * @date 2018/9/11 18:30
 */
$.fn.iterateTableCol = function (colNum, iteratorFun) {
    const currentTable = this.get(0);
    if (!isValidVar(iteratorFun)) {
        throw new Error("必须定义迭代方法!!!");
    }
    if (this.length > 1) {
        throw new Error("暂不支持多元素操作!!!");
    }
    const len = currentTable.rows.length;
    for (let i = 0; i < len; ++i) {
        iteratorFun($(currentTable.rows[i].cells[colNum]), $(currentTable.rows[i]));
    }
    return this;
}

/**
 * Descriptions: 左开右闭<p>
 * Left open and right closed
 *
 * @author SailHe
 * @date 2018/9/12 12:44
 */
function betweenNumLORC(min, num, max) {
    return min <= num && num < max;
}

/**
 * Descriptions: 绑定回车提交事件<p>
 * trigger是对应Dom下面的按键事件, linker是自定义jQuery选择器所选择的元素, 动作是对其触发指定的事件
 * @author SailHe
 * @date 2018/9/30 21:39
 */
$.fn.keyPressEventBinding = function (linkerSelector, keyCode = 13, linkerEventName = 'click') {
    return this.on('keypress', function (event) {
        //@see: 更多keyCode https://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes
        if (event.keyCode == keyCode) {
            //提交搜索时使用ajax->阻止表单的默认行为
            event.preventDefault();
            $(linkerSelector).trigger(linkerEventName);
        }
    });
}

/*
$(document).on("show.bs.modal", ".modal", function () {
    $(this).draggable({
        handle: ".modal-header"   // 只能点击头部拖动
    });
    $(this).css("overflow", "hidden"); // 防止出现滚动条，出现的话，滚动条会一起拖着走
});
*/

/*导航栏点击事件*/
$('.allRecords').click(function () {
    initDataTable();
});
$('.navigation').click(function () {
    $($('.navigation')).closest('li').removeClass('active');
    $($(this).closest('li')).addClass('active');
});
// 默认的搜索框的enter事件(keyCode=13)
$('input[id=searchText]').keyPressEventBinding('button[id=searchButton]');
