package com.example.carcrud.repository;

import com.example.carcrud.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static final Logger logger = LoggerFactory.getLogger(CarRepository.class);
    private static final String DB_URL = "jdbc:h2:./data/car_database";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public CarRepository() {
        createTable();
    }

    private void createTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS cars (id INT AUTO_INCREMENT, make VARCHAR(255), model VARCHAR(255), PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            logger.info("Database table created or verified.");
        } catch (SQLException e) {
            logger.error("Error creating table", e);
        }
    }

    public void addCar(String make, String model) {
        String sql = "INSERT INTO cars (make, model) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, make);
            pstmt.setString(2, model);
            pstmt.executeUpdate();
            logger.info("Car added: {} {}", make, model);
        } catch (SQLException e) {
            logger.error("Error adding car", e);
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT make, model FROM cars";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cars.add(new Car(rs.getString("make"), rs.getString("model")));
            }
            logger.info("Retrieved {} cars", cars.size());
        } catch (SQLException e) {
            logger.error("Error fetching cars", e);
        }
        return cars;
    }
    public void updateCar(int id, String newMake, String newModel) {
        String sql = "UPDATE cars SET make = ?, model = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newMake);
            pstmt.setString(2, newModel);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                logger.info("Car updated successfully: ID={} New Make={}, New Model={}", id, newMake, newModel);
            } else {
                logger.warn("No car found with ID {}", id);
            }
        } catch (SQLException e) {
            logger.error("Error updating car", e);
        }
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            logger.info("Car deleted with ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error deleting car", e);
        }
    }
}
