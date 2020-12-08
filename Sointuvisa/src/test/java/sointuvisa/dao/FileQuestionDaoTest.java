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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import sointuvisa.domain.FakeUserDao;
import sointuvisa.domain.Question;
import sointuvisa.domain.User;

/**
 *
 * @author anttihalmetoja
 */
public class FileQuestionDaoTest {   
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();    
  
    File userFile;  
    QuestionDao dao;    
        
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_question.txt");  
        UserDao userDao = new FakeUserDao();
        
        userDao.create(new User("mattimeikalainen"));
        userDao.create(new User("joukahainen"));
        userDao.create(new User("väinämöinen"));
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("1;testi_url;molli\n");
            file.write("2;testi_url2;duuri\n");
            file.write("3;testi_url3;ylinouseva\n");
        }
        
        dao = new FileQuestionDao(userFile.getAbsolutePath());        
    }
   
    @Test
    public void getQuestionByIdReturnsQuestionWithCorrectId() throws Exception {
        
        Question q = dao.findQuestionById(1);
        assertEquals(q.getId(),1);
        
    }
    @Test
    public void getListReturnsListofQuestions() throws Exception {
        
        ArrayList<Question> questions = dao.getListOfQuestions();
        
        assertEquals(13, questions.size());
        
    }
}
