package pl.monikamaria.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.monikamaria.car.model.Car;
import pl.monikamaria.car.model.Color;
import pl.monikamaria.car.service.CarService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carSrv;

    @Autowired
    public CarController(CarService carSrv) {
        this.carSrv = carSrv;
    }

    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carSrv.getCars());
        return "car/cars";
    }

    @GetMapping("/add")
    public String getAddCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("colors", Color.values());
        return "car/add-car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        carSrv.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/modify/{id}")
    public String getCarById(@PathVariable long id, Model model) {
        Optional<Car> car = carSrv.getCarById(id);
        model.addAttribute("car", car.get());
        model.addAttribute("colors", Color.values());
        return "car/mod-car";
    }

    @PostMapping("/modify")
    public String modCar(@ModelAttribute Car car) {
        carSrv.modCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String removeCarById(@PathVariable Long id) {
        carSrv.removeCarById(id);
        return "redirect:/cars";
    }
}
