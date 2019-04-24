package pl.ave;

import pl.ave.model.Car;
import pl.ave.repository.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBootApplication.class, args);


        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "Focus", 65000.0));
        cars.add(new Car("Ford", "Fiesta", 45000.0));
        cars.add(new Car("Ford", "Mondeo", 85000.0));

        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save);

        Car firstCar = carRepo.findById(1L).get();
        carRepo.delete(firstCar);

        carRepo.findAll().forEach(System.out::println);
    }

}
