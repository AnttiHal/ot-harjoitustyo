
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

import java.util.ArrayList;
import sointuvisa.dao.QuestionDao;
import sointuvisa.dao.UserDao;
import sointuvisa.dao.UserDao;

/**
 *
 * @author anttihalmetoja Sovelluslogiikasta vastaava luokka
 */
public class SointuvisaService {

    private QuestionDao questionDao;
    private UserDao userDao;
    private User user;

    public SointuvisaService(QuestionDao questionDao, UserDao userDao) {
        this.questionDao = questionDao;
        this.userDao = userDao;
        
    }

    /**
     * kirjautuneena oleva käyttäjä
     *
     * @return kirjautuneena oleva käyttäjä
     */
    

    public Boolean createUser(String username) {

        User u = new User(username);
        user = u;
        try {
            userDao.create(u);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Question getQuestionById(int id) throws Exception {
        Question q = questionDao.findQuestionById(id);
        return q;
    }

    public User getUserByUsername(String name) throws Exception {
        User u = userDao.findUserByName(name);
        return u;
    }

    public User updateUserPoints(User user) throws Exception {
        userDao.updatePoints(user);
        return user;
    }

    public int getUserPoints(User user) throws Exception {
        int points = userDao.getUserPoints(user);
        return points;
    }

    public ArrayList<User> getTopThree() throws Exception {
        ArrayList<User> best = userDao.getTopThree();
        return best;
    }

}
