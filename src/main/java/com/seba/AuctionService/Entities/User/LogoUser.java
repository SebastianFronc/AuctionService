package com.seba.AuctionService.Entities.User;

import javax.persistence.*;

@Entity
@Table(name = "user_logo")
public class LogoUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Lob
    @Column(name = "logo")
    private  byte[] logo;

    public LogoUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
