package com.shopping.hansfullstack.shopping.repositories;

import com.shopping.hansfullstack.shopping.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByClothesId (Long id);

}
