package com.seba.AuctionService.Entities.User.DTO;

import com.seba.AuctionService.Entities.User.*;

public class UserListDTO {
    private long id;
    private String email;
    private String name;
    private Adress adress;
    private RoleUser roleUser;
    private boolean activ;
    private TypeUser typeUser;

    public UserListDTO() {
    }

    public UserListDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.adress = user.getAdress();
        this.roleUser = user.getRoleUser();
        this.activ = user.isActiv();
        this.typeUser = user.getTypeUser();


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

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }
}
