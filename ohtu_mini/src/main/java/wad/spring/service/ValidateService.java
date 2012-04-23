package wad.spring.service;

import java.lang.ref.Reference;
import org.springframework.validation.BindingResult;

public interface ValidateService {
    public BindingResult Validate(BindingResult result, Reference ref);
}
