/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Question;

/**
 *
 * @author anttihalmetoja
 */
public interface questionDao {
    
    Question create(Question question) throws Exception;
    
    
}
