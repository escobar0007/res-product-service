package uz.pdp.restaurantproductservice.security.jwt;

import io.micrometer.common.lang.NonNullApi;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.restaurantproductservice.dto.response.CustomResponseEntity;
import uz.pdp.restaurantproductservice.proxy.RestaurantProxy;
import uz.pdp.restaurantproductservice.security.RestaurantAuthentication;

@Component
@RequiredArgsConstructor
@NonNullApi
public class JwtTokenFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    private final RestaurantProxy restaurantProxy;
    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  {
        String token = request.getHeader(AUTHORIZATION);
        if (token != null && token.startsWith(BEARER)) {
            CustomResponseEntity<RestaurantAuthentication> verify = restaurantProxy.verify(token.split(" ")[1]);
            if (verify.getBody() != null)
                SecurityContextHolder.getContext().setAuthentication(
                        RestaurantAuthentication.cast(verify.getBody())
                );
        }
        filterChain.doFilter(request, response);
    }
}
