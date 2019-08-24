package com.seba.AuctionService.entities.product.dto;

import com.seba.AuctionService.entities.product.Product;
import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private Product product;
    private CategoryDTO slectedCategoryDTO;
    private MultipartFile pictureDAO;
    private int daysDuration;

    public ProductForm() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }
}
