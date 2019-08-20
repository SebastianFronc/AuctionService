package com.seba.AuctionService.service;

import com.seba.AuctionService.entities.product.Category;
import com.seba.AuctionService.entities.product.dto.CategoryDTO;

import com.seba.AuctionService.repository.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("CategoryService")
public class CategoryService {

    @Autowired
    private CategoryInterface categoryInterface;

    public List<Category> findAllCategory(){
        return categoryInterface.findAll();
    }

    public void save(Category category){
        categoryInterface.save(category);
    }

    public List<CategoryDTO> findAllCategoryDTO(){
        List<CategoryDTO> list = new ArrayList<>();
        for (Category category: categoryInterface.findAll()) {
            list.add(new CategoryDTO(category));
        }
        return list;
    }

    public Category findByID(long id){
        return categoryInterface.findById(id);
    }



}