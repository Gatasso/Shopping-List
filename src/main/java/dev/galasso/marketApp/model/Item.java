package dev.galasso.marketApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_list_item")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "shop_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "tb_product_id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tb_list_id_list")
    @JsonIgnoreProperties("itens")
    private ShopList list;
}
