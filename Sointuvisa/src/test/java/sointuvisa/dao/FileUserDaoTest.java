/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import sointuvisa.domain.FakeUserDao;
import sointuvisa.domain.User;


/**
 *
 * @author anttihalmetoja
 */
public class FileUserDaoTest {
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();    
  
    File userFile;  
    File userFile2;  
    UserDao dao; 
    UserDao dao2; 
    public FileUserDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        userFile2 = testFolder.newFile("testfile_users1.txt");  
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("mattimeikalainen"));
        userDao.create(new User("joukahainen"));
        userDao.create(new User("väinämöinen"));
        
        UserDao userDao2 = new FakeUserDao();
        userDao2.create(new User("mattimeikalainen"));
        userDao2.create(new User("joukahainen"));
        
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("mattimeikalainen;0\n");
            file.write("joukahainen;0\n");
            file.write("väinämöinen;0\n");
        }
        try (FileWriter file = new FileWriter(userFile2.getAbsolutePath())) {
            file.write("mattimeikalainen;0\n");
            file.write("joukahainen;0\n");            
        }
        
        dao = new FileUserDao(userFile.getAbsolutePath());  
        dao2 = new FileUserDao(userFile2.getAbsolutePath());  
    }
    
    @Test
    public void existingUserIsFound() throws Exception {
        User user = dao.findUserByName("mattimeikalainen");
        assertEquals("mattimeikalainen", user.getUsername());
        assertEquals(0, user.getPoints());
    }
    @Test
    public void AddingPointsToUserSuccessful() throws Exception {
        User user = dao.findUserByName("mattimeikalainen");
        dao.updatePoints(user);
        
        assertEquals("mattimeikalainen", user.getUsername());
        assertEquals(1, user.getPoints());
    }
    @Test
    public void SettingPointsToUserSuccessful() throws Exception {
        User user = dao.findUserByName("mattimeikalainen");
        user.setPoints(5);
        assertEquals("mattimeikalainen", user.getUsername());
        assertEquals(5, user.getPoints());
    }
    
    @Test
    public void getTopThreeReturnsCorrectList() throws Exception {
        User u1 = dao.findUserByName("mattimeikalainen");
        User u2 = dao.findUserByName("joukahainen");
        User u3 = dao.findUserByName("väinämöinen");
        u1.addPointsByOne();
        u1.addPointsByOne();
        u2.addPointsByOne();
        ArrayList<User> list = dao.getTopThree();
        assertEquals("mattimeikalainen", list.get(0).getUsername());
        assertEquals("joukahainen", list.get(1).getUsername());
        
    }
    
    @Test
    public void getTopThreeReturnsCorrectListWhenListSizeTwo() throws Exception {
        User u1 = dao2.findUserByName("mattimeikalainen");
        User u2 = dao2.findUserByName("joukahainen");       
        u1.addPointsByOne();
        u1.addPointsByOne();
        u2.addPointsByOne();
        ArrayList<User> list = dao2.getTopThree();
        assertEquals("mattimeikalainen", list.get(0).getUsername());
        assertEquals("joukahainen", list.get(1).getUsername());
        
    }
    
    @Test
    public void createCreatesNewUser() throws Exception {
        dao.create(new User("seppo"));
        assertEquals("seppo", dao.findUserByName("seppo").getUsername());
        
    }
    @Test
    public void getUserPointsReturnscorrectPoints() throws Exception {
        User u1 = dao.findUserByName("mattimeikalainen");
        User u2 = dao.findUserByName("joukahainen");
        User u3 = dao.findUserByName("väinämöinen");
        u1.addPointsByOne();
        u1.addPointsByOne();
        u2.addPointsByOne();
        
        assertEquals(dao.getUserPoints(u1), 2);
        
    }
    @Test
    public void setPointsToZeroDoesWhatItPromises() throws Exception {
        User u1 = dao.findUserByName("mattimeikalainen");
        
        u1.addPointsByOne();
        u1.addPointsByOne();
        dao.setPointsToZero(u1);
        
        assertEquals(dao.getUserPoints(u1), 0);
        
    }
    
}
