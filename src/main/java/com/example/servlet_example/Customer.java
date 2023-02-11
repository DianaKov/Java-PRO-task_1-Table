package com.example.servlet_example;

public class Customer {

    private int number;
    private String city;
    private String manager;
    private String model;
    private int year;
    private double volume;
    private String transmission;
    private String driveUnit;
    private String steeringWheel;
    private String color;
    private int price;
    private String fullName;
    private int telephone;
    private String email;
    private String paymentState;

    public Customer(int number, String city, String manager, String model, int year, double volume, String transmission,
                    String driveUnit, String steeringWheel, String color, int price, String fullName, int telephone,
                    String email, String paymentState) {
        super();
        this.number = number;
        this.city = city;
        this.manager = manager;
        this.model = model;
        this.year = year;
        this.volume = volume;
        this.transmission = transmission;
        this.driveUnit = driveUnit;
        this.steeringWheel = steeringWheel;
        this.color = color;
        this.price = price;
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.paymentState = paymentState;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", manager='" + manager + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", volume='" + volume + '\'' +
                ", transmission='" + transmission + '\'' +
                ", driveUnit='" + driveUnit + '\'' +
                ", steeringWheel='" + steeringWheel + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", fullName='" + fullName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", paymentState='" + paymentState + '\'' +
                '}';
    }

}