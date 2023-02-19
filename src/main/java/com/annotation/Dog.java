package com.annotation;

public class Dog extends HuntingDog{
    private String name;

    public Dog(String type,  String name, String ration,  String color, int weight) {
        super(ration, color, weight, type);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @FirstAnnotation
    public void setName(@SecondAnnotation  String name) {
        this.name = name;
    }
    @FirstAnnotation
    public String getVoice() {
        return "Собака говорит Гав-Гав";
    }
    @FirstAnnotation
    public  String eat() {
        return "Собака кушает";
    }
    @FirstAnnotation
    public String sleep() {
        return "Собака спит";
    }

    @Override
    public String toString() {
        return "Dog [getType()=" + getType() + ", name=" + name + ", getColor()=" + getColor() + ", getWeight()=" + getWeight() + ", getVoice()=" + getVoice() + ", eat()=" + eat() + ", sleep()=" + sleep()
                + ", getRation()=" + getRation() + "]";
    }

}
