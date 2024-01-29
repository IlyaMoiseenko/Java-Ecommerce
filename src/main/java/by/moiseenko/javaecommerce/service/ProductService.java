package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import by.moiseenko.javaecommerce.domain.Product;
import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Product.class, Map.of("id", id.toString())));
    }

    @Transactional(readOnly = true)
    public Page<Product> getAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Page<Product> getAllByName(String name, int page, int size) {
        return productRepository.findAllByNameContaining(name, PageRequest.of(page, size));
    }

    @Transactional(readOnly = true)
    public Page<Product> getAllByCategoryName(String categoryName, int page, int size) {
        return productRepository.findAllByCategoryName(categoryName, PageRequest.of(page, size));
    }
}
