package com.example.carcrud.model;

import javax.validation.constraints.NotBlank;

public class Car {
    @NotBlank(message = "Make cannot be empty")
    private String make;

    @NotBlank(message = "Model cannot be empty")
    private String model;


    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return " Car Make: " + make + ", Model: " + model;
    }
}
