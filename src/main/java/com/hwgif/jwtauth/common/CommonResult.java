package com.hwgif.jwtauth.common;

import java.io.Serializable;

/**
 * Created by lc.huang on 2019/11/19.
 * Description
 */
public class CommonResult implements Serializable{
    public static final int CODE_EXCEPTION = -1;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_ERROR = 0;
    private static final String MSG_EXCEPTION = "异常";
    private static final String MSG_SUCCESS = "成功";
    private static final String MSG_FAIL = "失败";
    private static final Object RESULT_OBJECT = new Object();
    private int code;
    private String msg;
    private Object resultObject;

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.resultObject = object;
    }

    public static com.hwgif.jwtauth.common.CommonResult successResult() {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(1, "成功", RESULT_OBJECT);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult successResult(Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(1, "成功", resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult successResult(String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(1, msg, resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult successResult(int code, String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(code, msg, resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult failResult() {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(0, "失败", RESULT_OBJECT);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult failResult(String msg) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(0, msg);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult failResult(Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(0, "失败", resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult failResult(String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(0, msg, resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult failResult(int code, String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(code, msg, resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult exceptionResult() {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(-1, "异常", RESULT_OBJECT);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult exceptionResult(String msg) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(-1, "异常:"+msg);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult exceptionResult(Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(-1, "异常", resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult exceptionResult(String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(-1, msg, resultObject);
        return result;
    }

    public static com.hwgif.jwtauth.common.CommonResult exceptionResult(int code, String msg, Object resultObject) {
        com.hwgif.jwtauth.common.CommonResult result = new com.hwgif.jwtauth.common.CommonResult(code, msg, resultObject);
        return result;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResultObject() {
        return this.resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String toString() {
        return "CommonResult{code=" + this.code + ", msg=\'" + this.msg + '\'' + ", resultObject=" + this.resultObject + '}';
    }
}
