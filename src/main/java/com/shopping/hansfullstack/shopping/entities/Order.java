package com.shopping.hansfullstack.shopping.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_order")
    private Date dateOrder;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private String comments;

}
