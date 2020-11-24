/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

/**
 *
 * @author anttihalmetoja
 */
public class User {
    private String username;
    private int points;

    public User(String username) {
        this.username = username;
        this.points=0;
    }

    public String getUsername() {
        return username;
    }
    public int getPoints() {
        return this.points;
    }  

    public void setPoints(int points) {
        this.points = points;
    }
    public void addPointsByOne() {
        this.points+=1;
    }
    
} 
