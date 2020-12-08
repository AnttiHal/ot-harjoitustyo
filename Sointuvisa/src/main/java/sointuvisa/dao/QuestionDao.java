/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.util.ArrayList;
import sointuvisa.domain.Question;

/**
 *
 * @author anttihalmetoja
 *
 */
public interface QuestionDao {

    Question create(Question question) throws Exception;

    Question findQuestionById(int id) throws Exception;

    ArrayList getListOfQuestions() throws Exception;

}
