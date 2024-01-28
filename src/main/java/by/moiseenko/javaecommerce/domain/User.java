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
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "fk_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_address_id", referencedColumnName = "id")
    )
    private List<Address> addresses;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_country_id")
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
