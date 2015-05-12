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
     * Bad Data Test: Testing if the register will be nullable when he is 
     *                uninitialized.
     * Reason: To test the result of getRegister method and if it follow 
     *         the singleton pattern.
     */
    @Test
    public void testGetRegister() {
        assertNotNull(Register.getRegister());
    }

    /**
     * Bad Data Test: Testing if the register will be able to find a strategy 
     *                that it has been loaded.
     * Reson: To test the result of addStrategy method and getStrategy method.
     */
    @Test
    public void testAddStrategy() throws CurrentlyExistingException,
        NonExistingException {
        Register reg = Register.getRegister();
        
        reg.addStrategy("dummy", new DummyStrategy());
        assertEquals(DummyStrategy.class, reg.getStrategy("dummy").getClass());
    }
    
    /**
     * Bad Data Test: Testing if the register will be able to find a strategy 
     *                that it hasn't been loaded.
     * Reson: To test the result of getStrategy method when it have to find 
     *        a nonexistent strategy.
     */
    @Test (expected = NonExistingException.class)
    public void testGetStrategy() throws NonExistingException {
        Register reg = Register.getRegister();
        // There is no strategy, it must raise and exception
        reg.getStrategy("no_one");
    }
    
    /**
     * Bad Data Test: Testing if the register will be able to remove correctly a 
     *                strategy.
     * Reson: To test the result of getStrategy method when it have to find 
     *        a existent strategy.
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
}