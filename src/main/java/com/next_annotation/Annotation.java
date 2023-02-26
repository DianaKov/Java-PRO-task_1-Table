package com.next_annotation;

import java.lang.reflect.Method;

/**
 * 1. Создать аннотацию, которая принимает параметры для метода. Написать код, который
 * вызовет метод, помеченный этой аннотацией, и передаст параметры аннотации в
 * вызываемый метод.
 */
public class Annotation {
    @Test(a=2, b=5)
    public void test(int a, int b) {
        int c = a * b;
        System.out.println(c);
    }

    public static void main(String[] args) throws Exception {
        Annotation example = new Annotation();
        Method[] methods = example.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);
                int a = annotation.a();
                int b = annotation.b();
                method.invoke(example, a, b);
            }
        }
    }
}
