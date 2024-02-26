package uz.pdp.restaurantproductservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.domain.Restaurant;
import uz.pdp.restaurantproductservice.dto.response.CustomResponseEntity;
import uz.pdp.restaurantproductservice.dto.restaurantDtos.RestaurantDto;
import uz.pdp.restaurantproductservice.dto.restaurantDtos.RestaurantSaveDto;
import uz.pdp.restaurantproductservice.exception.NotFoundException;
import uz.pdp.restaurantproductservice.exception.NullOrEmptyException;
import uz.pdp.restaurantproductservice.proxy.RestaurantProxy;
import uz.pdp.restaurantproductservice.repository.RestaurantRepository;
import uz.pdp.restaurantproductservice.security.credentials.UserCredentials;
import uz.pdp.restaurantproductservice.service.RestaurantService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantProxy restaurantProxy;
    @Override
    public RestaurantDto save(RestaurantSaveDto restaurantSaveDto) {
        CustomResponseEntity<UserCredentials> response = restaurantProxy.getById(restaurantSaveDto.getUserId());
        return new RestaurantDto(restaurantRepository.save(
                Restaurant.builder()
                        .name(restaurantSaveDto.getName())
                        .description(restaurantSaveDto.getDescription())
                        .addressId(restaurantSaveDto.getAddressId())
                        .userId(response.getBody().getId())
                        .build()
        ));
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream().map(RestaurantDto::new).toList();
    }

    @Override
    public RestaurantDto getByName(String name) {
        return new RestaurantDto(restaurantRepository.findByName(name).orElseThrow(
                () -> new NotFoundException("Restaurant")
        ));
    }

    @Override
    public RestaurantDto getByDescription(String description) {
        return new RestaurantDto(restaurantRepository.findByDescription(description).orElseThrow(
                () -> new NotFoundException("Restaurant")
        ));
    }

    @Override
    public List<RestaurantDto> getAllRestaurantsWithAccId(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
        return restaurantRepository.findAllByUserId(id).stream().map(RestaurantDto::new).toList();
    }

    @Override
    public List<RestaurantDto> getAllRestaurantsWithAddress(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
        return restaurantRepository.findAllByAddressId(id).stream().map(RestaurantDto::new).toList();
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
        restaurantRepository.deleteById(id);
        return true;
    }
}
