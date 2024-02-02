package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 2.02.24
*/

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariationRequest {

    @NotNull(message = "This field should not be null")
    private String name;

    @NotNull(message = "This field should not be null")
    private List<VariationOptionRequest> options;
}
