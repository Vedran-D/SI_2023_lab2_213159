import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    User user = null; // null user
    User noPass = new User("username1",null,"email@gmail.com"); // user without password
    User noEmail = new User("username1","password!",null); // user without e-mail
    User noName = new User(null,"password!","email@gmail.com"); // user without a username
    List<User> users = new ArrayList<>(); // list of users
    @Test
    void everyBranchTest() {

        users.add(new User("someName1","somePassowrd!","someEmail1@gmail.com")
                ); // some users...
        users.add(new User("someName2","somePassowrd!","someEmail2@gmail.com")); // some users...

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(user,users)); // test null user, should throw exception
        assertTrue(ex.getMessage().contains("Mandatory"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(noPass,users)); // test user with no password, should throw exception
        assertTrue(ex.getMessage().contains("Mandatory"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(noEmail,users)); // test user with no email, should throw exception
        assertTrue(ex.getMessage().contains("Mandatory"));

        SILab2.function(noName,users);
        assertEquals("email@gmail.com", noName.getUsername()); // here I pass a user with no username and later in the function it is assigned a username based on the user's e-mail, should return true

        assertTrue(SILab2.function(new User("perfUsername","perfPassword!","perfEmail@gmai..com"), users)); // good username, will return true
        assertFalse(SILab2.function(new User("username1","password!","email.com"),users)); // invalid email
        assertFalse(SILab2.function(new User("username1","username1!!!","email.com"),users)); // invalid password
        assertFalse(SILab2.function(new User("username1","use!","email.com"),users)); // invalid password length
        assertFalse(SILab2.function(new User("username1","use r123123!","email.com"),users)); // blank space in password
        assertFalse(SILab2.function(new User("username1","user","email.com"),users)); // password has no special characters
        assertFalse(SILab2.function(new User("someName1","user","email.com"),users)); // user with same name with someone from usersList
        assertFalse(SILab2.function(new User("username1","user","someEmail2@gmail.com"),users)); // user with same e-mail with someone from usersList
    }

    @Test
    void multipleConditionsTest(){
        // if (user==null || user.getPassword()==null || user.getEmail()==null)
        // T || F || F
        // F || T || F
        // F || F || T
        // F || F || F

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(user,users)); // test T || F || F
        assertTrue(ex.getMessage().contains("Mandatory"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(noPass,users)); // test F || T || F
        assertTrue(ex.getMessage().contains("Mandatory"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(noEmail,users)); // test F || F || T
        assertTrue(ex.getMessage().contains("Mandatory"));

        RuntimeException ex2 = null;
        try{
            SILab2.function(new User("perfUsername","perfPassword!","perfEmail@gmai..com"),users);
        }
        catch (RuntimeException e){
            ex2 = e;
        }
        assertNull(ex2); // test T || T || T

    }

}

