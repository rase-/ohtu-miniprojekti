/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hjvirola
 */

public class Inproceedings extends Reference{
 
     @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    
}
