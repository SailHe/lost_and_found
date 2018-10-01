package com.nit.cs161.lost_and_found.constant.general;

/**
 * Description: 用户类别枚举<p>
 *
 * @Package: com.nit.cs161.lost_and_found.constant.general
 * @author: SailHe
 * @date: 2018/10/1 15:06
 */
public enum EnumUserType {
    NORMAL(new Byte("10"), "普通用户"), ADMIN(new Byte("20"), "管理员");
    Byte value;
    private String name;

    EnumUserType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static EnumUserType enumOf(Byte value) {
        if(value == null){
            return NORMAL;
        }
        for (EnumUserType e : EnumUserType.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("枚举参数" + value + "非法");
    }

    public Byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
