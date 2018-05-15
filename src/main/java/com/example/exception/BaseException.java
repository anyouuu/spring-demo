package com.example.exception;

import com.example.enums.ResultEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private Integer code;

    public  BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public  BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
