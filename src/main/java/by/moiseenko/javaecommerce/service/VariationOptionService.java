package by.moiseenko.javaecommerce.service;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import by.moiseenko.javaecommerce.domain.Variation;
import by.moiseenko.javaecommerce.domain.VariationOption;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import by.moiseenko.javaecommerce.repository.VariationOptionRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VariationOptionService {

    private final VariationOptionRepository variationOptionRepository;

    @Transactional
    public VariationOption createNewVariationOption(VariationOption variationOption) {
        return variationOptionRepository.save(variationOption);
    }

    public List<VariationOption> getAll() {
        return variationOptionRepository.findAll();
    }

    public VariationOption getByValue(String value) {
        return variationOptionRepository.findByValue(value)
                .orElseThrow(() -> new EntityNotFoundException(VariationOption.class, Map.of("value", value)));
    }

    public List<VariationOption> getAllByVariation(Variation variation) {
        return variationOptionRepository.findAllByVariation(variation);
    }

    public VariationOption getByValueAndVariation(String value, Variation variation) {
        return variationOptionRepository.findByValueAndVariation(value, variation)
                .orElseThrow(() -> new EntityNotFoundException(VariationOption.class, Map.of("value", value, "variation", variation.getName())));
    }
}
