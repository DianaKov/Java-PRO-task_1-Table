package com.next_annotation;

import java.io.IOException;

public class Main {
    @Save
    public String myString;
    @Save
    public int myInt;
    public double myDouble;

    public Main(String myString, int myInt, double myDouble) {
        this.myString = myString;
        this.myInt = myInt;
        this.myDouble = myDouble;
    }

    public Main() {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException {
        Main obj = new Main("Java", 2023, 3.14);
        SerializeUtil.serialize(obj, "obj.txt");
        System.out.println(obj.myString); // Output: Java
        System.out.println(obj.myInt); // Output: 2023
        System.out.println(obj.myDouble); // Output: 3.14
        Main obj2 = new Main();
        SerializeUtil.deserialize(obj2, "obj.txt");
        System.out.println(obj2.myString); // Output: Java
        System.out.println(obj2.myInt); // Output: 2023
        System.out.println(obj2.myDouble); // Output: 0.0 (not annotated with @Save)
    }
}
