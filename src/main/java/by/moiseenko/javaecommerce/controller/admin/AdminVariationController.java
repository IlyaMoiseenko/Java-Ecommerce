package by.moiseenko.javaecommerce.controller.admin;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.dto.request.VariationToCreateRequest;
import by.moiseenko.javaecommerce.mapper.VariationMapper;
import by.moiseenko.javaecommerce.service.CategoryService;
import by.moiseenko.javaecommerce.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/variation")
@RequiredArgsConstructor
public class AdminVariationController {

    private final VariationService variationService;
    private final CategoryService categoryService;

    private final VariationMapper variationMapper;

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

    @PostMapping
    public ResponseEntity<Variation> createNewVariation(@RequestBody VariationToCreateRequest request) {
        Variation variation = variationMapper.variationToCreateRequestToVariation(request);

        return new ResponseEntity<>(
                variationService.createNewVariation(variation),
                HttpStatus.OK
        );
    }
}
