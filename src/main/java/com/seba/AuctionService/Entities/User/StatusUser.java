package com.seba.AuctionService.Entities.User;

public enum StatusUser {
    ACTIV(true),
    INACTIV(false),
    BANNDED(false);


    private boolean activ;

     StatusUser(Boolean activ){
         this.activ = activ;
     }
}
