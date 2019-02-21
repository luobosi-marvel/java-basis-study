/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.netty;

/**
 * MiniProgramException
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-20
 */
public class MiniProgramException extends BizException {



    /**
     * @param code
     * @param message
     */
    public MiniProgramException(String code, String message) {
        super(message, code);
    }

    /**
     * @param message
     */
    public MiniProgramException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public MiniProgramException(String message, Throwable cause) {
        super(message, cause);
    }

}
