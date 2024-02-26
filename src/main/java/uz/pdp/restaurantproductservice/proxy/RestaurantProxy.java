package uz.pdp.restaurantproductservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.restaurantproductservice.dto.response.CustomResponseEntity;
import uz.pdp.restaurantproductservice.security.RestaurantAuthentication;
import uz.pdp.restaurantproductservice.security.credentials.UserCredentials;

@FeignClient(name = "res-authentication-service")
public interface RestaurantProxy {
    @GetMapping("/verify")
    CustomResponseEntity<RestaurantAuthentication> verify(@RequestParam String token);

    @GetMapping("/api/v1/users/{id}")
    CustomResponseEntity<UserCredentials> getById(@PathVariable Long id);

}
