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

    /**
     * Flow Control Test: Testing if both players cooperate, they will have 
     *                    a prize(R).
     * Reason: To test the result of getPayoff method in a situation where 
     *         A and B cooperate.
     *
     *             |        B coopera       |    B deserta           |
     * ------------|------------------------|------------------------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A coopera   |------------|-----------|------------|-----------|
     *             |     R=2    |    R=2    |    S=0     |    T=3    |
     * ------------|------------|-----------|------------|-----------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A deserta   |------------|-----------|------------|-----------|
     *             |     T=3    |    S=0    |    P=1     |    P=1    |
     * ------------|------------|-----------|------------|-----------|
    */
    @Test
    public void testGetPayoffACooperationBCooperation() {
        Pair<Integer> expected = new Pair<>(r, r);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.COOPERATION,
                PlayerAction.COOPERATION);
        assertEquals("Both values should be R", expected, payoff);
    }

    /**
     * Flow Control Test: Testing if player A cooperates and player B betrays,
     *                    Player A will be a loser (S) and Player B will be 
     *                    a traitor(T).
     * Reason: To test the result of getPayoff method in a situation where 
     *         A cooperates and B betrays.
     *
     *             |        B coopera       |    B deserta           |
     * ------------|------------------------|------------------------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A coopera   |------------|-----------|------------|-----------|
     *             |     R=2    |    R=2    |    S=0     |    T=3    |
     * ------------|------------|-----------|------------|-----------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A deserta   |------------|-----------|------------|-----------|
     *             |     T=3    |    S=0    |    P=1     |    P=1    |
     * ------------|------------|-----------|------------|-----------|
     */
    @Test
    public void testGetPayoffACooperationBDefection() {
        Pair<Integer> expected = new Pair<>(s, t);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.COOPERATION,
                PlayerAction.DEFECTION);
        assertEquals("Values should be [S,T]", expected, payoff);
    }

    /**
     * Flow Control Test: Testing if player B cooperates and player A betrays,
     *                    Player B will be a loser (S) and Player A will be 
     *                    a traitor(T).
     * Reason: To test the result of getPayoff method in a situation where 
     *         A betrays and B cooperates.
     *             |        B coopera       |    B deserta           |
     * ------------|------------------------|------------------------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A coopera   |------------|-----------|------------|-----------|
     *             |     R=2    |    R=2    |    S=0     |    T=3    |
     * ------------|------------|-----------|------------|-----------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A deserta   |------------|-----------|------------|-----------|
     *             |     T=3    |    S=0    |    P=1     |    P=1    |
     * ------------|------------|-----------|------------|-----------|
     */
    @Test
    public void testGetPayoffADefectionBCooperation() {
        Pair<Integer> expected = new Pair<>(t, s);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.DEFECTION,
                PlayerAction.COOPERATION);
        assertEquals("Values should be [T,S]", expected, payoff);
    }

    /**
     * Flow Control Test: Testing if both players betray themselves, 
     *                    they will be punished(P).
     * Reason: To test the result of getPayoff method in a situation where 
     *         A and B betray themselves.
     *             |        B coopera       |    B deserta           |
     * ------------|------------------------|------------------------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A coopera   |------------|-----------|------------|-----------|
     *             |     R=2    |    R=2    |    S=0     |    T=3    |
     * ------------|------------|-----------|------------|-----------|
     *             | Presoner A | PresonerB | Presoner A | PresonerB |
     * A deserta   |------------|-----------|------------|-----------|
     *             |     T=3    |    S=0    |    P=1     |    P=1    |
     * ------------|------------|-----------|------------|-----------|
     */
    @Test
    public void testGetPayoffADefectionBDefection() {
        Pair<Integer> expected = new Pair<>(p, p);
        Pair<Integer> payoff = umatrix.getPayoff(PlayerAction.DEFECTION,
                PlayerAction.DEFECTION);
        assertEquals("Both values should be P", expected, payoff);
    }
}
