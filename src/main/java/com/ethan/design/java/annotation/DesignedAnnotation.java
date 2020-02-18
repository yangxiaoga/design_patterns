package com.ethan.design.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DesignedAnnotation {
	
	//parameterName为参数名，String为参数类型
	//default为默认值
    String parameterName() default "empty str";
    int intName() default 1;
    String[] arrName() default {"i am the defalut value"};
}
