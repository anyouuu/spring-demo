package com.example.util;

import com.example.enums.ResultEnum;
import com.example.model.Result;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setMsg(msg);
        result.setStatus(code);
        result.setData(null);
        return result;
    }

    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setStatus(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}