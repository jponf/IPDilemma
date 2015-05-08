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

    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.COOPERATION, coopstrategy.getNextAction());
    }

    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = coopstrategy.getNextAction();
        pa = coopstrategy.getNextAction();
        assertEquals(PlayerAction.COOPERATION, pa);
    }

    @Test
    public void testCopy() {
        assertEquals(coopstrategy, coopstrategy.copy());
    }
}
