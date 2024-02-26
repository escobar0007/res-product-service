package uz.pdp.restaurantproductservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuCreateDto;
import uz.pdp.restaurantproductservice.dto.menuDtos.MenuUpdateDto;
import uz.pdp.restaurantproductservice.service.MenuService;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MenuCreateDto menuCreateDto) {
        return ResponseEntity.ok(menuService.create(menuCreateDto));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.getById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return ResponseEntity.ok(menuService.getByName(name));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MenuUpdateDto menuUpdateDto) {
        return ResponseEntity.ok(menuService.update(menuUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.ok(true);
    }
}
