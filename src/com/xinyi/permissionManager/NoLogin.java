package com.xinyi.permissionManager;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注此注解的controller不需要登陆
 * @author 尘世间迷茫的小书童
 *
 */
@Documented //该注解表示 是否被JavaDoc处理并保留在文档中
@Target(ElementType.METHOD) //注解使用的地方
@Retention(RetentionPolicy.RUNTIME) //源码保留级别
public @interface NoLogin {
	String value();
}
