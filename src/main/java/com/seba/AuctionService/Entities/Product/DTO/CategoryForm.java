package com.seba.AuctionService.Entities.Product.DTO;

import com.seba.AuctionService.Entities.Product.Category;
import org.springframework.web.multipart.MultipartFile;


public class CategoryForm {
    private Category category;
    private CategoryDTO slectedCategoryDTO;
    private MultipartFile pictureDAO;
    public CategoryForm() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryDTO getSlectedCategoryDTO() {
        return slectedCategoryDTO;
    }

    public void setSlectedCategoryDTO(CategoryDTO slectedCategoryDTO) {
        this.slectedCategoryDTO = slectedCategoryDTO;
    }

    public MultipartFile getPictureDAO() {
        return pictureDAO;
    }

    public void setPictureDAO(MultipartFile pictureDAO) {
        this.pictureDAO = pictureDAO;
    }
}
