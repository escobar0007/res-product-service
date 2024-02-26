package uz.pdp.restaurantproductservice.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantAuthentication {
    private Object principal;
    private Object credentials;
    private List<String> permissions;

    public static UsernamePasswordAuthenticationToken cast(RestaurantAuthentication restaurantAuthentication){
        return new UsernamePasswordAuthenticationToken(
                restaurantAuthentication.getPrincipal(),
                restaurantAuthentication.getCredentials(),
                restaurantAuthentication.getPermissions().stream().map(SimpleGrantedAuthority::new).toList());
    }
}
