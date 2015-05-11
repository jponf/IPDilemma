package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CooperateAlwaysStrategyTest {

    CooperateAlwaysStrategy strategy;

    /**
     * Sets up a cooperate strategy before running the tests.
     */
    @Before
    public void setUp() {
        strategy = new CooperateAlwaysStrategy();
    }

    /**
     * Basic Test: Testing if our strategy will cooperate once.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Basic Test:  Testing if our strategy will cooperate more than once.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = strategy.getNextAction();
        pa = strategy.getNextAction();
        assertEquals(PlayerAction.COOPERATION, pa);
    }

    /**
     * Basic Test: Testing if our strategy will return a correct copy of itself.
     */
    @Test
    public void testCopy() {
        assertEquals(strategy, strategy.copy());
    }
}
