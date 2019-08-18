package com.seba.AuctionService.Entities.Product.DTO;

import com.seba.AuctionService.Entities.Product.Category;

import java.util.Set;

public class CategoryDTO {

    private long id;
    private String name;
    private Set<Category> subCategories;
    private long parentID;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.subCategories = category.getSubCategories();
        this.parentID = category.getParentID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }
}
