package cat.udl.ipdilemma;

import cat.udl.ipdilemma.exceptions.CurrentlyExistingException;
import cat.udl.ipdilemma.exceptions.NonExistingException;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterTest {

    private static class DummyStrategy implements PlayerStrategy {

        @Override
        public PlayerAction getNextAction() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyRivalAction(PlayerAction pa) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public PlayerStrategy copy() {
            return this;    // Used by getStrategy 
        }
        
    }

    @Before
    public void resetSingleton() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        
        Field instance = Register.class.getDeclaredField("register");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    /**
     * Test of getRegister method, of class Register.
     */
    @Test
    public void testGetRegister() {
        assertNotNull(Register.getRegister());
    }

    /**
     * Test of addStrategy method, of class Register.
     */
    @Test
    public void testAddStrategy() throws CurrentlyExistingException,
        NonExistingException {
        Register reg = Register.getRegister();
        
        reg.addStrategy("dummy", new DummyStrategy());
        assertEquals(DummyStrategy.class, reg.getStrategy("dummy").getClass());
    }

    /**
     * Test of removeStrategy method, of class Register.
     */
    @Test (expected = NonExistingException.class)
    public void testRemoveStrategy() throws CurrentlyExistingException,
        NonExistingException {
        Register reg = Register.getRegister();
        
        // Tested in testAddStrategy :)
        reg.addStrategy("dummy", new DummyStrategy());
        reg.removeStrategy("dummy");        
        reg.getStrategy("dummy");   // If remove worked, now it will throw an exception
    }

    /**
     * Test of getStrategy method, of class Register.
     */
    @Test (expected = NonExistingException.class)
    public void testGetStrategy() throws NonExistingException {
        Register reg = Register.getRegister();
        // There is no strategy, it must raise and exception
        reg.getStrategy("no_one");
    }
}