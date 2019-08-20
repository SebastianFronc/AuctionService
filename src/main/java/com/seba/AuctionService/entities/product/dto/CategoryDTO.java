package com.seba.AuctionService.entities.product.dto;

import com.seba.AuctionService.entities.product.Category;

public class CategoryDTO {

    private long idDTO;
    private String name;
    private long parentID;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category){
        this.idDTO = category.getId();
        this.name = category.getName();
        this.parentID = category.getParent().getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(long idDTO) {
        this.idDTO = idDTO;
    }

    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }

}
