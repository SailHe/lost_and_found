package com.nit.cs161.lost_and_found.constant;

/**
 * Descriptions: 推广平台枚举<p>
 * PS: 订单的origin, 活动的platform等字段都用此枚举
 *
 * @author SailHe
 * @date 2018/7/25 10:20
 */
public enum EnumPlatform {
    WEB(new Byte("10"), "web后台", 20200), APP(new Byte("20"), "安卓移动端", 20223), WORKER(new Byte("20"), "奶工", null);
    Byte value;
    private String name;
    Integer stationId;

    EnumPlatform(Byte value, String name, Integer stationId) {
        this.value = value;
        this.name = name;
        this.stationId = stationId;
    }

    public static EnumPlatform enumOf(Byte value) {
        for (EnumPlatform e : EnumPlatform.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("枚举参数" + value + "非法");
    }

    public static EnumPlatform enumOf(Integer stationId) {
        for (EnumPlatform e : EnumPlatform.values()) {
            if (e.getStationId().equals(stationId)) {
                return e;
            }
        }
        throw new IllegalArgumentException("枚举参数" + stationId + "非法");
    }

    public Byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Integer getStationId() {
        return stationId;
    }
}
