package com.seba.AuctionService.Service;

import com.seba.AuctionService.Entities.User.DTO.UserListDTO;
import com.seba.AuctionService.Entities.User.User;
import com.seba.AuctionService.Repository.UserInterface;
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
