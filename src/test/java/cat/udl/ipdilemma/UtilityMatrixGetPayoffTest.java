package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityMatrixGetPayoffTest {

    UtilityMatrix umatrix;
    int t, r, p, s;

    @Before
    public void setUp() {
        t = 3;
        r = 2;
        p = 1;
        s = 0;

        umatrix = new UtilityMatrix(t, r, p, s);
    }

    @Test
    public void testGetPayoffACooperationBCooperation() {
        Pair<Integer> expected = new Pair<>(r, r);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.COOPERATION,
                PlayerAction.COOPERATION);
        assertEquals("Both values should be R", expected, payoff);
    }

    @Test
    public void testGetPayoffACooperationBDefection() {
        Pair<Integer> expected = new Pair<>(s, t);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.COOPERATION,
                PlayerAction.DEFECTION);
        assertEquals("Values should be [S,T]", expected, payoff);
    }

    @Test
    public void testGetPayoffADefectionBCooperation() {
        Pair<Integer> expected = new Pair<>(t, s);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.DEFECTION,
                PlayerAction.COOPERATION);
        assertEquals("Values should be [T,S]", expected, payoff);
    }

    @Test
    public void testGetPayoffADefectionBDefection() {
        Pair<Integer> expected = new Pair<>(p, p);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.DEFECTION,
                PlayerAction.DEFECTION);
        assertEquals("Both values should be P", expected, payoff);
    }
}
