/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import sointuvisa.domain.Question;

/**
 *
 * Kysymysten tallentamisesta huolehtiva luokka.
 * @author anttihalmetoja
 */
public class FileQuestionDao implements QuestionDao {

    public ArrayList<Question> questions;
    private String file;
    private ArrayList<String> audioUrls;

    public FileQuestionDao(String file) throws Exception {
        this.questions = new ArrayList<>();
        this.file = file;
        this.audioUrls = new ArrayList<>();

        try {
            this.audioUrls.add("/kolmisoinnut-major-1.aif");
            this.audioUrls.add("/kolmisoinnut-major-2.aif");
            this.audioUrls.add("/kolmisoinnut-major-3.aif");
            this.audioUrls.add("/kolmisoinnut-major-4.aif");
            this.audioUrls.add("/kolmisoinnut-minor-1.aif");
            this.audioUrls.add("/kolmisoinnut-minor-2.aif");
            this.audioUrls.add("/kolmisoinnut-minor-3.aif");
            this.audioUrls.add("/kolmisoinnut-diminished-1.aif");
            this.audioUrls.add("/kolmisoinnut-diminished-2.aif");
            this.audioUrls.add("/kolmisoinnut-diminished-3.aif");
            this.audioUrls.add("/kolmisoinnut-augmented-1.aif");
            this.audioUrls.add("/kolmisoinnut-augmented-2.aif");
            this.audioUrls.add("/kolmisoinnut-augmented-3.aif");

            Random r = new Random();

            for (int i = 1; i < 14; i++) {
                String audioUrl = this.audioUrls.get(r.nextInt(12));
                String type = "";
                if (audioUrl.contains("minor")) {
                    type = "molli";
                } else if (audioUrl.contains("major")) {
                    type = "duuri";
                } else if (audioUrl.contains("augmented")) {
                    type = "ylinouseva";
                } else if (audioUrl.contains("diminished")) {
                    type = "vähennetty";
                }

                Question question = new Question(i, audioUrl, type);
                questions.add(question);
                save();
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    /**
     * Metodi tallentaa listan vastausket tiedostoon
     *     
     * 
     */
    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Question question : questions) {
                writer.write(question.getId() + ";" + question.getAudioUrl() + ";" + question.getChordType() + "\n");

            }
        }
    }

    @Override
    public Question findQuestionById(int id) throws FileNotFoundException {

        Scanner reader = new Scanner(new File(file));
        StringBuilder url = new StringBuilder();
        StringBuilder type = new StringBuilder();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] palat = line.split(";");
            if (palat[0].equals(Integer.toString(id))) {
                url.append(palat[1]);
                type.append(palat[2]);
                break;
            }
        }
        Question question = new Question(id, url.toString(), type.toString());
        return question;
    }

    @Override
    public Question create(Question question) throws Exception {
        questions.add(question);
        save();

        return question;
    }
    /**
     * Metodi palauttaa kolmen kärki -listan
     *
     @return topthree-lista
     * 
     */
    @Override
    public ArrayList<Question> getListOfQuestions() {
        return this.questions;
    }

}
