package uz.pdp.restaurantproductservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.restaurantproductservice.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String title);
    Optional<Product> findByDescription(String description);
    List<Product> findAllByUserId(Long id);
}