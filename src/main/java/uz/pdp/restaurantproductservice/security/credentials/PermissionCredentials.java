package uz.pdp.restaurantproductservice.security.credentials;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionCredentials {
    private Long id;
    private String value;
}
