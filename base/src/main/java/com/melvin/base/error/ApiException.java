package com.melvin.base.error;

/**
 * 异常处理的一个类
 * 实现项目可以在这里处理message后再返回给MyBaseObserver
 */
public class ApiException extends RuntimeException {

    private String mErrorCode;
    private String mErrorMsg;

    public ApiException(String errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = errorCode;
        mErrorMsg = errorMessage;
    }
    public ApiException(String errorMessage) {
        super(errorMessage);
        mErrorMsg = errorMessage;
    }

    public String getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(String mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public String getErrorMsg() {
        return mErrorMsg;
    }

    public void setErrorMsg(String mErrorMsg) {
        this.mErrorMsg = mErrorMsg;
    }



}
