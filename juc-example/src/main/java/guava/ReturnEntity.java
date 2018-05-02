/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package guava;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ReturnEntity
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public class ReturnEntity {
    private Exception exception;
    private Object result;

    private ReturnEntity() {
    }

    public static ReturnEntity newDefault() {
        return new ReturnEntity();
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean hashResult() {
        return null != this.result;
    }

    public void throwException() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}