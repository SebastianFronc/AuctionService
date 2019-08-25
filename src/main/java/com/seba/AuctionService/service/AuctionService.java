package com.seba.AuctionService.service;

import com.seba.AuctionService.entities.auction.Auction;
import com.seba.AuctionService.entities.product.Product;
import com.seba.AuctionService.repository.AuctionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AuctionService")
public class AuctionService {

    @Autowired
    private AuctionInterface auctionInterface;


    public void save (Product product){
        Auction auction = new Auction();
        auction.setActualPrice(product.getMinimalPrice());
        auction.setEnded(false);
        auction.setProduct(product);
        auctionInterface.save(auction);
    }

    public List<Auction> findAll(){
        return auctionInterface.findAll();
    }

    public List<Auction> findActivAuction(){
        return auctionInterface.findAuctionsByEndedIsFalse();
    }






}
