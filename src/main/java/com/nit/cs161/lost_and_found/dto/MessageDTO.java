package com.nit.cs161.lost_and_found.dto;

import com.nit.cs161.lost_and_found.entity.laf.LafMessage;
import com.nit.cs161.lost_and_found.utility.BaseDTO;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Descriptions: 消息传输类<p>
 *
 * @author SailHe
 * @date 2018/10/6 22:46
 */
public class MessageDTO extends BaseDTO<LafMessage> {
    private Integer messageId;
    private Integer userId;
    /**
     * Descriptions: 由于前端使用的username 此处用于传参<p>
     *
     * @author SailHe
     * @date 2018/12/16 15:20
     */
    private String userUsername;
    private Integer itemId;
    private String messageDesc;
    private String msgImgUrls;
    private Byte messageType;

    public MessageDTO() {
        super(LafMessage.class);
    }

    public MessageDTO(LafMessage bean) {
        super(LafMessage.class);
        BeanUtils.copyProperties(bean, this);
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public String getMsgImgUrls() {
        return msgImgUrls;
    }

    public void setMsgImgUrls(String msgImgUrls) {
        this.msgImgUrls = msgImgUrls;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "messageId=" + messageId +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", messageDesc='" + messageDesc + '\'' +
                ", msgImgUrls='" + msgImgUrls + '\'' +
                '}';
    }
}
