package com.seba.AuctionService.entities.auction;

import com.seba.AuctionService.entities.user.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "actual_price")
    private BigDecimal actualPrice;

    @ManyToOne
    @JoinColumn(name = "actual_winner_id")
    private User actualWinner;

    public Auction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public User getActualWinner() {
        return actualWinner;
    }

    public void setActualWinner(User actualWinner) {
        this.actualWinner = actualWinner;
    }
}
