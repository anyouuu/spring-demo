package com.example.model;


import lombok.Getter;
import lombok.Setter;

/**
 * RESULTful 返回数据对象
 * @param <T>
 */
@Setter
@Getter
public class Result<T> {
    private Integer status;
    private T data;
    private String msg;
}
