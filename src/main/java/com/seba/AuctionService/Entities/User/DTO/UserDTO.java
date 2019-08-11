package com.seba.AuctionService.Entities.User.DTO;

import com.seba.AuctionService.Entities.User.*;

public class UserDTO {
    private long id;
    private String email;
    private String name;
    private String password;
    private Adress adress;
    private RoleUser roleUser;
    private boolean activ;
    private LogoUser logoUser;
    private TypeUser typeUser;

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }



    public LogoUser getLogoUser() {
        return logoUser;
    }

    public void setLogoUser(LogoUser logoUser) {
        this.logoUser = logoUser;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }


}
