package com.shopping.hansfullstack.shopping.repositories;

import com.shopping.hansfullstack.shopping.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
