package org.interstellar.familyfinancemanagement.entity;

import lombok.Data;
import org.interstellar.familyfinancemanagement.enums.ResultEnum;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result<T>  defineSuccess(Integer code, T data) {
        Result<T> result = new Result<>();
        return result.setCode(code).setData(data);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.ordinal()).setData(data);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.FAIL.ordinal()).setMsg(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code).setMsg(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data){
        Result<T> result = new Result<>();
        result.setCode(code).setMsg(msg).setData(data);
        return result;
    }

}
