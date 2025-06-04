package com.example.carcrud;

import com.example.carcrud.controller.CarController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarController carController = new CarController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCar Inventory -- Main Menu:");
            System.out.print("1. Add Car, 2.  View Cars, 3. Update Car, 4. Delete Car, 5. Exit\n");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    carController.addCar(make, model);
                    break;
                case 2:
                    carController.viewCars();
                    break;
                case 3:
                    carController.viewCars();
                    System.out.print("Enter index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new make: ");
                    String newMake = scanner.nextLine();
                    System.out.print("Enter new model: ");
                    String newModel = scanner.nextLine();
                    carController.updateCar(updateIndex, newMake, newModel);
                    break;
                case 4:
                    carController.viewCars();
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    carController.deleteCar(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exited.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Not Found, please try again.");
            }
        }
    }
}
