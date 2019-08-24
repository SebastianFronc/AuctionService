package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInterface extends JpaRepository<Product, Long> {

    Product findById(long id);
}
