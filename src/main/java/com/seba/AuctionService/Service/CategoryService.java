package com.seba.AuctionService.Service;

import com.seba.AuctionService.Entities.Product.Category;
import com.seba.AuctionService.Entities.Product.DTO.CategoryDTO;

import com.seba.AuctionService.Repository.CategoryInterface;
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

    public Category getMainCategory(){
        return categoryInterface.findCategoryByParentCategoryNull();
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
