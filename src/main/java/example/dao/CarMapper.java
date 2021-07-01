package example.dao;


import example.models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setName(resultSet.getString("name"));
        car.setCarModel(resultSet.getString("car_model"));
        car.setCarNumber(resultSet.getInt("car_number"));
        return car;
    }
}
