/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Reference;

/**
 *
 * @author tonykova
 */
public interface ReferenceService {
    public void addReference(Reference reference);
    public List<Reference> listAllReferences();
    public void deleteReference(Long id);
    public Reference findOne(Long id);
    public void tagReference(Reference reference, String tag);
    public void deleteTag(Long referenceId, String tag);
    public List<Reference> listByTag(String tag);
}
