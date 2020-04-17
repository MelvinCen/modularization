package com.melvin.base.bean;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * created by Melvin 2017/08/04
 * 服务器返回的json基类根据结构更改
 */
public class BaseResponse<T> implements Serializable {

    public static final String CODE_SUCCESS = "0200";
    public static final String CODE_FAILED = "0201";
    //token过期
    public static final String CODE_TOKEN_OVERTIME = "SYS0012";

    private String code;
    private String message;
    private String requestId;
    private String serviceId;
    private String timestamp;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isRequestSuccess() {
        return TextUtils.equals(CODE_SUCCESS, code);
    }

    //用来转换数据，当data是null的时候可以用到
    public Optional<T> transform() {
        return new Optional<>(data);
    }

    public static boolean tokenOverTime(String code) {
        return TextUtils.equals(code, CODE_TOKEN_OVERTIME);
    }


    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", requestId=" + requestId +
                ", serviceId=" + serviceId +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
