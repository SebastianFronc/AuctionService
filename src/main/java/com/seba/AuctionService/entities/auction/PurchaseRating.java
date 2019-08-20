package com.seba.AuctionService.entities.auction;

import javax.persistence.*;

@Entity
@Table(name = "purchase_rating")
public class PurchaseRating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "buyer_rating")
    private int buyerRating;

    @Column(name = "seller_rating")
    private int sellerRating;

    @Column(name = "buyer_comment")
    private String buyerComment;

    @Column(name = "seller_comment")
    private String sellerComment;

    public PurchaseRating() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public int getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(int buyerRating) {
        this.buyerRating = buyerRating;
    }

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public String getSellerComment() {
        return sellerComment;
    }

    public void setSellerComment(String sellerComment) {
        this.sellerComment = sellerComment;
    }
}
