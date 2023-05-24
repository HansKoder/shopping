package com.shopping.hansfullstack.shopping.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "details_purchase")
public class DetailPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @JoinColumn(name = "count_items")
    private Integer countItems;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    private Double total;

}
