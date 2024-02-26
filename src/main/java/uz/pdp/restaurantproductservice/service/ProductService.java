package uz.pdp.restaurantproductservice.service;

import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.dto.productDtos.ProductDto;
import uz.pdp.restaurantproductservice.dto.productDtos.ProductSaveDto;

import java.util.List;

@Service
public interface ProductService {
    ProductDto save(ProductSaveDto productSaveDto);

    ProductDto getById(Long id);

    ProductDto getByTitle(String title);

    ProductDto getByDescription(String description);

    List<ProductDto> getAllByUserId(Long userId);

    List<ProductDto> getAll();

    boolean delete(Long id);


}
