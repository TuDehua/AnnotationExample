package com.tdh.annotationexample.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
  注解的保留期，即注解存活的时间
  RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
  RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
  RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
 */
@Retention(RetentionPolicy.RUNTIME)
/*
  注解使用的地方，例ElementType.FIELD表示该注解需要使用在类的属性上
 */
@Target(ElementType.FIELD)
/*
  @Inherited注解的作用：若类A中包含了TestAnnotation注解，A的子类B也包含了A中的注解
 */
@Inherited
public @interface TestAnnotation {
    /*
    注解的属性
    注解的属性也叫做成员变量。注解只有成员变量，没有方法。
    注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型
    类型只能使用基本类型。
    使用default关键字可以设置默认值
    */
    int id();
    String name();
    int gender() default 0;
}

/*
  元注解中还包含了
  @Documented --> 它的作用是能够将注解中的元素包含到 Javadoc 中去。
  @Repeated --> 注解可以多次使用
  例：
  @interface Persons {
	Person[]  value();
  }


  @Repeatable(Persons.class)
  @interface Person{
	  String role default "";
  }


  @Person(role="artist")
  @Person(role="coder")
  @Person(role="PM")
  public class SuperMan{

  }
 */
