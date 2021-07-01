package example.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Car {
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 3, max = 30, message = "Car name should contain from 5 to 30 characters")
    private String name;

    @NotEmpty(message = "Car model shouldn't be empty")
    private String carModel;

    @Min(value = 99999, message = "Car number should consist of 6 numbers, starting from 1 to 9")
    @Max(value = 999999, message = "Car number should consist of 6 numbers")
    private int carNumber;

    public Car() {};

    public Car(int id, String name, String carModel, int carNumber) {
        this.id = id;
        this.name = name;
        this.carModel = carModel;
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}