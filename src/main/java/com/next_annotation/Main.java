package com.next_annotation;

public class Main {
    @Save
    private String myString;
    @Save
    private int myInt;
    private double myDouble;

    public Main() {

    }
    public Main(String myString, int myInt, double myDouble) {
        this.myString = myString;
        this.myInt = myInt;
        this.myDouble = myDouble;
    }

    public static void main(String[] args) {
        Main obj = new Main("Java", 2023, 3.14);
        SerializationUtils.serialize(obj, "myclass.ser");
        Main obj2 = (Main) SerializationUtils.deserialize(Main.class, "myclass.ser");
        System.out.println(obj2.myString); // Output: Java
        System.out.println(obj2.myInt); // Output: 2023
        System.out.println(obj2.myDouble); // Output: 0.0 (not annotated with @Save)
    }
}
