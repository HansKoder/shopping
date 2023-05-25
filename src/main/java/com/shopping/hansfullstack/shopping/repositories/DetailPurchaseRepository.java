package com.shopping.hansfullstack.shopping.repositories;

import com.shopping.hansfullstack.shopping.entities.DetailPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailPurchaseRepository extends JpaRepository<DetailPurchase, Long> {
}
