package com.nit.cs161.lost_and_found.constant.general;

/**
 * Descriptions: 删除状态枚举<p>
 * PS: 放入回收站就应该都不显示出来了
 *
 * @author SailHe
 * @date 2018/7/25 10:20
 */
public enum EnumDelete {
    NO(new Byte("0"), "未删除"), YES(new Byte("1"), "放入回收站"), FOREVER(new Byte("2"), "彻底删除");
    Byte value;
    private String name;

    EnumDelete(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public Byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
