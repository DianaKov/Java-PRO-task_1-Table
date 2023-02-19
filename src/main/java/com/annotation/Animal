package com.annotation;

public class Animal {
    private String ration;
    private String color;
    private int weight;
    public Animal(String ration,  String color,  int weight) {
        super();
        this.ration = ration;
        this.color = color;
        this.weight = weight;
    }

    public Animal() {
        super();
    }

    public String getRation() {
        return ration;
    }
    @FirstAnnotation
    public void setRation(@SecondAnnotation String ration) {
        this.ration = ration;
    }
    @FirstAnnotation
    public String getColor() {
        return color;
    }
    @FirstAnnotation
    public void setColor(@SecondAnnotation String color) {
        this.color = color;
    }
    @FirstAnnotation
    public int getWeight() {
        return weight;
    }

    public void setWeight(@SecondAnnotation int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal [ration=" + ration + ", color=" + color + ", weight=" + weight + "]";
    }

}
