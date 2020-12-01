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
    UserDao dao;  
    public FileUserDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("mattimeikalainen"));
        userDao.create(new User("joukahainen"));
        userDao.create(new User("väinämöinen"));
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("mattimeikalainen;0\n");
            file.write("joukahainen;0\n");
            file.write("väinämöinen;0\n");
        }
        
        dao = new FileUserDao(userFile.getAbsolutePath());        
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
        user.addPointsByOne();
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
    public void createCreatesNewUser() throws Exception {
        dao.create(new User("seppo"));
        assertEquals("seppo", dao.findUserByName("seppo").getUsername());
        
    }
}
