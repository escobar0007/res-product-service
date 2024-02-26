package uz.pdp.restaurantproductservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.restaurantproductservice.domain.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);
    Optional<Restaurant> findByDescription(String description);
    List<Restaurant> findAllByUserId(Long id);
    List<Restaurant> findAllByAddressId(Long id);
}