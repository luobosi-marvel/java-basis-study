package com.marvel.rs.wolverine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Component
 * 只要被 @Component 自定义主键注释的类都是受容器管理的Bean。
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
}