package com.nit.cs161.lost_and_found.constant.general;

/**
 * Descriptions: IS状态枚举(如果只包含YES和NO的没建其它enum的直接用这个)<p>
 *
 * @author SailHe
 * @date 2018/7/27 8:43
 */
public enum EnumIs {
    NO(new Byte("0"), "否"), YES(new Byte("1"), "是");
    Byte value;
    private String name;

    EnumIs(Byte value, String name) {
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
