/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sointuvisa.dao;

import sointuvisa.domain.User;

/**
 *
 * @author anttihalmetoja
 */
public interface userDao {
    
    User create(User user) throws Exception;
    
    User findUserByName(String username) throws Exception;
    
    
}
