package uz.pdp.restaurantproductservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.domain.Menu;
import uz.pdp.restaurantproductservice.domain.Product;
import uz.pdp.restaurantproductservice.dto.productDtos.ProductDto;
import uz.pdp.restaurantproductservice.dto.productDtos.ProductSaveDto;
import uz.pdp.restaurantproductservice.dto.response.CustomResponseEntity;
import uz.pdp.restaurantproductservice.exception.NotFoundException;
import uz.pdp.restaurantproductservice.exception.NullOrEmptyException;
import uz.pdp.restaurantproductservice.proxy.RestaurantProxy;
import uz.pdp.restaurantproductservice.repository.MenuRepository;
import uz.pdp.restaurantproductservice.repository.ProductRepository;
import uz.pdp.restaurantproductservice.security.credentials.UserCredentials;
import uz.pdp.restaurantproductservice.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;
    private final RestaurantProxy restaurantProxy;

    @Override
    public ProductDto save(ProductSaveDto productSaveDto) {
        Menu menu = menuRepository.findById(productSaveDto.getMenuId()).orElseThrow(
                () -> new NotFoundException("Menu")
        );

        CustomResponseEntity<UserCredentials> response = restaurantProxy.getById(productSaveDto.getUserId());
        Product product = productRepository.save(
                Product.builder()
                        .title(productSaveDto.getTitle())
                        .description(productSaveDto.getDescription())
                        .defaultPrice(productSaveDto.getDefaultPrice())
                        .userId(response.getBody().getId())
                        .build()
        );

        return new ProductDto(product);
    }

    @Override
    public ProductDto getById(Long id) {
       if (id == null) {
           throw new NullOrEmptyException("id");
       }
       return new ProductDto(productRepository.findById(id).orElseThrow(
               () -> new NotFoundException("Product")
       ));
    }

    @Override
    public ProductDto getByTitle(String title) {
        if (title == null) {
            throw new NullOrEmptyException("title");
        }
        return new ProductDto(productRepository.findByTitle(title).orElseThrow(
                () -> new NotFoundException("Product")
        ));
    }

    @Override
    public ProductDto getByDescription(String description) {
        if (description == null) {
            throw new NullOrEmptyException("description");
        }
        return new ProductDto(productRepository.findByDescription(description).orElseThrow(
                () -> new NotFoundException("Product")
        ));
    }

    @Override
    public List<ProductDto> getAllByUserId(Long userId) {
        return productRepository.findAllByUserId(userId).stream().map(ProductDto::new).toList();
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(ProductDto::new).toList();
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
        productRepository.deleteById(id);
        return true;
    }
}
