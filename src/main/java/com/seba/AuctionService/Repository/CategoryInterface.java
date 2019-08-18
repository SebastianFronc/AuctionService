package com.seba.AuctionService.Repository;

import com.seba.AuctionService.Entities.Product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInterface extends JpaRepository<Category, Long> {

     Category findById(long id);

}
