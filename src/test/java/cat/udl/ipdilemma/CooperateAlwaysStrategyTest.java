package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CooperateAlwaysStrategyTest {

    CooperateAlwaysStrategy coopstrategy;

    @Before
    public void setUp() {
        coopstrategy = new CooperateAlwaysStrategy();
    }

    /**
     * Basic Test:  Testing if our strategy will be able to cooperate once.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.COOPERATION, coopstrategy.getNextAction());
    }

    /**
     * Basic Test:  Testing if our strategy will be able to cooperate twice.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = coopstrategy.getNextAction();
        pa = coopstrategy.getNextAction();
        assertEquals(PlayerAction.COOPERATION, pa);
    }

    /**
     * Basic Test: Testing if our strategy will be able to give us a copy of itself.
     */
    @Test
    public void testCopy() {
        assertEquals(coopstrategy, coopstrategy.copy());
    }
}
