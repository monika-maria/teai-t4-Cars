package pl.monikamaria.car.service;

import pl.monikamaria.car.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(Long id);

    List<Car> getCarsByColor(String color);

    boolean addCar(Car car);

    boolean modCar(Car car);

    boolean modCarModel(Long id, String model);

    boolean removeCarById(Long id);
}
