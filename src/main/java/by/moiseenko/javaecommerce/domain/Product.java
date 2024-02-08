package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Transient
    private BigDecimal discountPrice;

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

    @OneToMany(mappedBy = "product")
    private List<UserReview> reviews;

    public BigDecimal getDiscountPrice() {
        if (category.getPromotion() != null) {
            int discountRate = category.getPromotion().getDiscountRate();

            BigDecimal discount = price.multiply(BigDecimal.valueOf(discountRate)).divide(BigDecimal.valueOf(100));
            discountPrice = price.subtract(discount);
        }

        return discountPrice;
    }
}
