package com.next_annotation;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SerializeUtil {
    public static void serialize(Object obj, String filename) throws IOException, IllegalAccessException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    out.writeObject(field.get(obj));
                }
            }
        }
    }

    public static void deserialize(Object obj, String filename) throws IOException, IllegalAccessException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    Object fieldValue = in.readObject();
                    field.set(obj, fieldValue);
                }
            }
        }
    }
}
