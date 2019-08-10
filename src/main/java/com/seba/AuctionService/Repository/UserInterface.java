package com.seba.AuctionService.Repository;

import com.seba.AuctionService.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserInterface extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);
}
