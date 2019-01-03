package com.nit.cs161.lost_and_found.dto;

import com.nit.cs161.lost_and_found.constant.EnumMessageType;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.entity.laf.LafItem;
import com.nit.cs161.lost_and_found.entity.laf.LafMessage;
import com.nit.cs161.lost_and_found.utility.DateGenerator;
import org.springframework.beans.BeanUtils;

/**
 * Descriptions: 主题: 消息和物品的复合类<p>
 *
 * @author SailHe
 * @date 2018/10/6 22:46
 */
public class SubjectDTO {
    private Integer messageId;
    private String userUsername;
    private String userNickname;
    private String itemName;
    private String messageDesc;
    private String msgTitle;
    private EnumMessageType messageType;
    private String publishTime;

    public SubjectDTO() {
    }

    public SubjectDTO(LafMessage messageBean, LafItem pickItem, SysUser publisherAndPicker) {
        BeanUtils.copyProperties(messageBean, this);
        BeanUtils.copyProperties(pickItem, this);
        BeanUtils.copyProperties(publisherAndPicker, this);

        setMessageType(EnumMessageType.enumOf(messageBean.getMessageType()));
        setPublishTime(new DateGenerator(pickItem.getItemPickUpTime()).toString());
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * Descriptions: 尤其注意 此处为了前端显示直接是类型的name于是更改了返回值<p>
     *
     * @author SailHe
     * @date 2018/10/7 0:35
     */
    public String getMessageType() {
        return messageType.getName();
    }

    public void setMessageType(EnumMessageType messageType) {
        this.messageType = messageType;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "messageId=" + messageId +
                ", userUsername='" + userUsername + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", itemName='" + itemName + '\'' +
                ", messageDesc='" + messageDesc + '\'' +
                ", msgTitle='" + msgTitle + '\'' +
                ", messageType=" + messageType +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}
