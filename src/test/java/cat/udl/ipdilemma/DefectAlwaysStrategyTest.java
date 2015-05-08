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

    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, defectStrategy.getNextAction());
    }

    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = defectStrategy.getNextAction();
        pa = defectStrategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    @Test
    public void testCopy() {
        assertEquals(defectStrategy, defectStrategy.copy());
    }
}
