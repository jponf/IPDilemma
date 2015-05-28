package cat.udl.ipdilemma;

/**
 * This strategy always defects
 */
public class DefectAlwaysStrategy implements PlayerStrategy {
    
    /**
     * Returns the 'defect' action.
     * @return the 'defect' action.
     */
    @Override
    public PlayerAction getNextAction() {
        return PlayerAction.DEFECTION;
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
        return "Defect Always";
    }
    
}
