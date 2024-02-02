package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public ProductCategory createNewCategory(ProductCategory category) {
        return categoryRepository.save(category);
    }

    public ProductCategory getByName(String name) {

        return categoryRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(ProductCategory.class, Map.of("name", name)));
    }

    public List<ProductCategory> getAll() {
        return categoryRepository.findAll();
    }
}
