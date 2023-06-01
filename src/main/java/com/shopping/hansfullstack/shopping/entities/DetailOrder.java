package com.shopping.hansfullstack.shopping.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "details_order")
public class DetailOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    @JoinColumn(name = "count_items")
    private Integer countItems;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    private Double total;

    private Boolean check;

    private String comment;

}
