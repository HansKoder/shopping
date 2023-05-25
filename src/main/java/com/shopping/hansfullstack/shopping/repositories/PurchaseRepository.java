package com.shopping.hansfullstack.shopping.repositories;

import com.shopping.hansfullstack.shopping.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
