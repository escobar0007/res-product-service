package uz.pdp.restaurantproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantProductServiceApplication.class, args);
    }

}
