package com.next_annotation;

import java.lang.reflect.Method;

public class Saver {
    public static void main(String[] args) throws Exception {
        TextContainer container = new TextContainer();
        Method[] methods = container.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SaverSaver.class)) {
                method.invoke(container);
                System.out.println("Text saved to file: " + container.getSavePath());
            }
        }
    }
}