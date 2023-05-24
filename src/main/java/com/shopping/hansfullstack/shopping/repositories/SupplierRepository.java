package com.shopping.hansfullstack.shopping.repositories;

import com.shopping.hansfullstack.shopping.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
