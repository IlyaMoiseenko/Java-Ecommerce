package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.ProductCategory;
import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.repository.VariationRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class VariationService {

    private final VariationRepository variationRepository;

    @Transactional(readOnly = true)
    public Variation getByName(String name) {
        return variationRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(Variation.class, Map.of("name", name)));
    }

    @Transactional(readOnly = true)
    public Variation getByNameAndCategory(String name, ProductCategory category) {
        return variationRepository.findByNameAndCategory(name, category)
                .orElseThrow(() -> new EntityNotFoundException(Variation.class, Map.of("name", name, "Category", category.getName())));
    }
}
