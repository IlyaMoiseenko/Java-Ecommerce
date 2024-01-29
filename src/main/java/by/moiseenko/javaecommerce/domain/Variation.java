package by.moiseenko.javaecommerce.domain;

/*
    @author Ilya Moiseenko on 29.01.24
*/

import jakarta.persistence.*;

@Entity
@Table(name = "tb_variation")
public class Variation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private ProductCategory category;
}
