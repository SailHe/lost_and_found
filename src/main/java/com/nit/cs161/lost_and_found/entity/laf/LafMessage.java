package com.nit.cs161.lost_and_found.entity.laf;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: 何 帆
 * @date: 2018/10/4 19:45
 */
@Entity
@Table(name = "laf_message", schema = "lost_and_found", catalog = "")
public class LafMessage {
    private Integer messageId;
    private Integer userId;
    private Integer itemId;
    private String messageDesc;
    private String msgImgUrls;
    private Byte messageType;
    private Timestamp createTime;
    private Timestamp editTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false)
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "item_id", nullable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "message_desc", nullable = true, length = 500)
    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    @Basic
    @Column(name = "msg_img_urls", nullable = true, length = 500)
    public String getMsgImgUrls() {
        return msgImgUrls;
    }

    public void setMsgImgUrls(String msgImgUrls) {
        this.msgImgUrls = msgImgUrls;
    }

    @Basic
    @Column(name = "message_type", nullable = true)
    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "edit_time", nullable = true)
    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LafMessage that = (LafMessage) o;
        return Objects.equals(messageId, that.messageId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(messageDesc, that.messageDesc) &&
                Objects.equals(msgImgUrls, that.msgImgUrls) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(editTime, that.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, userId, itemId, messageDesc, msgImgUrls, createTime, editTime);
    }
}
