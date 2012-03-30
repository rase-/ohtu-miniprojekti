/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.service.ReferenceService;

/**
 *
 * @author tonykova
 */

@Controller
public class ReferenceController {
    @Autowired
    ReferenceService referenceService;
    
    @RequestMapping("*/**")
    public String homeSite() {
        return "home";
    }
    @RequestMapping("*")
    public String alsoHome() {
        return "home";
    }
}
