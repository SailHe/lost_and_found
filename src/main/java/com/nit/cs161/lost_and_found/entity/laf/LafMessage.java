package com.nit.cs161.lost_and_found.entity.laf;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: SailHe
 * @date: 2018/10/1 15:15
 */
@Entity
@Table(name = "laf_message", schema = "lost_and_found", catalog = "")
public class LafMessage {
    private Integer messageId;
    private String messageDesc;
    private String descImgUrl;
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
    @Column(name = "message_desc", nullable = true, length = 500)
    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    @Basic
    @Column(name = "desc_img_url", nullable = true, length = 50)
    public String getDescImgUrl() {
        return descImgUrl;
    }

    public void setDescImgUrl(String descImgUrl) {
        this.descImgUrl = descImgUrl;
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
        return messageId.equals(that.messageId) &&
                Objects.equals(messageDesc, that.messageDesc) &&
                Objects.equals(descImgUrl, that.descImgUrl) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(editTime, that.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageDesc, descImgUrl, createTime, editTime);
    }
}
