package uz.pdp.restaurantproductservice.service;

import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.dto.restaurantDtos.RestaurantDto;
import uz.pdp.restaurantproductservice.dto.restaurantDtos.RestaurantSaveDto;

import java.util.List;


@Service
public interface RestaurantService {
    RestaurantDto save(RestaurantSaveDto restaurantSaveDto);

    List<RestaurantDto> getAllRestaurants();

    RestaurantDto getByName(String name);

    RestaurantDto getByDescription(String description);

    List<RestaurantDto> getAllRestaurantsWithAccId(Long id);

    List<RestaurantDto> getAllRestaurantsWithAddress(Long id);
    boolean delete(Long id);

}
