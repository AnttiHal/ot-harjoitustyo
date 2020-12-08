/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import sointuvisa.domain.Question;
import sointuvisa.domain.User;

/**
 *
 * @author anttihalmetoja
 */
public class FileUserDao implements UserDao {

    private ArrayList<User> users;
    private String file;

    public FileUserDao(String file) throws IOException {
        this.users = new ArrayList<>();
        this.file = file;

        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0]);
                users.add(u);
                u.setPoints(Integer.valueOf(parts[1]));
            }

        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }

    public ArrayList<User> getTopThree() {
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
    public User findUserByName(String username) throws FileNotFoundException {

        return users.stream()
                .filter(u -> u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);
    }

    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getPoints() + "\n");
            }
        }
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
    public User updatePoints(User user) throws Exception {
        for (User u : users) {

            if (u.getUsername().equals(user.getUsername())) {
                u.addPointsByOne();
                System.out.println(u.getUsername() + u.getPoints());
                System.out.println("käyttäjän pisteet: " + u.getPoints());
            }
        }

        return user;
    }

    @Override
    public void savePoints() throws Exception {
        save();
    }

    @Override
    public void setPointsToZero(User user) throws Exception {
        for (User u : users) {

            if (u.getUsername().equals(user.getUsername())) {
                u.setPoints(0);
                System.out.println("käyttäjän pisteet: " + u.getPoints());
            }
        }
    }

}
