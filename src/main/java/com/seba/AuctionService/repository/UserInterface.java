package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserInterface extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);

    public User findUserById(long id);
}
