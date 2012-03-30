package wad.spring.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.domain.SampleObject;
import wad.spring.service.ObjectFactory;
import wad.spring.service.SecureService;

@Controller
public class HomeController {

    @Autowired
    SecureService secureService;
    @Autowired
    ObjectFactory postFilterExample;

    @RequestMapping(value = "/home")
    public String home() {
        secureService.executeFreely();
        return "home";
    }

    @RequestMapping(value = "/must-be-authenticated")
    public String mustAuth() {
        secureService.executeOnlyIfAuthenticated();
        return "home";
    }

    @RequestMapping(value = "/must-be-admin")
    public String mustAdmin() {
        secureService.executeOnlyIfAuthenticatedAsLecturer();
        return "home";
    }

    @RequestMapping(value = "/are-they-awesome")
    public String areTheyAwesome(Principal principal) {
        if (principal == null) {
            System.out.println("Not logged in!");
        } else {
            System.out.println("Logged in username, if any: " + principal.getName());
        }

        for (SampleObject obj : postFilterExample.getObjects()) {
            System.out.println("" + obj.isAwesome());
        }

        return "home";
    }
}
