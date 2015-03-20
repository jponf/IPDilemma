package cat.udl.ipdilemma;

import java.util.Objects;

/**
 * Uses the action that the other player has used more, or random if both are
 * used the same amount of times
 */
public class MoreUsedStrategy implements PlayerStrategy {

    PlayerStrategy random_strategy;
    int ncooperations;
    int ndefections;

    /**
     * Builds a new MoreUsedStrategy instance with all the counters initialized
     * to 0
     */
    public MoreUsedStrategy() {
        this.ncooperations = this.ndefections = 0;
        random_strategy = new RandomStrategy();
    }

    /**
     * Used to build a copy of another MoreUsedStrategy
     */
    private MoreUsedStrategy(MoreUsedStrategy other) {
        this.ncooperations = other.ncooperations;
        this.ndefections = other.ndefections;
        this.random_strategy = other.random_strategy.copy();
    }

    /**
     * Returns the action the oponent has used the most.
     *
     * @return the action the oponent has used the most.
     */
    @Override
    public PlayerAction getNextAction() {
        if (ncooperations > ndefections) {
            return PlayerAction.COOPERATION;
        } else if (ncooperations < ndefections) {
            return PlayerAction.DEFECTION;
        }

        return random_strategy.getNextAction();
    }

    /**
     * Increase the internal counter of how much times an action have been taken
     * by the rival
     *
     * @param pa Rival action
     */
    @Override
    public void notifyRivalAction(PlayerAction pa) {
        if (PlayerAction.COOPERATION.equals(pa)) {
            ncooperations++;
        } else {
            ndefections++;
        }

        // Not necessary, random strategy is a blind strategy
        //random_strategy.notifyRivalAction(pa);
    }

    @Override
    public PlayerStrategy copy() {
        return new MoreUsedStrategy(this);
    }

    // Used in tests
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final MoreUsedStrategy other = (MoreUsedStrategy) obj;
        return this.random_strategy.equals(other.random_strategy)
                && this.ncooperations == other.ncooperations
                && this.ndefections == other.ndefections;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.random_strategy);
        hash = 13 * hash + this.ncooperations;
        hash = 13 * hash + this.ndefections;
        return hash;
    }
}
