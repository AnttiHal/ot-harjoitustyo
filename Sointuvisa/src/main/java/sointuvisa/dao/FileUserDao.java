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
import java.util.List;
import java.util.Scanner;
import sointuvisa.domain.Question;
import sointuvisa.domain.User;

/**
 *
 * @author anttihalmetoja
 */
public class FileUserDao implements userDao{

    private ArrayList<User> users;
    private String file;

    public FileUserDao(String file) throws IOException {
        this.users = new ArrayList<>();
        this.file = file;
        
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                User u = new User(name);
                users.add(u);
            }
            
        } catch (Exception e){
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    /*
    public User findUserByUsername(String user) {
        
        for ()
        
        return ;
    }
    */
    
    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }
    @Override
    public User findUserByName(String username) throws FileNotFoundException {
        /*
        Scanner reader = new Scanner(new File(file));
        StringBuilder name = new StringBuilder();
        int points = 0;
        
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] palat = line.split(";");            
            if (palat[0].equals(username)) {
                name.append(palat[0]);
                points=Integer.valueOf(palat[1]);
                break;
            }
        }
        User user = new User(name.toString());    
        user.setPoints(points);
        */
        return users.stream()
            .filter(u->u.getUsername()
            .equals(username))
            .findFirst()
            .orElse(null);
    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername()+";"+user.getPoints()+"\n");
            }
        } 
    }
    }
    

