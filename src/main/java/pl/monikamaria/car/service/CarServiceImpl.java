package pl.monikamaria.car.service;

import org.springframework.stereotype.Service;
import pl.monikamaria.car.model.Car;
import pl.monikamaria.car.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();

        carList.add(new Car(1L, "BMW", "M1", Color.BLACK));
        carList.add(new Car(2L, "Ferrari", "456", Color.WHITE));
        carList.add(new Car(3L, "Renault", "Trafic", Color.SILVER));
        carList.add(new Car(4L, "Tesla", "Model S", Color.BLACK));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carList.stream().filter(car -> color.equalsIgnoreCase(car.getColor().name())).collect(Collectors.toList());
    }

    @Override
    public boolean addCar(Car car) {
        car.setId(carList.get(carList.size() - 1).getId() + 1);
        return carList.add(car);
    }

    @Override
    public boolean modCar(Car modCar) {
        Optional<Car> foundCar = carList.stream().filter(car -> car.getId().equals(modCar.getId())).findFirst();

        if (foundCar.isPresent()) {
            Car car = foundCar.get();
            int index = carList.indexOf(car);
            carList.set(index, modCar);
            return true;
        }
        return false;

    }

    @Override
    public boolean modCarModel(Long id, String model) {
        Optional<Car> foundCar = carList.stream().filter(car -> car.getId() == id).findFirst();

        if (foundCar.isPresent()) {
            Car car = foundCar.get();
            car.setModel(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCarById(Long id) {
        Optional<Car> foundCar = carList.stream().filter(car -> car.getId().equals(id)).findFirst();
        if (foundCar.isPresent()) {
            carList.remove(foundCar.get());
            return true;
        }
        return false;
    }

}
