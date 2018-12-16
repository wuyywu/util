package com.github.commonutils.exception;

/**
 * 业务异常
 *
 * @author wuyun
 * @date 2018/12/16 12:40
 */
public class BusinessException extends RuntimeException{

    private String errorMessage;
    private String errorCode;

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errotMessage, String errorCode) {
        super(errotMessage);
        this.errorMessage = errotMessage;
        this.errorCode = errorCode;
    }

    public BusinessException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
