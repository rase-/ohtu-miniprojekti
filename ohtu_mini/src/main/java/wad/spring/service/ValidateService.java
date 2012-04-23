package wad.spring.service;

import wad.spring.domain.Reference;
import org.springframework.validation.BindingResult;

public interface ValidateService {
    public BindingResult Validate(BindingResult result, Reference ref);
}
