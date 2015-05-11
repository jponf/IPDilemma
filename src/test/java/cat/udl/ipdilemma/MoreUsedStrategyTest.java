package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoreUsedStrategyTest {

    PlayerStrategy strategy;

    @Before
    public void initialize() {
        strategy = new MoreUsedStrategy();

        // Notify the strategy that the player cooperates
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
    }

    /**
     * Basic Test: Testing that our strategy will cooperate once, if rival cooperate.
     */
    @Test
    public void getNextActionOnceTest() {
        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will cooperate twice, when its partner cooperated.
     */
    @Test
    public void getNextActionMoreThanOnceTest() {
        PlayerAction action = strategy.getNextAction();
        action = strategy.getNextAction();

        assertEquals(PlayerAction.COOPERATION, action);
    }

    /**
     * Basic Test: Testing if our strategy will cooperate twice, if rival cooperate.
     */
    @Test
    public void notifyRivalSameActionTest() {
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
        strategy.notifyRivalAction(PlayerAction.COOPERATION);

        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will betray, if rival usually betray him.
     */
    @Test
    public void notifyRivalDifferentActionTest() {
        strategy.notifyRivalAction(PlayerAction.DEFECTION);
        strategy.notifyRivalAction(PlayerAction.DEFECTION);

        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will be able to give us a correct copy of itself.
     */
    @Test
    public void equalsTest() {
        assertTrue(strategy.equals(strategy.copy()));
    }

    /**
     * Basic Test: Testing if our strategy will be able to give us a copy of his hasCode.
     */
    @Test
    public void hashcodeTest() {
        assertEquals(strategy.hashCode(), strategy.copy().hashCode());
    }

    /**
     * Basic Test: Testing if our strategy will be able to give us a copy of itself.
     */
    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
