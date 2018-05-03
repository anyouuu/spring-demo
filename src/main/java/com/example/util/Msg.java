package com.example.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Msg<T> implements Serializable {
  private static final long serialVersionUID = -2417860503542275729L;

  public Msg(Integer status) {
    this.status = status;
  }

  public Msg() {}

  public static Integer OK = 200;

  public static Integer ERR = 400;

  private Integer status;

  private String action;

  private T data;

  private String reason;

  public static <E> Msg<E> ok() {
    return new Msg<>(OK);
  }

  public static <E> Msg<E> ok(E data) {
    Msg<E> msg = new Msg<>(OK);
    msg.setData(data);
    return msg;
  }

  public static <E> Msg<E> err() {
    return new Msg<>(ERR);
  }

  public static <E,B> Msg<E> err(B reason) {
    Msg<E> mes = new Msg<>(ERR);
    mes.setReason(reason.toString());
    return mes;
  }

  public  Msg<T> status(Integer code) {
    this.setStatus(code);
    return this;
  }
}
