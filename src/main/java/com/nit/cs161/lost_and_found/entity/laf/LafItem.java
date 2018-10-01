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
@Table(name = "laf_item", schema = "lost_and_found", catalog = "")
public class LafItem {
    private Integer itemId;
    private String messageDesc;
    private Timestamp pickUpTime;
    private Timestamp createTime;
    private Timestamp editTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
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
    @Column(name = "pick_up_time", nullable = true)
    public Timestamp getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Timestamp pickUpTime) {
        this.pickUpTime = pickUpTime;
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
        LafItem lafItem = (LafItem) o;
        return itemId.equals(lafItem.itemId) &&
                Objects.equals(messageDesc, lafItem.messageDesc) &&
                Objects.equals(pickUpTime, lafItem.pickUpTime) &&
                Objects.equals(createTime, lafItem.createTime) &&
                Objects.equals(editTime, lafItem.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, messageDesc, pickUpTime, createTime, editTime);
    }
}
