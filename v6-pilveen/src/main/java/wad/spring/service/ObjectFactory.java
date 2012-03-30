package wad.spring.service;

import java.util.List;
import org.springframework.security.access.prepost.PostFilter;
import wad.spring.domain.SampleObject;

public interface ObjectFactory {
    @PostFilter("(!filterObject.awesome) or (filterObject.awesome and hasRole('lecturer'))")
    public List<SampleObject> getObjects();
}
