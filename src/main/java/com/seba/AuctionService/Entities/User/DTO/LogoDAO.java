package com.seba.AuctionService.Entities.User.DTO;

import org.springframework.web.multipart.MultipartFile;

public class LogoDAO {
    private MultipartFile logoDAO;

    public LogoDAO() {
    }

    public MultipartFile getLogoDAO() {
        return logoDAO;
    }

    public void setLogoDAO(MultipartFile logoDAO) {
        this.logoDAO = logoDAO;
    }
}
