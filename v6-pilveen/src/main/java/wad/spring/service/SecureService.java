package wad.spring.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface SecureService {

    @PreAuthorize("hasRole('lecturer')")
    public void executeOnlyIfAuthenticatedAsLecturer();

    @PreAuthorize("isAuthenticated()")
    public void executeOnlyIfAuthenticated();

    public void executeFreely();
}
