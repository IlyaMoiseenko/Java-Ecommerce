package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.service.CategoryService;
import by.moiseenko.javaecommerce.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/variation")
@RequiredArgsConstructor
public class VariationController {

    private final VariationService variationService;
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Variation>> getAll() {
        return new ResponseEntity<>(
                variationService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/n")
    public ResponseEntity<Variation> getByName(@RequestParam(value = "name", required = true) String name) {
        return new ResponseEntity<>(
                variationService.getByName(name),
                HttpStatus.OK
        );
    }

    @GetMapping("/c")
    public ResponseEntity<List<Variation>> getAllByCategory(@RequestParam(value = "category", required = true) String categoryName) {
        ProductCategory category = categoryService.getByName(categoryName);

        return new ResponseEntity<>(
                variationService.getAllByCategory(category),
                HttpStatus.OK
        );
    }
}
