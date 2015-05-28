package cat.udl.ipdilemma;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayTest {

    private static final int T = 3;
    private static final int R = 2;
    private static final int P = 1;
    private static final int S = 0;
    private static final int MAX_STEPS = 10;

    private static class StrategyDummy implements PlayerStrategy {

        @Override
        public PlayerAction getNextAction() {
            return PlayerAction.COOPERATION;
        }

        @Override
        public void notifyRivalAction(PlayerAction pa) {

        }

        @Override
        public PlayerStrategy copy() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getName() {
            return "Dummy";
        }
    }
    
    /**
     * Bad Data Test: Testing if it's possible to play the rounds number.
     * Reason: To test the result of constructor method when nºrounds <= 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void tooFewRoundsTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(3, 2, 1, 0);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(-1, playerA, playerB, umatrix);
    }
    
    /**
     * Bad Data Test: Testing if it's possible to play with only the player B.
     * Reason: To test the result of constructor method when player A is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullPlayerATest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = null;
        Player playerB = new Player(strategy);

        Play game = new Play(0, playerA, playerB, umatrix);
    }

    /**
     * Bad Data Test: Testing if it's possible to play with only the player A.
     * Reason: To test the result of constructor method when the player B is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullPlayerBTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = null;

        Play game = new Play(0, playerA, playerB, umatrix);
    }

    /**
     * Bad Data Test: Testing if it's possible to play without utility matrix.
     * Reason: To test the result of constructor method when the utility matrix
     *         is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullUMatrixTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = null;
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(0, playerA, playerB, umatrix);
    }
    /**
     * Basic Test: Testing if the play class is able to correctly calculate the 
     *             score from player A in the first round.
     * Reason: To test once the result of getPlayerAScore method.
     */
    @Test
    public void playerAScoreAfterStepTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(1, playerA, playerB, umatrix);

        game.runRound();

        int playerAScore = game.getPlayerAScore();
        assertEquals(playerAScore, R);
    }

    /**
     * Basic Test: Testing if the play class is able to correctly calculate the 
     *             score from player B in the first round.
     * Reason: To test once the result of getPlayerBScore method.
     */
    @Test
    public void playerBScoreAfterStepTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(1, playerA, playerB, umatrix);

        game.runRound();

        int playerBScore = game.getPlayerBScore();
        assertEquals(playerBScore, R);
    }

    /**
     * Basic Test: Testing if the play class is able to correctly calculate the 
     *             scores from player A.
     * Reason: To test more than once the result of getPlayerAScore method.
     */
    @Test
    public void playerAScoreAfterRunTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        game.runAll();

        int playerAScore = game.getPlayerAScore();
        assertEquals(playerAScore, R * MAX_STEPS);
    }

    /**
     * Basic Test: Testing if the play class is able to correctly calculate the 
     *             scores from player A.
     * Reason: To test more than once the result of getPlayerAScore method.
     */
    @Test
    public void playerBScoreAfterRunTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        game.runAll();

        int playerBScore = game.getPlayerBScore();
        assertEquals(playerBScore, R * MAX_STEPS);
    }
    
    /**
     * Basic Test: Testing if the play class is able to correctly calculate the 
     *             scores from player A and B in the first round.
     * Reason: To test the result of runRound method.
     */
    @Test
    public void totalScoreAfterStepTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        game.runRound();

        Pair<Integer> score = new Pair(game.getPlayerAScore(), game.getPlayerBScore());
        Pair<Integer> expectedScore = new Pair(R, R);
        assertEquals(score, expectedScore);
    }

    /**
     * Basic Test: Testing if the play class is able to correctly calculate 
     *             the scores from player A and B at the end of a game.
     * Reason: To test the result of runAll method.
     */
    @Test
    public void totalScoreAfterRunTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        game.runAll();

        Pair<Integer> score = new Pair(game.getPlayerAScore(), game.getPlayerBScore());
        Pair<Integer> expectedScore = new Pair(R * MAX_STEPS, R * MAX_STEPS);
        assertEquals(score, expectedScore);
    }

    /**
     * Flow Control Test: Testing if the play class will know if it has more 
     *             rounds to play
     * Reason: To test the result of hasMoreRounds method when 
     *         the rounds executed are less than the rounds to execute.
     */
    @Test
    public void hasMoreRoundsTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        assertTrue(game.hasMoreRounds());
    }
    /**
     * Flow Control Test: Testing if the play class will know if it hasn't more 
     *             rounds to play
     * Reason: To test the result of hasMoreRounds method when 
     *         the rounds executed are equals to the rounds to execute.
     */
    @Test
    public void notHasMoreRoundsTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);
        
        int i = 0;
        while (i < MAX_STEPS && game.hasMoreRounds()) {
            game.runRound();
            i += 1;
        }

        assertTrue("# rounds not exhausted", i == MAX_STEPS);
        assertFalse("Rounds exhausted but not properly notified", game.hasMoreRounds());
    }
}
