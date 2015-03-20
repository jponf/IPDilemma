package cat.udl.ipdilemma;


public interface PlayerStrategy {

    /**
     * 
     * @return The action take for the next round
     */
    public PlayerAction getNextAction();
    
    /**
     * Notifies the rival action to this strategy to help him make better
     * decisions
     * 
     * Blind strategies may leave this method blank
     * 
     * @param pa 
     */
    public void notifyRivalAction(PlayerAction pa);
    
    /**
     * 
     * @return A deep copy of this PlayerStrategy
     */
    public PlayerStrategy copy();
    
}
