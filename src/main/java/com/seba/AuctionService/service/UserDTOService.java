package com.seba.AuctionService.service;

import com.seba.AuctionService.entities.user.dto.UserListDTO;
import com.seba.AuctionService.entities.user.User;
import com.seba.AuctionService.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserDTOService")
public class UserDTOService {

    @Autowired
    private UserInterface userInterface;


    public List<UserListDTO> findAllUserListDTO(){
        List<UserListDTO> list = new ArrayList<>();
        for (User user: userInterface.findAll()) {
            list.add(new UserListDTO(user));
        }
        return list;
    }

}
