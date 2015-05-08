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

    @Test
    public void getNextActionOnceTest() {
        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    @Test
    public void getNextActionMoreThanOnceTest() {
        PlayerAction action = strategy.getNextAction();
        action = strategy.getNextAction();

        assertEquals(PlayerAction.COOPERATION, action);
    }

    @Test
    public void notifyRivalSameActionTest() {
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
        strategy.notifyRivalAction(PlayerAction.COOPERATION);

        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    @Test
    public void notifyRivalDifferentActionTest() {
        strategy.notifyRivalAction(PlayerAction.DEFECTION);
        strategy.notifyRivalAction(PlayerAction.DEFECTION);

        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    @Test
    public void equalsTest() {
        assertTrue(strategy.equals(strategy.copy()));
    }

    @Test
    public void hashcodeTest() {
        assertEquals(strategy.hashCode(), strategy.copy().hashCode());
    }

    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
