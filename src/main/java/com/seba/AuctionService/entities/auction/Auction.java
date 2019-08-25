package com.seba.AuctionService.entities.auction;

import com.seba.AuctionService.entities.product.Product;
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

    @Column(name = "ended")
    private boolean ended;

    @ManyToOne
    @JoinColumn(name = "actual_winner_id")
    private User actualWinner;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

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

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
