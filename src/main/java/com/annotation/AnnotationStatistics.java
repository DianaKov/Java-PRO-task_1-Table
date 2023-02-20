package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class AnnotationStatistics {
    
    public static <T> int countAnnotatedMethods(T firstClass, Class<? extends Annotation> firstAnnotationClass) {
        int count = 0;
        Class<?> cls = firstClass.getClass();
        while (!cls.equals(Object.class)) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(firstAnnotationClass)) {
                    count++;
                }
            }
            cls = cls.getSuperclass();
        }
        System.out.println(firstAnnotationClass + " has been used " + count + " times");
        return count;
    }

    public static <T> int countAnnotatedParameter(T firstClass, Class<? extends Annotation> secondAnnotationClass) {
        int count = 0;
        Class<?> cls = firstClass.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                Annotation[] annotations = parameter.getAnnotations();
                int numAnnotations = annotations.length;
                if(numAnnotations != 0){
                    count += numAnnotations;
                }
            }
        }
        System.out.println(secondAnnotationClass + " has been used " + count + " times");
        return count;
    }
}
