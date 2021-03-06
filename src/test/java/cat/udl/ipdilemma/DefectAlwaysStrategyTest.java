package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DefectAlwaysStrategyTest {

    DefectAlwaysStrategy defectStrategy;

    @Before
    public void initialize() {
        defectStrategy = new DefectAlwaysStrategy();
    }

    /**
     * Basic Test: Testing if strategy will betray its partner once.
     * Reason: To test the result of getNextAction method once.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, defectStrategy.getNextAction());
    }

    /**
     * Basic Test: Testing if strategy will betray its partner more than once.
     * Reason: To test the result of getNextAction method more than once.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = defectStrategy.getNextAction();
        pa = defectStrategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    /**
     * Basic Test: Testing if our strategy will return a correct copy of itself.
     * Reason: To test the result of copy method.
     */
    @Test
    public void testCopy() {
        assertEquals(defectStrategy, defectStrategy.copy());
    }
}
