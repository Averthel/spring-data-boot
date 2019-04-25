package pl.ave.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ave.model.Car;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    /*
    count() - zliczailość rekordów w danym repozytorium (ilość rekordów w bazie danych),
    deleteById(id) - usuwa rekord o wskazanym id,
    deleteAll(Iterable) - usuwa z bazy danych encje zapisane w kolekcji przekazanej jako argument metody. Kolekcja powinna implementować interfejs Iterable,
    delete(entity) - usuwa z repozytorium encję przekazaną jako argument,
    deleteAll() - usuwa z repozytorium wszystkie rekordy,
    existsById(id) - sprawdza istnieje rekordu o wskazanym id,
    findAll() - zwraca kolekcję wszystkich obiektów w repozytorium,
    findAllById(ids) - zwraca kolekcję obiektów, których id znalazło się w kolekcji przekazanej jako argument,
    findById(id) - zwraca z repozytorium Optionala z obiektem o wskazanym id,
    save(entity) - zapisuje w repozytorium wszystkie rekordy z kolekcji przekazanej jako argument,
    saveAll(iterable) - zapisuje w repozytorium pojedynczy obiekt.
    */

    List<Car> findByBrand(String brand);

    //pierwszy samochód danej marki
    Car findFirstByBrand(String brand);

    //pierwszy samochód ze wskazaną ceną
    Car findFirsByPrice(double price);
    // lub alternatywnie:
    //Car findTopByPrice(double price);

    //pierwsze trzy samochody z bazy
    List<Car> findFirst3ByBrand(String brand);

    //samochody danej marki o wskazanej cenie
    List<Car> findAllByBrandAndPrice(String brand, double price);

    //samochody jednej z dwóch marek
    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    //samochody z marką określoną przez wzorzec, np. "A%" - rozpoczynające się od A
    List<Car> findAllByBrandLike(String pattern);

    //samochody o nazwach kończących się na wskazany ciąg znaków
    List<Car> findAllByNameEndingWith(String pattern);

    //samochody o cenach niższych od
    List<Car> findAllByPriceLessThan(double price);

    //samochody o cenie pomiędzy low i high
    List<Car> findAllByPriceBetween(double low, double high);

    //wszystkie samochody danego producenta z ceną rosnąco
    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    //wszystkie samochody z ustawioną marką
    List<Car> findAllByBrandNotNull();

    //wszystkie samochody z nazwą należącą do kolekcji
    List<Car> findAllByNameIn(Collection<String> names);

}



