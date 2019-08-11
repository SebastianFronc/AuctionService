package com.seba.AuctionService.Service;

import com.seba.AuctionService.Entities.User.RoleUser;
import com.seba.AuctionService.Entities.User.User;
import com.seba.AuctionService.Repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserInterface userInterface;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService(UserInterface userInterface,
                        BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userInterface = userInterface;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userInterface.save(user);
    }

    public void switchActiv(long id){
        User user = userInterface.findUserById(id);
        user.setActiv(!user.isActiv());
        userInterface.save(user);
    }

    public void switchRole(long id){
        User user = userInterface.findUserById(id);
        if (user.getRoleUser().equals(RoleUser.USER)) {
            user.setRoleUser(RoleUser.ADMIN);
        } else {
            user.setRoleUser(RoleUser.USER);
        }
        userInterface.save(user);
    }

    public User findUserByEmail(String email){
        return userInterface.findUserByEmail(email);
    }

    public User findUserByID(long id){
        return userInterface.findUserById(id);
    }





}
