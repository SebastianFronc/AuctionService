package com.seba.AuctionService.entities.product.dto;

import com.seba.AuctionService.entities.product.Category;
import org.springframework.lang.Nullable;

public class CategoryDTO {

    private long idDTO;
    private String name;
    private Long parentID;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category){
        this.idDTO = category.getId();
        this.name = category.getName();
        if (!(category.getParent() == null)) {
            this.parentID = category.getParent().getId();
        }
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

    public void setIdDTO(Long idDTO) {
        this.idDTO = idDTO;
    }

    public long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

}
