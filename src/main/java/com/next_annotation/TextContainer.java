package com.next_annotation;
import java.lang.annotation.*;
import java.io.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface SaveTo {
    String path();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SaverSaver {
}

@SaveTo(path="D:\\ProgAcademy\\Java Idea (курс Java PRO)\\Java-PRO-task_1-Table-main\\src\\main\\java\\com\\next_annotation\\file.txt")
class TextContainer {
    String text = "Hello, world!";

    @SaverSaver
    public void save() throws IOException {
        File file = new File(getSavePath());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        }
    }

    String getSavePath() throws IOException {
        SaveTo annotation = getClass().getAnnotation(SaveTo.class);
        if (annotation == null) {
            throw new IOException("SaveTo annotation not found");
        }
        return annotation.path();
    }
}