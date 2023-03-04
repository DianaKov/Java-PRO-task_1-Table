package com.next_annotation;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SerializeUtil {
    public static void serialize(Object obj, String filename) throws IOException, IllegalAccessException {
    try (FileOutputStream fos = new FileOutputStream(filename);
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         DataOutputStream out = new DataOutputStream(bos)) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                out.writeUTF(field.getName());
                out.writeUTF(field.getType().getName());
                out.writeUTF(String.valueOf(field.get(obj)));
            }
        }
    }
}

public static void deserialize(Object obj, String filename) throws IOException, IllegalAccessException, ClassNotFoundException {
    try (FileInputStream fis = new FileInputStream(filename);
         BufferedInputStream bis = new BufferedInputStream(fis);
         DataInputStream in = new DataInputStream(bis)) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                String fieldName = in.readUTF();
                if (fieldName.equals(field.getName())) {
                    String fieldType = in.readUTF();
                    if (!fieldType.equals(field.getType().getName())) {
                        throw new IllegalStateException("Field type mismatch");
                    }
                    String fieldValue = in.readUTF();
                    field.set(obj, parseValue(field.getType(), fieldValue));
                } else {
                    throw new IllegalStateException("Field name mismatch");
                }
            }
        }
    }
}

private static Object parseValue(Class<?> fieldType, String fieldValue) {
    if (fieldType == boolean.class) {
        return Boolean.parseBoolean(fieldValue);
    } else if (fieldType == byte.class) {
        return Byte.parseByte(fieldValue);
    } else if (fieldType == short.class) {
        return Short.parseShort(fieldValue);
    } else if (fieldType == int.class) {
        return Integer.parseInt(fieldValue);
    } else if (fieldType == long.class) {
        return Long.parseLong(fieldValue);
    } else if (fieldType == float.class) {
        return Float.parseFloat(fieldValue);
    } else if (fieldType == double.class) {
        return Double.parseDouble(fieldValue);
    } else if (fieldType == char.class) {
        return fieldValue.charAt(0);
    } else if (fieldType == String.class) {
        return fieldValue;
    } else {
        throw new IllegalArgumentException("Unsupported field type: " + fieldType.getName());
    }
}

}
