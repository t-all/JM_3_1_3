package SpringREST.service;

import SpringREST.model.Role;

import java.util.Set;

public interface RoleService {

    void addRole(Set<Role> role);

    void updateRole(Role role);

    void deleteRoleById(Long id);

    Set<Role> getAllRoles();

    Role getRole(Long id);

    Role getRoleByRole(String role);
}
