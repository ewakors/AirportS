/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.ws;

/**
 *
 * @author ewa
 */
public class Reservation {
    
    private int idReservation;
    private int idFlight;
    private int user;
    
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Reservation(int idReservation,int idFlight, int user){
        this.idReservation = idReservation;
        this.idFlight = idFlight;
        this.user = user;
    }
    
    public Reservation(){}
}
