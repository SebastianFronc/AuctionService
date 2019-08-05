package com.seba.AuctionService.Entities.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusUser statusUser;

    @OneToOne
    @JoinColumn(name = "logo_id")
    private LogoUser logoUser;

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    public User() {
        this.adress = new Adress();
        this.logoUser = new LogoUser();
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

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(StatusUser statusUser) {
        this.statusUser = statusUser;
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
