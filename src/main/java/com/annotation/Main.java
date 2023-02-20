package com.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Dog firstClass = new Dog("Терьер", "Малыш", "Корм", "Черный", 20);
        AnnotationStatistics.countAnnotatedMethods(firstClass, FirstAnnotation.class);
        AnnotationStatistics.countAnnotatedParameter(firstClass, SecondAnnotation.class);
    }
}
