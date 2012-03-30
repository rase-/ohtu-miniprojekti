package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.repository.UserRepository;

@Service
public class SecureServiceImpl implements SecureService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void executeOnlyIfAuthenticatedAsLecturer() {
        System.out.println("The guy must be an admin! Note that this was configured in the interface.");
    }

    @Override
    public void executeOnlyIfAuthenticated() {
        System.out.println("The guy must be authenticated! Note that this was configured in the interface.");
    }

    @Override
    @Transactional
    public void executeFreely() {
        // populate db if needed
        if (userRepository.count() > 0) {
            return;
        }

        User matti = new User();
        matti.setUsername("matti");
        matti.setPassword("bonus");
        matti = userRepository.save(matti);


        List<Role> roles = new ArrayList();

        Role role = new Role();
        role.setRolename("lecturer");
        roles.add(role);
        role = new Role();
        role.setRolename("assistant");
        roles.add(role);
        
        matti.setRoles(roles);
    }
}
