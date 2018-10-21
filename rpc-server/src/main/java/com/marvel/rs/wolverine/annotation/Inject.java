package com.marvel.rs.wolverine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Inject
 * 使用该注解可以注入一个对象，同 java 中的 @Resource
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
