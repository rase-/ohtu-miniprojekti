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
public class TagForm {
    @Pattern(regexp = "[^<>$%]*", message = "The tag should not contain letters <>$%\"'")
    private String tag;
    
    public String getTag() {
        return this.tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
}
