package com.nit.cs161.lost_and_found.dto.general;


/**
 * Created by NR on 2017/10/21.
 */

public class AjaxMsgDTO {

    /**
     * Descriptions: 交互状态<p>
     *
     * @author SailHe
     * @date 2018/4/10 11:58
     */
    private Boolean success;
    /**
     * Descriptions: json数据<p>
     *
     * @author SailHe
     * @date 2018/4/10 12:02
     */
    private Object  data;
    /**
     * Descriptions: 交互提示信息详情<p>
     *
     * @author SailHe
     * @date 2018/4/10 12:01
     */
    private String  msg;
    public AjaxMsgDTO() {
        super();
    }

    public AjaxMsgDTO(Boolean success, Object data,String msg) {
        super();
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
