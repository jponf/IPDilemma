package cat.udl.ipdilemma;

import cat.udl.ipdilemma.exceptions.NonExistingException;

public class Player {
    
    private final PlayerStrategy strategy;
     
    /**
     * Creates a new player using an existent strategy.
     * @param strategy a Strategy object containing the strategy the player 
     * will use to play the game.
     */
    public Player(PlayerStrategy strategy){
        this.strategy = strategy;
    }
    
    /**
     * Creates a new player getting the strategy from its name.
     * @param strategyName the name of the strategy the player will be using.
     * @throws NonExistingException if the strategy does not exist.
     */
    public Player(String strategyName) throws NonExistingException {
        this.strategy = Register.getRegister().getStrategy(strategyName);
    }
    
    /**
     * Returns the action the player will perform next.
     * @return the action the player will perform.
     */
    public PlayerAction nextAction(){
        return strategy.getNextAction();
    }
    
    /**
     * Notifies the rival action to this player to help him make better
     * decisions
     * 
     * @param action the action to be notified.
     */
    public void notifyRivalAction(PlayerAction action){
        strategy.notifyRivalAction(action);
    }

    /**
     * @return The strategy name used by this player.
     */
    public String getStrategyName() {
        return strategy.getName();
    }
}
