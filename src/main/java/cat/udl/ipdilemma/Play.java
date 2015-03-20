package cat.udl.ipdilemma;

import java.util.Observable;

public class Play extends Observable {

    int nrounds;		// Round to execute
    int erounds;		// Executed rounds
    int playerAScore;
    int playerBScore;
    Player playerA;
    Player playerB;
    UtilityMatrix umatrix;

    /**
     * Builds a new Play instance with the given information
     *
     * @param nrounds Number of rounds for this Play (Must be great than 0)
     * @param playerA Player A
     * @param playerB Player B
     * @param umatrix UtilityMatrix with the payoff values
     *
     * @throws IllegalArgumentException If nrounds is less than or equals 0
     * @throws NullPointerException If one of the Players or the UtilityMatrix
     * is null
     */
    public Play(int nrounds, Player playerA, Player playerB,
            UtilityMatrix umatrix) {

        if (nrounds <= 0) {
            throw new IllegalArgumentException("The amount of rounds must be "
                    + "greater than 0");
        }
        if (playerA == null || playerB == null) {
            throw new NullPointerException("Players can't be null");
        }
        if (umatrix == null) {
            throw new NullPointerException("UtilityMatrix can't be null");
        }

        this.nrounds = nrounds;

        this.playerA = playerA;
        this.playerB = playerB;
        this.umatrix = umatrix;

        this.playerAScore = 0;
        this.playerBScore = 0;

    }

    /**
     * Performs one round
     *
     * @throws IllegalStateException If there are not more rounds to execute
     */
    public void runRound() {

        if (!hasMoreRounds()) {
            throw new IllegalStateException("This game have finished");
        }

        PlayerAction actionA = playerA.nextAction();
        PlayerAction actionB = playerB.nextAction();

        Pair<Integer> payoff = this.umatrix.getPayoff(actionA, actionB);

        this.playerAScore += payoff.getFirst();
        this.playerBScore += payoff.getSecond();

        playerA.notifyRivalAction(actionB);
        playerB.notifyRivalAction(actionA);

        this.erounds++;

        RoundInfo rinfo = new RoundInfo(actionA, actionB, playerAScore,
                playerBScore, erounds);
        setChanged();
        notifyObservers(rinfo);
    }

    /**
     * Performs all the rounds
     *
     * @throws IllegalStateException If there are not rounds to execute
     */
    public void runAll() {
        if (!hasMoreRounds()) {
            throw new IllegalStateException("This game have finished");
        }

        while (hasMoreRounds()) {
            runRound();
        }
    }

    /**
     * Returns the score of the first player.
     *
     * @return The score of the first player.
     */
    public int getPlayerAScore() {
        return playerAScore;
    }

    /**
     * Returns the score of the second player.
     *
     * @return The score of the second player.
     */
    public int getPlayerBScore() {
        return playerBScore;
    }

    /**
     * Returns the total score of the two players.
     *
     * @return A Pair of Integer with each of the scores.
     */
    public Pair<Integer> getScore() {
        return new Pair(getPlayerAScore(), getPlayerBScore());
    }

    /**
     *
     * @return True if there are more rounds, false otherwise
     */
    public boolean hasMoreRounds() {
        return erounds != nrounds;
    }
}
