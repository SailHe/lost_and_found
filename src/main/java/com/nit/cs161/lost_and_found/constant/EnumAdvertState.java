package com.nit.cs161.lost_and_found.constant;

/**
 * Created by CaiTieZhu on 2018/7/25 15:23
 */
/** 广告状态枚举类 By CaiTieZhu*/
public enum EnumAdvertState {
    TOBE(new Byte("0")),ALREADYON(new Byte("1")),ALREADYDOWN(new Byte("2"));
    Byte value;
    EnumAdvertState(Byte value){
        this.value = value;
    }
}
