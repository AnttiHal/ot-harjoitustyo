/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import java.io.File;
import java.io.FileWriter;
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
    userDao dao;  
    public FileUserDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        userDao userDao = new FakeUserDao();
        userDao.create(new User("mattimeikalainen"));
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("mattimeikalainen\n");
        }
        
        dao = new FileUserDao(userFile.getAbsolutePath());        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
}
