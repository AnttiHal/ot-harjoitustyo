/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author anttihalmetoja
 */
public class Question {
    private int id;
    private String question;
    private String audio_url;
    private String type;

    public Question(int id, String audio_url, String type) {
        this.id = id;
        this.question = "Mikä sointu?";
        this.audio_url = audio_url;
        this.type = type;
    }
    
}
