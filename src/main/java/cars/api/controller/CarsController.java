package cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cars.api.dto.CarsDTO;
import cars.api.model.Car;
import cars.api.repository.CarsRepository;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    @Autowired
    private CarsRepository repository;

    @GetMapping
    public List<Car> getCars() {
        return repository.findAll();
    }

    @PostMapping
    public void createCar(@RequestBody CarsDTO request) {
        repository.save(new Car(request));
    }
}       
