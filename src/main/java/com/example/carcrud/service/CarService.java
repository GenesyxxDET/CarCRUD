package com.example.carcrud.service;

import com.example.carcrud.model.Car;
import com.example.carcrud.repository.CarRepository;
import java.util.List;

public class CarService {
    private final CarRepository carRepository = new CarRepository();

    public void addCar(String make, String model) {
        carRepository.addCar(make, model);
    }

    public List<Car> getCars() {
        return carRepository.getAllCars();
    }
    public void updateCar(int id, String newMake, String newModel) {
        carRepository.updateCar(id, newMake, newModel);
    }

    public void deleteCar(int id) {
        carRepository.deleteCar(id);
    }
}
