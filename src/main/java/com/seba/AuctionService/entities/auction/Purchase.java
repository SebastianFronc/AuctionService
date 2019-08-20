package com.seba.AuctionService.entities.auction;

import com.seba.AuctionService.entities.user.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "winner_id")
    private User winner;

    public Purchase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }
}
