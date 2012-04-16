/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.form;

import javax.validation.constraints.Pattern;

/**
 *
 * @author tonykova
 */
public class FileForm {
    @Pattern(regexp="[^<>%$]+", message="Filename should not contain <>$ or %")
    private String filename;
    
    public FileForm() {
        
    }
    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
