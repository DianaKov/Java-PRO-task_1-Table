package com.next_annotation;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SerializeUtil {
    public static void serialize(Object obj, String filename) throws IOException, IllegalAccessException {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    out.writeObject(field.getName());
                    out.writeObject(field.get(obj));
                }
            }
        }
    }

    public static void deserialize(Object obj, String filename) throws IOException, IllegalAccessException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    String fieldName = (String) in.readObject();
                    if (fieldName.equals(field.getName())) {
                        Object fieldValue = in.readObject();
                        field.set(obj, fieldValue);
                    } else {
                        throw new IllegalStateException("Field name mismatch");
                    }
                }
            }
        }
    }
}
