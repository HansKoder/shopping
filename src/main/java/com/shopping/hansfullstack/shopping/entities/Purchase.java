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
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_purchase")
    private Date datePurchase;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private Double total;

    private String comments;

}
