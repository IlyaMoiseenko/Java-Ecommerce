package by.moiseenko.javaecommerce.mapper;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.Address;
import by.moiseenko.javaecommerce.domain.dto.request.AddressRequest;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address addressRequestToAddress(AddressRequest addressRequest) {
        return Address
                .builder()
                .city(addressRequest.getCity())
                .addressLine(addressRequest.getAddressLine())
                .postalCode(addressRequest.getPostalCode())
                .build();
    }

    public AddressRequest addressToAddressRequest(Address address) {
        return AddressRequest
                .builder()
                .city(address.getCity())
                .addressLine(address.getAddressLine())
                .postalCode(address.getPostalCode())
                .build();
    }
}
