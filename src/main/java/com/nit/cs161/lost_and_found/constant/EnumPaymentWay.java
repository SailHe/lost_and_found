package com.nit.cs161.lost_and_found.constant;

/**
 * Descriptions: 支付方式枚举<p>
 *
 * @author SailHe
 * @date 2018/7/25 10:20
 */
public enum EnumPaymentWay {
    UN_PAY(new Byte("0"), "未付款"), WX(new Byte("10"), "微信"), WE_CHAT(new Byte("10"), "微信"), ALIPAY(new Byte("20"), "支付宝"), CARD(new Byte("30"), "信用卡"), LOCAL(new Byte("40"), "本地账户"), CREDIT(new Byte("50"), "奶工信用额度");
    Byte value;
    private String name;

    EnumPaymentWay(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static EnumPaymentWay enumOf(Byte value) {
        if(value == null){
            return UN_PAY;
        }
        for (EnumPaymentWay e : EnumPaymentWay.values()) {
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
