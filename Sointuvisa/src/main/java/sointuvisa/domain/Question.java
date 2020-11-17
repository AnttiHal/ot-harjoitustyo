/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

/**
 *
 * @author anttihalmetoja
 * sointuvisan yksittäistä kysymystä kuvaava luokka
 */
public class Question {
    private int id;
    private String question;
    private String audio_url;
    private String chordType;

    public Question(int id, String audio_url, String chordType) {
        this.id = id;
        this.question = "Mikä sointu?";
        this.audio_url = audio_url;
        this.chordType = chordType;
    }

    public String getAudio_url() {
        return audio_url;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getChordType() {
        return this.chordType;
    }
    
}
