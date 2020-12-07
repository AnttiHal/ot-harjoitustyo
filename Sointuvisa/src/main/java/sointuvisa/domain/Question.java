/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

/**
 *
 * sointuvisan yksittäistä kysymystä kuvaava luokka
 */
public class Question {

    private int id;
    private String question;
    private String audioUrl;
    private String chordType;

    public Question(int id, String audioUrl, String chordType) {
        this.id = id;
        this.question = "Mikä sointu?";
        this.audioUrl = audioUrl;
        this.chordType = chordType;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public int getId() {
        return this.id;
    }

    public String getChordType() {
        return this.chordType;
    }

}
