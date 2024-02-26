package uz.pdp.restaurantproductservice.dto.productDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.restaurantproductservice.domain.Product;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
    Long id;
    String title;
    String description;
    Double defaultPrice;
    Long userId;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.defaultPrice = product.getDefaultPrice();
        this.userId = product.getUserId();
    }
}