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
     * Basic Test: Since it is configured so as COOPERATION is the more used strategy
     * it should return COOPERATION.
     */
    @Test
    public void getNextActionOnceTest() {
        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Basic Test: Requesting the next action more than once, without modifying
     *             the rival's last action, shall return the same result.
     */
    @Test
    public void getNextActionMoreThanOnceTest() {
        PlayerAction action = strategy.getNextAction();
        action = strategy.getNextAction();

        assertEquals(PlayerAction.COOPERATION, action);
    }

    /**
     * Basic Test: Notifying the same action does not have to change the result.
     */
    @Test
    public void notifyRivalSameActionTest() {
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
        strategy.notifyRivalAction(PlayerAction.COOPERATION);

        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will betray, if rival usually betray
     * him.
     */
    @Test
    public void notifyRivalDifferentActionTest() {
        strategy.notifyRivalAction(PlayerAction.DEFECTION);
        strategy.notifyRivalAction(PlayerAction.DEFECTION);

        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will give us a correct copy of
     *             itself.
     */
    @Test
    public void equalsTest() {
        assertTrue(strategy.equals(strategy.copy()));
    }

    /**
     * Basic Test: Testing if a copy will return the same hash code as the
     *             as the original instance.
     */
    @Test
    public void hashcodeTest() {
        assertEquals(strategy.hashCode(), strategy.copy().hashCode());
    }

    /**
     * Basic Test: Testing if our strategy will be return a correct copy of
     *             itself.
     */
    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
