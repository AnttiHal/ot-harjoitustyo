/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anttihalmetoja
 */
public class UserTest {
    
    
    
   @Test
    public void returnsCorrectUsername() {
        User u1 = new User("testimies");
        
        
        assertEquals(u1.getUsername(),"testimies");
    }
}
