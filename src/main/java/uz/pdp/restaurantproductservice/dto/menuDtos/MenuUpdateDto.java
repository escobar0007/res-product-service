package uz.pdp.restaurantproductservice.dto.menuDtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuUpdateDto {
    @NotEmpty
    @NotNull
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    private Boolean active;
}
