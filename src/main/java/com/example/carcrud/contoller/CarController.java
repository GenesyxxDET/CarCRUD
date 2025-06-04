package com.example.carcrud.controller;

import com.example.carcrud.service.CarService;
import com.example.carcrud.model.Car;
import java.util.List;

public class CarController {
    private final CarService carService = new CarService();

    public void addCar(String make, String model) {
        carService.addCar(make, model);
    }

    public void viewCars() {
        List<Car> cars = carService.getCars();

        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i)); // Using list index for numbering
        }
    }

    public void updateCar(int index, String newMake, String newModel) {
        carService.updateCar(index, newMake, newModel);
    }

    public void deleteCar(int index) {
        carService.deleteCar(index);
    }
}
