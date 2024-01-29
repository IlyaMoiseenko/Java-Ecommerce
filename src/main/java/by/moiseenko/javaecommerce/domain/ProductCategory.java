package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String  name;
}
