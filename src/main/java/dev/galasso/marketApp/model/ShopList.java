package dev.galasso.marketApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_list")
@Getter
@Setter
public class ShopList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list")
    private Integer id;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "shop_name", length = 50)
    private String shopName;

    @Column(name = "total")
    private BigDecimal totalPrice;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<Item> itens;

}
