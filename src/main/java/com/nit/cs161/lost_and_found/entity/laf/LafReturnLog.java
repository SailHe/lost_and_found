package com.nit.cs161.lost_and_found.entity.laf;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: SailHe
 * @date: 2018/10/4 19:45
 */
@Entity
@Table(name = "laf_return_log", schema = "lost_and_found", catalog = "")
public class LafReturnLog {
    private Integer returnId;
    private Integer pikerUserId;
    private Integer ownerUserId;
    private Integer itemId;
    private String returnImgUrl;
    private Timestamp createTime;
    private Timestamp editTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id", nullable = false)
    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    @Basic
    @Column(name = "piker_user_id", nullable = true)
    public Integer getPikerUserId() {
        return pikerUserId;
    }

    public void setPikerUserId(Integer pikerUserId) {
        this.pikerUserId = pikerUserId;
    }

    @Basic
    @Column(name = "owner_user_id", nullable = true)
    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
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
    @Column(name = "return_img_url", nullable = true, length = 50)
    public String getReturnImgUrl() {
        return returnImgUrl;
    }

    public void setReturnImgUrl(String returnImgUrl) {
        this.returnImgUrl = returnImgUrl;
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
        LafReturnLog that = (LafReturnLog) o;
        return Objects.equals(returnId, that.returnId) &&
                Objects.equals(pikerUserId, that.pikerUserId) &&
                Objects.equals(ownerUserId, that.ownerUserId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(returnImgUrl, that.returnImgUrl) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(editTime, that.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnId, pikerUserId, ownerUserId, itemId, returnImgUrl, createTime, editTime);
    }
}
