package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CooperateAlwaysStrategyTest {

    CooperateAlwaysStrategy coopstrategy;

    /**
     * Sets up a cooperate strategy before running the tests.
     */
    @Before
    public void setUp() {
        coopstrategy = new CooperateAlwaysStrategy();
    }

    /**
     * It must return cooperation as the next action.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.COOPERATION, coopstrategy.getNextAction());
    }

    /**
     * Requesting more actions have the same result, action = COOPERATION.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = coopstrategy.getNextAction();
        pa = coopstrategy.getNextAction();
        assertEquals(PlayerAction.COOPERATION, pa);
    }

    /**
     * A copy is equals to the instance being copied.
     */
    @Test
    public void testCopy() {
        assertEquals(coopstrategy, coopstrategy.copy());
    }
}
