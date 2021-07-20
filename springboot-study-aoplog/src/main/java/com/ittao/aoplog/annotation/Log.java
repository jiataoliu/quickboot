package com.ittao.aoplog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用 @interface 将定义一个注解 这里是 log
 * 用于日志 aop 编程
 * <p>
 * 注解是一种元数据形式。即注解是属于java的一种数据类型，和类、接口、数组、枚举类似
 * 注解用来修饰，类、方法、变量、参数、包。
 * 注解不会对所修饰的代码产生直接的影响。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
