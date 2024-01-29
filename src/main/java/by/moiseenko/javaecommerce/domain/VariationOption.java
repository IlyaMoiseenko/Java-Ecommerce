package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_variation_option")
public class VariationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "fk_variation_id")
    private Variation variation;

    @ManyToMany(mappedBy = "variationOptions")
    @JsonIgnore
    private List<Product> products;
}
