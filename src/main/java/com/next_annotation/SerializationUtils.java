package com.next_annotation;

import java.io.*;
import java.lang.reflect.Field;

public class SerializationUtils {

    public static void serialize(Object obj, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true); 
                    out.writeObject(field.get(obj)); 
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(Class<?> cls, String filename) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            obj = cls.newInstance(); 
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true); 
                    Object fieldValue = in.readObject();
                    field.set(obj, fieldValue); 
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
