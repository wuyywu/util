package com.hundsun.study;

/**
 * 支付结算的业务异常
 * Created by IntelliJ IDEA.
 * User: GongQi
 * Date: 2018/1/16
 */
public class FspBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 错误代码
     */
    private String errorCode = null;



    public FspBusinessException(String errorCode){
        this.errorCode=errorCode;
    }


    public FspBusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }


    public FspBusinessException(Throwable t) {
        super(t);
    }

    public FspBusinessException(String errorCode, Throwable t) {
        super(t);
        this.errorCode = errorCode;
    }

    public FspBusinessException(String errorCode, String errorMessage, Throwable t) {
        super(errorMessage, t);
        this.errorCode = errorCode;
    }


    public String getErrorCode() {
        return this.errorCode;
    }



}
