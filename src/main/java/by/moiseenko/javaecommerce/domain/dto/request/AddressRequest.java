package by.moiseenko.javaecommerce.domain.dto.request;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotNull(message = "This field should not be null")
    private String city;

    @NotNull(message = "This field should not be null")
    private int postalCode;

    @NotNull(message = "This field should not be null")
    private String addressLine;
}
