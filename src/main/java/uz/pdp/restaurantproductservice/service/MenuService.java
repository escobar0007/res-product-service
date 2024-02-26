package uz.pdp.restaurantproductservice.service;

import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuDto;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuCreateDto;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuUpdateDto;

import java.util.List;

@Service
public interface MenuService {
    MenuDto create(MenuCreateDto menuCreateDto);
    List<MenuDto> getAllMenus();
    MenuDto getById(Long id);
    MenuDto getByName(String name);
    MenuDto update(MenuUpdateDto menuUpdateDto);
    boolean delete(Long id);
}
