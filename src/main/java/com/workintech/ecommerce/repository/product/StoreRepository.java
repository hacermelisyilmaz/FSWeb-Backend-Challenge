package com.workintech.ecommerce.repository.product;

import com.workintech.ecommerce.entity.product.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
