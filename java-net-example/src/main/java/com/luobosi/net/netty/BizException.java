/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.netty;

/**
 * BizException
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-20
 */
public class BizException extends RuntimeException {

    private String code;    //异常业务编码

    /**
     * <code>[serialVersionUID]</code>.
     */
    private static final long serialVersionUID = 1L;

    /**
     * 默认异常构造器.
     */
    public BizException() {
        super();
    }

    /**
     * 根据异常信息和原生异常构造对象.
     *@param code
     *            错误码
     * @param message
     *            异常信息.
     * @param cause
     *            原生异常.
     */
    public BizException(final String code,final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * 根据异常信息和原生异常构造对象.
     *
     * @param message
     *            异常信息.
     * @param cause
     *            原生异常.
     */
    public BizException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 根据异常信息构造对象.
     *
     * @param message
     *            异常信息.
     */
    public BizException(final String message) {
        super(message);
    }


    /**
     * 根据异常构造业务对象，设置 编码及 消息
     * @author zxh 槟榔
     * @param code
     * @param message
     */
    public BizException(final String message,final String code){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 根据原生异常构造对象.
     *
     * @param cause
     *            原生异常.
     */
    public BizException(final Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
