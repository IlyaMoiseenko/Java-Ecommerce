package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationOptionToCreateRequest {

    @NotNull(message = "This field should not be null")
    private String value;

    @NotNull(message = "This field should not be null")
    private String variationName;
}
