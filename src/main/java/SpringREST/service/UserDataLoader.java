package SpringREST.service;

import SpringREST.model.Role;
import SpringREST.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDataLoader {

    private RoleService roleService;
    private UserService userService;

    public UserDataLoader(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void loadDataUser() {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ROLE_ADMIN"));
        allRoles.add(new Role("ROLE_USER"));
        roleService.addRole(allRoles);

        User user1 = new User("Bob", "Bobov", (byte) 23, "bob@test.com", "qwe");
        user1.setRoles("ROLE_ADMIN, ROLE_USER");
        userService.addUser(user1);

        User user2 = new User("Tom", "Tomov", (byte) 15, "tom@test.com", "qwe");
        user2.setRoles("ROLE_USER");
        userService.addUser(user2);

        User user3 = new User("Bil", "Bilov", (byte) 32, "bil@test.com", "qwe");
        user3.setRoles("ROLE_USER");
        userService.addUser(user3);

        User user4 = new User("Sam", "Samov", (byte) 19, "sam@test.com", "qwe");
        user4.setRoles("ROLE_USER");
        userService.addUser(user4);

        User user5 = new User("Jim", "Jimov", (byte) 27, "jim@test.com", "qwe");
        user5.setRoles("ROLE_ADMIN");
        userService.addUser(user5);
    }
}
