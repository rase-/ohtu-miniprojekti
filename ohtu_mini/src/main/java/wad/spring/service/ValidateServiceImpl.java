/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.lang.ref.Reference;
import org.springframework.validation.BindingResult;

/**
 *
 * @author mkoski
 */
public class ValidateServiceImpl implements ValidateService{
    
    @Override
    public BindingResult Validate(BindingResult result, Reference ref) {
        
        return result;
    }
    
}
