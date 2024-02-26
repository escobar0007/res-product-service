package uz.pdp.restaurantproductservice.dto.restaurantDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.restaurantproductservice.domain.Product;
import uz.pdp.restaurantproductservice.domain.Restaurant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto{
    Long id;
    String name;
    String description;
    Long addressId;
    Long userId;
    List<NestedMenuDto> menus;

    public RestaurantDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.addressId = restaurant.getAddressId();
        this.userId = restaurant.getUserId();
        this.menus = restaurant.getMenus().stream()
                .map(menu -> new NestedMenuDto(
                        menu.getId(),
                        menu.getName(),
                        menu.getActive(),
                        menu.getProducts().stream()
                                .map(NestedMenuDto.NestedProductDto::new).toList()
                )).toList();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NestedMenuDto implements Serializable {
        Long id;
        String name;
        Boolean active;
        List<NestedProductDto> products;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class NestedProductDto implements Serializable {
            String title;
            String description;
            Double defaultPrice;

            public NestedProductDto(Product product) {
                this.title = product.getTitle();
                this.description = product.getDescription();
                this.defaultPrice = product.getDefaultPrice();
            }
        }
    }
}