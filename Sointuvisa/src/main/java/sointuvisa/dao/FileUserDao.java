/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername()+"\n");
            }
        } 
    }
    }
    
