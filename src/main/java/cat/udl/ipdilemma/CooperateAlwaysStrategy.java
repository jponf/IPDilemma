package cat.udl.ipdilemma;

/**
 * This strategy always cooperates
 */
public class CooperateAlwaysStrategy implements PlayerStrategy {
    
    /**
     * Returns the 'cooperate' action.
     * @return the 'cooperate' action.
     */
    @Override
    public PlayerAction getNextAction() {
        return PlayerAction.COOPERATION;
    }

	/**
	 * It's a blind strategy, this method is blank
	 * @param pa 
	 */
    @Override
    public void notifyRivalAction(PlayerAction pa) {
        
    }

    @Override
    public PlayerStrategy copy() {
        // This class is "immutable", return this is acceptable as a deep copy
        return this;
    }

    @Override
    public String getName() {
        return "Cooperate Always";
    }
}
