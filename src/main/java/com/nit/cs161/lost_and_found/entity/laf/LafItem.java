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
@Table(name = "laf_item", schema = "lost_and_found", catalog = "")
public class LafItem {
    private Integer itemId;
    private String itemName;
    private String itemDesc;
    private Timestamp itemPickUpTime;
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
    @Column(name = "item_name", nullable = true, length = 25)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_desc", nullable = true, length = 500)
    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Basic
    @Column(name = "item_pick_up_time", nullable = true)
    public Timestamp getItemPickUpTime() {
        return itemPickUpTime;
    }

    public void setItemPickUpTime(Timestamp itemPickUpTime) {
        this.itemPickUpTime = itemPickUpTime;
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
        return Objects.equals(itemId, lafItem.itemId) &&
                Objects.equals(itemDesc, lafItem.itemDesc) &&
                Objects.equals(itemPickUpTime, lafItem.itemPickUpTime) &&
                Objects.equals(createTime, lafItem.createTime) &&
                Objects.equals(editTime, lafItem.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemDesc, itemPickUpTime, createTime, editTime);
    }
}
