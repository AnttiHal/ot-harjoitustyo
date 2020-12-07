/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import sointuvisa.dao.UserDao;

public class FakeUserDao implements UserDao {
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
        for (User u : users) {
            System.out.println(u.getUsername() + u.getPoints());
            if (u.getUsername().equals(user.getUsername())) {
                u.addPointsByOne();
            }
        }
        
        return user;
    }

    @Override
    public ArrayList<User> getTopThree() throws Exception {
        ArrayList<User> thebest = new ArrayList<>();
        Collections.sort(users, Comparator.comparing(User::getPoints));
        Collections.reverse(users);
        for (User u : users) {
            System.out.println(u.getUsername() + u.getPoints());
        }
        if (users.size() == 1) {
            thebest.add(users.get(0));

        } else if (users.size() == 2) {
            thebest.add(users.get(0));
            thebest.add(users.get(1));
        } else {
            thebest.add(users.get(0));
            thebest.add(users.get(1));
            thebest.add(users.get(2));
        }

        return thebest;
    }

    @Override
    public int getUserPoints(User user) throws Exception {
        int points = 0;
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                points = u.getPoints();
            }
        }
        
        return points;
    }

    @Override
    public void savePoints() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}