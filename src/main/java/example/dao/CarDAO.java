package example.dao;

import example.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    public static int CAR_ID;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() {
        return jdbcTemplate.query("SELECT * FROM Car", new CarMapper());
    }

    public Car show(int id) {
        return jdbcTemplate.query("SELECT * FROM Car WHERE id=?", new Object[]{id}, new CarMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Car car){
        jdbcTemplate.update("INSERT INTO Car VALUES (?, ?, ?, ?)", ++CAR_ID, car.getName(), car.getCarModel(), car.getCarNumber());
    }

    public void update(int id, Car updatedCar){
        jdbcTemplate.update("UPDATE Car SET name=?, car_model=?, car_number=? WHERE id=?", updatedCar.getName(),
                updatedCar.getCarModel(), updatedCar.getCarNumber(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Car WHERE id=?", id);
    }
}
