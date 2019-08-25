package com.seba.AuctionService.repository;

import com.seba.AuctionService.entities.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionInterface extends JpaRepository<Auction, Long> {

    Auction findById(long id);

    List<Auction> findAuctionsByEndedIsFalse();

}
