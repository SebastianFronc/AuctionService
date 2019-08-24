package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryInterface extends JpaRepository<Category, Long> {

     Category findById(long id);
     Category findCategoryByParentNull();

     List<Category> findCategoriesByParentNull();
     List<Category> findCategoriesBySubCategoriesEmptyOrSubCategoriesNull();

}
