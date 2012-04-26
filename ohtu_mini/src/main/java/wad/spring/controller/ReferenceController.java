package wad.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import wad.spring.domain.Reference;
import wad.spring.domain.ReferenceType;
import wad.spring.form.FileForm;
import wad.spring.form.TagForm;
import wad.spring.service.BibtexService;
import wad.spring.service.ReferenceService;
import wad.spring.service.ValidateService;

/**
 *
 * @author tonykova
 */
@Controller
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;
    @Autowired
    BibtexService bibtexService;
    @Autowired
    ValidateService validateService;

    @RequestMapping("*/**")
    public String homeSite(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        model.addAttribute("findByTag", new TagForm());
        return "home";
    }

    @RequestMapping("*")
    public String alsoHome(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        model.addAttribute("findByTag", new TagForm());
        return "home";
    }

    @RequestMapping(value = "reference", method = RequestMethod.POST)
    public String addReference(@Valid @ModelAttribute Reference reference, BindingResult result) {

        if (!reference.getType().equals(ReferenceType.MISC)) {
            BindingResult temp = validateService.Validate(result, reference);
            if (temp.hasErrors()) {
                return "reference";
            }
        }

        referenceService.addReference(reference);
        return "redirect:/home";
    }

    @RequestMapping(value = "reference", method = RequestMethod.GET)
    public String showReferenceForm(Model model) {
        model.addAttribute("reference", new Reference());
        return "reference";
    }

    @RequestMapping(value = "deleteReference/{id}")
    public String deleteReference(@PathVariable Long id) {
        referenceService.deleteReference(id);
        return "redirect:/home";
    }

    @RequestMapping(value = "reference/all", method = RequestMethod.GET)
    public String showReferences(Model model) {
        model.addAttribute("references", referenceService.listAllReferences());
        return "listAll";
    }

    @RequestMapping(value = "reference/bibtex", method = RequestMethod.GET)
    public String showBibtexPage(Model model) {
        model.addAttribute("fileForm", new FileForm());
        return "bibtex";
    }

    @RequestMapping(value = "reference/bibtex", method = RequestMethod.POST)
    public String generateBibtex(@Valid @ModelAttribute FileForm fileForm, BindingResult result, Model model, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            return "bibtex";
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileForm.getFilename() + ".bib");
        InputStream is = new StringBufferInputStream(bibtexService.generateBibtex());
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
        return "redirect:/home";
    }

    @RequestMapping(value = "reference/{referenceId}/tag", method = RequestMethod.GET)
    public String showTaggingForm(@PathVariable Long referenceId, Model model) {
        model.addAttribute("tagForm", new TagForm());
        model.addAttribute("reference", referenceService.findOne(referenceId));
        return "tag";
    }

    @RequestMapping(value = "reference/{referenceId}/tag", method = RequestMethod.POST)
    public String tagReference(@PathVariable Long referenceId, @Valid @ModelAttribute TagForm tagForm, BindingResult result, Model model) {
        Reference reference = referenceService.findOne(referenceId);
        if (result.hasErrors()) {
            model.addAttribute("reference", reference);
            return "tag";
        }

        referenceService.tagReference(reference, tagForm.getTag());
        System.out.println("Controller: " + tagForm.getTag());
        return "redirect:/home";
    }

    @RequestMapping("reference/{referenceId}/tag/{tag}/delete")
    public String deleteTag(@PathVariable Long referenceId, @PathVariable String tag) {
        referenceService.deleteTag(referenceId, tag);
        return "redirect:/reference/" + referenceId + "/tag/" + tag;
    }
    
    @RequestMapping(value = "findByTag", method = RequestMethod.POST)
    public String findReferenceByTag(@Valid @ModelAttribute("findByTag") TagForm tagform, BindingResult result, Model model) {
        if (result.hasErrors()) {

            model.addAttribute("references", referenceService.listAllReferences());
            model.addAttribute("findByTag", new TagForm());
            return "home";
        }

        model.addAttribute("references", referenceService.listByTag(tagform.getTag()));
        return "listTagged";
    }
}
