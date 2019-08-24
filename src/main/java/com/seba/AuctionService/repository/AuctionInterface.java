package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionInterface extends JpaRepository<Auction, Long> {
    
}
