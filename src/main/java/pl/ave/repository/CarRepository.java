package pl.ave.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ave.model.Car;


@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
