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
    public List<Reference> listByTag();
    public void deleteReference(Long id);
}
