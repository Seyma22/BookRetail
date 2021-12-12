package service;

import model.Role;

public interface IRoleService {

    //rol ekle
    public Role addRole(Role role);

    //rol sil
    public void deleteRole(Role role);

    //rol güncelle
    public Role updateRole(Role role);
}
