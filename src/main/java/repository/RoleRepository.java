package repository;

import model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    //find role
    Role findByRole(String role);

    //role ekle
     Role addRole(Role role);

    //role sil
     Role deleteRole(Role role);
}
