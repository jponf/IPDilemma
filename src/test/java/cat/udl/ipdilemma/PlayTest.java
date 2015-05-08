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

    }

    @Test(expected = IllegalArgumentException.class)
    public void tooFewRoundsTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(3, 2, 1, 0);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(-1, playerA, playerB, umatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPlayerATest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = null;
        Player playerB = new Player(strategy);

        Play game = new Play(0, playerA, playerB, umatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPlayerBTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = null;

        Play game = new Play(0, playerA, playerB, umatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullUMatrixTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = null;
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(0, playerA, playerB, umatrix);
    }

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

    @Test
    public void hasMoreRoundsTest() {

        PlayerStrategy strategy = new StrategyDummy();
        UtilityMatrix umatrix = new UtilityMatrix(T, R, P, S);
        Player playerA = new Player(strategy);
        Player playerB = new Player(strategy);

        Play game = new Play(MAX_STEPS, playerA, playerB, umatrix);

        assertTrue(game.hasMoreRounds());
    }

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
