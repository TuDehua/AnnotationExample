package com.tdh.annotationexample.annotation;

import java.lang.reflect.Field;

/**
 * Author: tudehua
 * E-mail:tdh@erongdu.com
 * Date: 2019/6/14 15:24
 * Descripiton:
 * Link:{@link}
 */
public class School {
    /*
      当注解只包含一个属性时，可以省略name，若注解无属性，则括号可以省略
     */
    @TestAnnotation(id = 1, name = "校长")
    private Person person1;
    @TestAnnotation(id = 2, name = "副校长", gender = 1)
    private Person person2;

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public class Person {
        private String work;

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }
    }

    /*
      注解的提取
      注解通过反射获取。首先可以通过 Class/Field/Method 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
      然后通过 getAnnotation() 方法来获取 Annotation 对象。
      或者是 getAnnotations() 方法。
      前一种方法返回指定类型的注解，后一种方法返回注解到这个元素上的所有注解。
      如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了。
      需要注意的是，如果一个注解要在运行时被成功提取，那么 @Retention(RetentionPolicy.RUNTIME) 是必须的。
     */
    public static void main(String[] args) {
        School school = new School();
        Person person = school.new Person();
        school.setPerson1(person);

        Class  clazz  = school.getClass();
        try {
            Field field = clazz.getDeclaredField("person1");
            if (field.isAnnotationPresent(TestAnnotation.class)) {
                TestAnnotation testAnnotation = field.getAnnotation(TestAnnotation.class);
                System.out.println("id=" + testAnnotation.id() + ",name=" + testAnnotation.name() + ",gender=" + testAnnotation.gender());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
