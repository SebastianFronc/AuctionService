package com.seba.AuctionService.entities.dao;

import org.springframework.web.multipart.MultipartFile;

public class PictureDAO {
    private MultipartFile pictureDAO;

    public PictureDAO() {
    }

    public MultipartFile getPictureDAO() {
        return pictureDAO;
    }

    public void setPictureDAO(MultipartFile pictureDAO) {
        this.pictureDAO = pictureDAO;
    }
}
