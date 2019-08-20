package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInterface extends JpaRepository<Category, Long> {

     Category findById(long id);
     Category findCategoryByParentNull();

}
