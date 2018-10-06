package com.nit.cs161.lost_and_found.constant;

/**
 * Descriptions: 消息类型枚举<p>
 *
 * @author SailHe
 * @date 2018/10/6 23:19
 */
public enum EnumMessageType {
    /**
     * Descriptions: 其余用户都可以自由发布消息<p>
     *
     * @author SailHe
     * @date 2018/10/6 23:27
     */
    ORDINARY(new Byte("0"), "DEFAULT 普通的消息")
    /**
     * Descriptions: 由拾取者发布的拾取消息 此类型的消息会作为一个主题(类似于帖子)显示在主页供用户查阅<p>
     *
     * @author SailHe
     * @date 2018/10/6 23:27
     */
    , PICK_UP_ITEM(new Byte("10"), "拾取物品")
    /**
     * Descriptions: 由丢失者发布, 丢失者可能有多个会同时参与<p>
     *
     * @author SailHe
     * @date 2018/10/6 23:24
     */
    , LOST_ITEM(new Byte("20"), "丢失物品")
    /**
     * Descriptions: 由丢失者发布, 但只有物品处于被归还的状态时才会用此消息替换上述消息类型(貌似没有必要)<p>
     *
     * @author SailHe
     * @date 2018/10/6 23:26
     */
    , APPEAL_ITEM(new Byte("20"), "申诉物品");
    Byte value;
    private String name;

    EnumMessageType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static EnumMessageType enumOf(Byte value) {
        for (EnumMessageType e : EnumMessageType.values()) {
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
