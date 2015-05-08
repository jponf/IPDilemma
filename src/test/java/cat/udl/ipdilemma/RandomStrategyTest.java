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
     * Test if with a fixed max tries, the strategy will eventually return the action DEFECTION
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
     * Test if with a fixed max tries, the strategy will eventually return the action COOPERATION
     */
    @Test
    public void getNextActionReturnsCOOPERATIONTest() {
        boolean last_was_cooperation = false; // True when getNextAction returns DEFECTION

        for (int i = 0; i < max_tries && !last_was_cooperation; i++) {
            last_was_cooperation = strategy.getNextAction() == PlayerAction.COOPERATION;
        }

        assertTrue(last_was_cooperation);
    }

    @Test
    public void copyTest() {
        assertEquals(strategy, strategy.copy());
    }
}
