package com.next_annotation;

import java.io.*;
import java.lang.reflect.Field;

public class SerializationUtils {
    /**
     * Serialize an object to a file
     *
     * @param obj the object to serialize
     * @param filename the name of the file to save the serialized object to
     */
    public static void serialize(Object obj, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Get all fields of the object's class
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                // Check if the field has the @Save annotation
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true); // Make the field accessible (even if it's private)
                    out.writeObject(field.get(obj)); // Serialize the field value
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize an object from a file
     *
     * @param cls the class of the object to deserialize
     * @param filename the name of the file to deserialize the object from
     * @return the deserialized object
     */
    public static Object deserialize(Class<?> cls, String filename) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            obj = cls.newInstance(); // Create a new instance of the class to deserialize into
            // Get all fields of the object's class
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                // Check if the field has the @Save annotation
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true); // Make the field accessible (even if it's private)
                    Object fieldValue = in.readObject(); // Deserialize the field value
                    field.set(obj, fieldValue); // Set the field value in the object
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
