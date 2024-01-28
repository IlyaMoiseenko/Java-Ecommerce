package by.moiseenko.javaecommerce.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    @author Ilya Moiseenko on 28.01.24
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    @NotNull(message = "This field should not be null")
    @Email
    private String email;

    @NotNull(message = "This field should not be null")
    private String password;
}

