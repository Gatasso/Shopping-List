package dev.galasso.marketApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Double totalPrice;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("list")
    private List<Item> itens;

}
