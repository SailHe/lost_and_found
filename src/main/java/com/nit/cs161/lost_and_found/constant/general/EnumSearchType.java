package com.nit.cs161.lost_and_found.constant.general;

/**
 * Description: 搜索枚举(用于区分部分无法直接区分搜索来源的页面的搜索来源)<p>
 *
 * @Package: com.nit.cs161.lost_and_found.constant
 * @author: SailHe
 * @date: 2018/5/12 20:31
 */
public enum EnumSearchType {
    //顺序不能变
    /**
     * Descriptions: 来自左手边(left hands side)的下拉框的搜索<p>
     *
     * @author SailHe
     * @date 2018/5/10 19:24
     */
    LHS_SEARCH("左手边的下拉菜单"),
    /**
     * Descriptions: 来自右手边的下拉框的搜索<p>
     *
     * @author SailHe
     * @date 2018/5/10 19:24
     */
    RHS_SEARCH("右手边的下拉菜单"),
    /**
     * Descriptions: 来自搜索框的模糊搜索<p>
     *
     * @author SailHe
     * @date 2018/5/10 19:24
     */
    FUZZY_SEARCH("模糊搜索框"), SPECIAL_SEARCH("需要特殊处理的"), RELOAD("与重载等价的搜索");
    private String name;

    EnumSearchType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
