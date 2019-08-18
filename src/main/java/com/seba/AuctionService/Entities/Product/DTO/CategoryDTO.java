package com.seba.AuctionService.Entities.Product.DTO;

import com.seba.AuctionService.Entities.Product.Category;

import java.util.Set;

public class CategoryDTO {

    private long id;
    private String name;
    private Category parentCategory;
    private Set<Category> subCategories;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.parentCategory = category.getParentCategory();
        this.subCategories = category.getSubCategories();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
