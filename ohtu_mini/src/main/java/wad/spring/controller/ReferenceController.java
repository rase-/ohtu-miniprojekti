
package wad.spring.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Reference;
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
    public String homeSite(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        return "home";
    }
    @RequestMapping("*")
    public String alsoHome(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        return "home";
    }
    @RequestMapping(value = "reference", method = RequestMethod.POST)
    public String addReference(@Valid @ModelAttribute Reference reference, BindingResult result) {
        if (result.hasErrors()) {
            return "reference";
        }
        referenceService.addReference(reference);
        return "redirect:/home";
    }
    @RequestMapping(value = "reference", method = RequestMethod.GET)
    public String showReferenceForm(Model model) {
        model.addAttribute("reference", new Reference());
        return "reference";
    }
    
    @RequestMapping(value="deleteReference/{id}")
    public String deleteReference(@PathVariable Long id){
       referenceService.deleteReference(id);
       return "redirect:/home";
    }
    
    @RequestMapping(value = "reference/all", method = RequestMethod.GET)
    public String showReferences(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        return "listAll";
    }    
   
}
