/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sointuvisa.dao.QuestionDao;

/**
 *
 * @author anttihalmetoja
 */
public class FakeQuestionDao implements QuestionDao {
    ArrayList<Question> questions;
    
    public FakeQuestionDao() {
        this.questions = new ArrayList<>();
        this.questions.add(new Question(1, "test_url", "molli"));
        this.questions.add(new Question(2, "test_url2", "duuri"));
    }
    
    
     

    @Override
    public Question create(Question question) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question findQuestionById(int id) throws Exception {
        StringBuilder url = new StringBuilder();
        StringBuilder type = new StringBuilder();
        for (Question q : this.questions) {
            if (q.getId()==id) {
                url.append(q.getAudioUrl());
                type.append(q.getChordType());
            }
        }
        Question q = new Question(id, url.toString(), type.toString());
        return q;
    }

    @Override
    public ArrayList getListOfQuestions() throws Exception {
        return this.questions;
    }
}
