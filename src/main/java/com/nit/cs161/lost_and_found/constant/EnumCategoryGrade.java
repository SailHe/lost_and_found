package com.nit.cs161.lost_and_found.constant;

/**
 * Description: 类别品级枚举<p>
 *
 * @Package: com.nit.cs161.lost_and_found.constant
 * @author: SailHe
 * @date: 2018/4/15 19:28
 */
public enum EnumCategoryGrade {
    //顺序不能随意变动: 保证其ordinal()值依次为 0 1 2(用于索引)
    BIG(new Byte("0"), "大类"), MIDDLE(new Byte("1"), "中类"), SMALL(new Byte("2"), "小类"), MAX_INDEX(new Byte("3"), "枚举长度");

    /**
     * Descriptions: 无效的类别品级<p>
     *
     * @author SailHe
     * @date 2018/7/20 14:51
     */
    public static final int INVALID_GRADE = -1;
    Byte value;
    private String name;

    EnumCategoryGrade(Byte value, String name) {
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
