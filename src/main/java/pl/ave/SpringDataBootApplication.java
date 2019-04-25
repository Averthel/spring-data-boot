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
        cars.add(new Car( "Focus","Ford", 65000.0));
        cars.add(new Car( "Fiesta","Ford", 45000.0));
        cars.add(new Car( "Mondeo", "Ford",85000.0));
        cars.add(new Car( "Yaris","Toyota", 11000.0));
        cars.add(new Car( "Civic","Honda", 8000.0));
        cars.add(new Car("X5", "BMW", 80000.0));
        cars.add(new Car( "Q5", "Audi",110000.0));
        cars.add(new Car( "Omega","Opel", 5000.0));

        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save); //Zapisanie samochodów do bazy

        System.out.println("First By Brand: "); //First
        Car firstByBrand = carRepo.findFirstByBrand("Ford");
        System.out.println(firstByBrand);

        System.out.println("All Fords"); //All
        List<Car> fords = carRepo.findByBrand("Ford");
        fords.forEach(System.out::println);

        //And / Or
        System.out.println("Ford for 45000");
        carRepo.findAllByBrandAndPrice("Ford", 45000).forEach(System.out::println);
        System.out.println("lub: ");
        carRepo.findAllByBrandOrBrand("BMW", "Audi").forEach(System.out::println);

        //lessThan, between
        System.out.println("Cars cheaper than 30000");
        carRepo.findAllByPriceLessThan(30000).forEach(System.out::println);
        System.out.println("Cars with price between 40-80k");
        carRepo.findAllByPriceBetween(40000, 80000).forEach(System.out::println);

        carRepo.findAll().forEach(System.out::println);

        ctx.close();
    }

}
