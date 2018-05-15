package com.example.enums;

import lombok.Getter;
import lombok.Setter;


/**
 * 特殊静态返回
 */
public enum ResultEnum {

    SUCCESS(0, "成功"),
    UNKONW_ERROR(-1, "ERROR .....");

    public  @Getter  Integer code;
    public @Getter String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}