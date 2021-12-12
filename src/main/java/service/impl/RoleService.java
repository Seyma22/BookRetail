package service.impl;

import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import repository.RoleRepository;

public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.findById(role.getId());
        roleRepository.save(role);
    }

    public void deleteRole(Role role){
        roleRepository.findById(role.getId());
        roleRepository.delete(role);
    }
}
