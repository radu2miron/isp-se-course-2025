package edu.tucn.ispse.lecture4.systemcomponents;

import edu.tucn.ispse.lecture4.Main;
import edu.tucn.ispse.lecture4.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
class AuthenticationModuleTest {
    private AuthenticationModule authenticationModule;

    @BeforeEach
    public void init() {
        User[] users = Main.createUsers();
        authenticationModule = new AuthenticationModule(users);
    }

    @Test
    void testCheckCredentials() {
        Assertions.assertNotNull(authenticationModule.checkCredentials("admin", "pwd1"),
                "the admin user instance with matching credentials should be returned");
        Assertions.assertNull(authenticationModule.checkCredentials("admin", "pwdXYZ"),
                "null should be returned on invalid admin credentials");
        Assertions.assertNotNull(authenticationModule.checkCredentials("client1", "pwd2"),
                "the client user instance with matching credentials should be returned");
        Assertions.assertNull(authenticationModule.checkCredentials("client2", "pwdABC"),
                "null should be returned on invalid client credentials");
    }
}
