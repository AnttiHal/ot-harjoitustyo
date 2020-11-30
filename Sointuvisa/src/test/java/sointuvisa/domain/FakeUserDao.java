/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sointuvisa.dao.userDao;

public class FakeUserDao implements userDao {
    String file;
    List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("mattimeikalainen"));
    }
    
    
    
    @Override
    public User create(User user) {
        users.add(user);
        return user;
    } 
    
    

    @Override
    public User findUserByName(String username) throws FileNotFoundException {

        return users.stream()
            .filter(u->u.getUsername()
            .equals(username))
            .findFirst()
            .orElse(null);
    
    }

    @Override
    public User updatePoints(User user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getTopThree() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}