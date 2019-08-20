package com.seba.AuctionService.entities.auction;

import com.seba.AuctionService.entities.user.User;

import javax.persistence.*;

@Entity
@Table(name = "auction_watcher")
public class AuctionWatcher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @OneToOne
    @JoinColumn(name = "watcher_id")
    private User watcher;

    public AuctionWatcher() {
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

    public User getWatcher() {
        return watcher;
    }

    public void setWatcher(User watcher) {
        this.watcher = watcher;
    }
}
