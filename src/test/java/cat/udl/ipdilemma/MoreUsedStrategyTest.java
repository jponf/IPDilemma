package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoreUsedStrategyTest {

    PlayerStrategy strategy;

    /**
     * Initialize the tested strategy, in a way that COOPERATION is the
     * initial more used strategy.
     */
    @Before
    public void initialize() {
        strategy = new MoreUsedStrategy();

        // Notify the strategy that the player cooperates
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
    }

    /**
     * Since it is configured so as COOPERATION is the more used strategy
     * it should return COOPERATION.
     */
    @Test
    public void getNextActionOnceTest() {
        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Iteratively requesting more actions, without notifying any additional
     * rival action, has to return COOPERATION.
     */
    @Test
    public void getNextActionMoreThanOnceTest() {
        PlayerAction action = strategy.getNextAction();
        action = strategy.getNextAction();

        assertEquals(PlayerAction.COOPERATION, action);
    }

    /**
     * Notifying the same action does not have to change the result.
     */
    @Test
    public void notifyRivalSameActionTest() {
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
        strategy.notifyRivalAction(PlayerAction.COOPERATION);

        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Notifying DEFECTION more times than COOPERATION has to change the
     * next action to DEFECTION.
     */
    @Test
    public void notifyRivalDifferentActionTest() {
        strategy.notifyRivalAction(PlayerAction.DEFECTION);
        strategy.notifyRivalAction(PlayerAction.DEFECTION);

        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * A copy must be equals to the original one.
     */
    @Test
    public void equalsTest() {
        assertTrue(strategy.equals(strategy.copy()));
    }

    /**
     * A copy must have the same hash code as the original one.
     */
    @Test
    public void hashcodeTest() {
        assertEquals(strategy.hashCode(), strategy.copy().hashCode());
    }

    /**
     * A copy of the instance is equals to the instance being copied.
     */
    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
