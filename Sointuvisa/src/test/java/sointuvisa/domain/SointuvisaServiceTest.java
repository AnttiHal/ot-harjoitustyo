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

/**
 *
 * @author anttihalmetoja
 */
public class SointuvisaServiceTest {

    FakeUserDao userdao;
    FakeQuestionDao questiondao;
    SointuvisaService svs;
    User u1;
    User u2;
    ArrayList<String> answers;

    @Before
    public void setUp() {
        userdao = new FakeUserDao();
        questiondao = new FakeQuestionDao();
        u1 = new User("antti");
        u2 = new User("pantti");
        userdao.create(u1);
        userdao.create(u2);
        svs = new SointuvisaService(questiondao, userdao);
        answers = new ArrayList<>();

    }

    @Test
    public void updateUserPointsAddsPointsToUser() throws Exception {
        svs.updateUserPoints(u1);
        assertEquals(1, u1.getPoints());
    }

    @Test
    public void createUserCreatesUserAndReturnsTrue() throws Exception {

        svs.createUser("kalle");
        User u3 = svs.getUserByUsername("kalle");
        assertTrue(svs.createUser("kalle"));
        assertEquals("kalle", u3.getUsername());
    }

    @Test
    public void getUserByNameReturnsRightUser() throws Exception {
        User u3 = svs.getUserByUsername("antti");
        assertEquals(u1, u3);
        assertEquals(u1.getUsername(), u3.getUsername());
    }

    @Test
    public void getUserPointsReturnsRightAmountOfPoints() throws Exception {
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        assertEquals(3, svs.getUserPoints(u1));
    }

    @Test
    public void getTopThreeReturnsCorrectList() throws Exception {
        User u3 = svs.getUserByUsername("mattimeikalainen");
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u2);
        userdao.updatePoints(u2);
        userdao.updatePoints(u3);
        ArrayList<User> list = svs.getTopThree();
        assertEquals(3, list.get(0).getPoints());
        assertEquals(2, list.get(1).getPoints());
    }

    @Test
    public void getQuestionByIdReturnsRightQuestion() throws Exception {
        User u3 = svs.getUserByUsername("mattimeikalainen");
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u2);
        userdao.updatePoints(u2);
        userdao.updatePoints(u3);
        ArrayList<User> list = svs.getTopThree();
        assertEquals(3, list.get(0).getPoints());
        assertEquals(2, list.get(1).getPoints());
    }

    @Test
    public void addAnswerAddsChordTypetoLIst() throws Exception {
        svs.addAnswer("molli");
        svs.addAnswer("duuri");
        svs.addAnswer("ylinouseva");
        assertEquals(svs.getAnswerByNumber(0), "molli");
        assertEquals(svs.getAnswerByNumber(2), "ylinouseva");
    }

    @Test
    public void clearAnswersClearsList() throws Exception {
        svs.addAnswer("molli");
        svs.addAnswer("duuri");
        svs.addAnswer("molli");
        svs.clearAnswerList();
        assertEquals(0, this.answers.size());
    }

    @Test
    public void getQuestionByIdReturnsCorrectQuestion() throws Exception {
        Question q = svs.getQuestionById(1);
        Question q2 = svs.getQuestionById(2);

        assertEquals(q.getChordType(), "molli");
        assertEquals(q.getAudioUrl(), "test_url");
        assertEquals(q2.getChordType(), "duuri");
    }

    @Test
    public void setPointsToZeroDoesIt() throws Exception {
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        userdao.updatePoints(u1);
        svs.resetPoints(u1);
        assertEquals(u1.getPoints(), 0);
    }
    
    @Test
    public void getQuestionListReturnsList() throws Exception {
        ArrayList<Question> list = svs.getQuestionList();
        assertEquals(list.get(0).getChordType(), "molli");
    }

}
