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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/name/{variationName}")
    public ResponseEntity<Variation> getByName(@PathVariable("variationName") String name) {
        return new ResponseEntity<>(
                variationService.getByName(name),
                HttpStatus.OK
        );
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Variation>> getAllByCategory(@PathVariable("categoryName") String categoryName) {
        ProductCategory category = categoryService.getByName(categoryName);

        return new ResponseEntity<>(
                variationService.getAllByCategory(category),
                HttpStatus.OK
        );
    }
}
