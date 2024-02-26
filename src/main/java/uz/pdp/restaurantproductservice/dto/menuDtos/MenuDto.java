package uz.pdp.restaurantproductservice.dto.menuDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.restaurantproductservice.domain.Menu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    Long id;
    String name;
    Boolean active;
    List<NestedProductDto> products;

    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.active = menu.getActive();
        this.products = menu.getProducts().stream()
                .map(product -> new NestedProductDto(
                        product.getId(),
                        product.getTitle(),
                        product.getDescription(),
                        product.getDefaultPrice()
                )).toList();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NestedProductDto implements Serializable {
        Long id;
        String title;
        String description;
        Double defaultPrice;
    }
}