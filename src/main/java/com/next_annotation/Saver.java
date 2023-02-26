package com.next_annotation;
/**
 * 2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма 
 * аннотаций указать 1) в какой файл должен сохраниться текст 2) метод, который выполнит 
 * сохранение. Написать класс Saver, который сохранит поле класса TextContainer в указанный 
 * файл.
 */

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
