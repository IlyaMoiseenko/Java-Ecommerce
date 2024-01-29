package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "qty_in_stock")
    private int inStock;

    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private ProductCategory category;

    @ManyToMany
    @JoinTable(
            name = "tb_product_configuration",
            joinColumns = @JoinColumn(name = "fk_product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_variation_option_id", referencedColumnName = "id")
    )
    private List<VariationOption> variationOptions;
}
