package uz.pdp.restaurantproductservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.restaurantproductservice.domain.Menu;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuCreateDto;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuDto;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuUpdateDto;
import uz.pdp.restaurantproductservice.exception.NotFoundException;
import uz.pdp.restaurantproductservice.exception.NullOrEmptyException;
import uz.pdp.restaurantproductservice.repository.MenuRepository;
import uz.pdp.restaurantproductservice.service.MenuService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Override
    public MenuDto create(MenuCreateDto menuCreateDto) {
        return new MenuDto(menuRepository.save(Menu.builder()
                .name(menuCreateDto.getName())
                .active(true)
                .products(null)
                .build()));
    }

    @Override
    public List<MenuDto> getAllMenus() {
        return menuRepository.findAll().stream().map(MenuDto::new).toList();
    }

    @Override
    public MenuDto getById(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
        return new MenuDto(menuRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Menu")
        ));
    }

    @Override
    public MenuDto getByName(String name) {
        if (name == null)
            throw new NullOrEmptyException("name");
        return new MenuDto(menuRepository.findByName(name).orElseThrow(
                () -> new NotFoundException("Menu")
        ));
    }

    @Override
    public MenuDto update(MenuUpdateDto menuUpdateDto) {
        Menu initialMenu = menuRepository.findById(menuUpdateDto.getId()).orElseThrow(
                () -> new NotFoundException("Menu")
        );

        initialMenu.setId(Objects.requireNonNullElse(menuUpdateDto.getId(), initialMenu.getId()));
        initialMenu.setName(Objects.requireNonNull(menuUpdateDto.getName(), initialMenu.getName()));
        initialMenu.setActive(Objects.requireNonNull(menuUpdateDto.getActive()));
        return new MenuDto(menuRepository.save(initialMenu));
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new NullOrEmptyException("id");
        }
       menuRepository.deleteById(id);
        return true;
    }
}
