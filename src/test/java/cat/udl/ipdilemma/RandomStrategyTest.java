package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomStrategyTest {

    PlayerStrategy strategy;
    final int max_tries = 100;

    @Before
    public void initialize() {
        strategy = new RandomStrategy();
    }

    /**
     * Basic Test: Test if with a fixed max tries, the strategy will eventually return the action DEFECTION
     * Reason: To test the result of getNextAction method could be defection.
     */
    @Test
    public void getNextActionReturnsDEFECTIONTest() {
        boolean last_was_defection = false; // True when getNextAction returns DEFECTION

        for (int i = 0; i < max_tries && !last_was_defection; i++) {
            last_was_defection = strategy.getNextAction() == PlayerAction.DEFECTION;
        }

        assertTrue(last_was_defection);
    }

    /**
     * Basic Test: Test if with a fixed max tries, the strategy will eventually return the action DEFECTION
     * Reason: To test the result of getNextAction method could be defection.
     */
    @Test
    public void getNextActionReturnsCOOPERATIONTest() {
        boolean last_was_cooperation = false; // True when getNextAction returns DEFECTION

        for (int i = 0; i < max_tries && !last_was_cooperation; i++) {
            last_was_cooperation = strategy.getNextAction() == PlayerAction.COOPERATION;
        }

        assertTrue(last_was_cooperation);
    }

    /**
     * Basic Test: Testing if our strategy will return a correct copy of itself.
     * Reson: To test the result of copy method.
     */
    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
