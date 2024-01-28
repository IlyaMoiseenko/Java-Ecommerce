package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "address_line")
    private String addressLine;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;
}
