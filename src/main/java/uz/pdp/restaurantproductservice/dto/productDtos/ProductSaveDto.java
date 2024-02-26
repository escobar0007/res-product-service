package uz.pdp.restaurantproductservice.dto.productDtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductSaveDto {
    @NotNull
    @NotEmpty
    private String title;
    private String description;
    @NotNull
    @NotEmpty
    private Double defaultPrice;
    @NotNull
    @NotEmpty
    private Long userId;
    @NotNull
    @NotEmpty
    private Long menuId;
}
