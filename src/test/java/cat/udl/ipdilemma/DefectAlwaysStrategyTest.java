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
     * It must return DEFECTION as the next action.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, defectStrategy.getNextAction());
    }

    /**
     * Requesting more actions does not change the result, it is always
     * DEFECTION.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = defectStrategy.getNextAction();
        pa = defectStrategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    /**
     * A copy of the instance is equals to the instance being copied.
     */
    @Test
    public void testCopy() {
        assertEquals(defectStrategy, defectStrategy.copy());
    }
}
