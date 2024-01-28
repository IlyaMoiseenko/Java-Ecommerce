package by.moiseenko.javaecommerce.domain.dto.response;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
}
