package sointuvisa.domain;

import java.util.ArrayList;
import sointuvisa.dao.QuestionDao;
import sointuvisa.dao.UserDao;
import sointuvisa.dao.UserDao;

/**
 *
 * Sovelluslogiikasta vastaava luokka
 */
public class SointuvisaService {

    private QuestionDao questionDao;
    private UserDao userDao;
    private User user;
    private ArrayList<String> answers;

    public SointuvisaService(QuestionDao questionDao, UserDao userDao) {
        this.questionDao = questionDao;
        this.userDao = userDao;
        this.answers=new ArrayList<>();
        
    }

    /**
     * nimensä antanut käyttäjä
     *
     * @return nimensä antanut käyttäjä
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
    public void addAnswer(String s) {
        answers.add(s);
    }
    public String getAnswerByNumber(int n) {
        return this.answers.get(n);
    }
    public void clearAnswerList() {
        this.answers.clear();
    }
    public void savePoints() throws Exception {
        userDao.savePoints();
    }
/**
     * Päivitä käyttäjän pisteitä
     *
     * @param   user    käyttäjä, jonka pisteitä halutaan muuttaa
     * 
     * @return käyttäjä, jonka pisteitä halutaan muuttaa
     */
    public User updateUserPoints(User user) throws Exception {
        userDao.updatePoints(user);
        return user;
    }

    public int getUserPoints(User user) throws Exception {
        int points = userDao.getUserPoints(user);
        return points;
    }
/**
     * kolmen kärki
     *
     * @return kolme eniten oikeita vastauksia kerännyttä pelaajaa
     */
    public ArrayList<User> getTopThree() throws Exception {
        ArrayList<User> best = userDao.getTopThree();
        return best;
    }
    
    public ArrayList<Question> getQuestionList() throws Exception {
        return questionDao.getListOfQuestions();
    }
    
    public void resetPoints(User u) throws Exception {
        userDao.setPointsToZero(u);
    }

}
