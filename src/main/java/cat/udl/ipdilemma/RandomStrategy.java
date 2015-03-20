package cat.udl.ipdilemma;

import java.util.Random;

/**
 * This strategy chooses an action randomly
 */
public class RandomStrategy implements PlayerStrategy {

    // Shared Random instance to guarantee "random" values between copies
    private static final Random rand = new Random();
    // PlayerAction.values() returns always the same array
    private static final PlayerAction[] pactions = PlayerAction.values();

    /**
     * Returns a randomly chosen action.
     *
     * @return a randomly chosen action.
     */
    @Override
    public PlayerAction getNextAction() {
        return RandomStrategy.pactions[rand.nextInt(RandomStrategy.pactions.length)];
    }

    /**
     * It's a blind strategy, this method is blank
     *
     * @param pa
     */
    @Override
    public void notifyRivalAction(PlayerAction pa) {

    }

    @Override
    public PlayerStrategy copy() {
        // This class is "inmutable", return this is acceptable as a deep copy
        return this;
    }

}
