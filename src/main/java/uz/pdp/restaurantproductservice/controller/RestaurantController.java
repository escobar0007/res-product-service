package uz.pdp.restaurantproductservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.restaurantproductservice.dto.restaurantDtos.RestaurantSaveDto;
import uz.pdp.restaurantproductservice.service.RestaurantService;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<?> save(RestaurantSaveDto restaurantSaveDto) {
        return ResponseEntity.ok(restaurantService.save(restaurantSaveDto));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return ResponseEntity.ok(restaurantService.getByName(name));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok(true);
    }
}
