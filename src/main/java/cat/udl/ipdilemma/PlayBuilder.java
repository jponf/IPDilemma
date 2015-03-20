package cat.udl.ipdilemma;

import cat.udl.ipdilemma.exceptions.NonExistingException;

public class PlayBuilder {

    Player playerA;
    Player playerB;
    UtilityMatrix umatrix;
    int nrounds;
    
    /**
     * Set up the strategy for player A
     *
     * @param name Strategy's name
     * @throws NonExistingException If the given name doesn't belong to a
     * strategy
     */
    public void setPlayerAStrategy(String name) throws NonExistingException {
        this.playerA = new Player(name);
    }

    /**
     * Set up the strategy for player B
     *
     * @param name Strategy's name
     * @throws NonExistingException If the given name doesn't belong to a
     * strategy
     */
    public void setPlayerBStrategy(String name) throws NonExistingException {
        this.playerB = new Player(name);
    }

    /**
     * Set the number of rounds to simulate
     * 
     * @param nrounds 
	 * 
	 * @throws IllegalArgumentException If the number of rounds is less than 1
     */
    public void setNumberOfRounds(int nrounds) throws IllegalArgumentException {
		if(nrounds < 1) {
			throw new IllegalArgumentException("The amount of rounds must be "
					+ "greater than 0");
		}
		this.nrounds = nrounds;
    }
    
    /**
     * Set the values of the payoff matrix
     * 
     * @param t Temptation payoff
     * @param r Reward payoff
     * @param p Punishment payoff
     * @param s Sucker's payoff
     * @throws IllegalArgumentException If the values don't match the matrix restrictions
     */
    public void setUtilityMatrix(int t, int r, int p, int s) 
            throws IllegalArgumentException{
       this.umatrix = new UtilityMatrix(t, r, p, s);
    }
    
    /**
     * @return A new instance of play with the specified configuration
     * @throws IllegalStateException If there are not enough data to create the
     *                                  Play
     */
    public Play create() {
       
        if(hasPlayers() && hasUtilityMatrix() && hasRounds()) {        
            return new Play(nrounds, playerA, playerB, umatrix);
        }
        throw new IllegalStateException("Lack of information to build the Play");
    }
    
    /**
     * 
     * @return True if players were set
     */
    private boolean hasPlayers() {
        return playerA != null && playerB != null;
    }
    
    /**
     * 
     * @return True if the matrix was set
     */
    private boolean hasUtilityMatrix() {
        return umatrix != null;
    }
    
    /**
     * 
     * @return True if rounds have been specified
     */
    private boolean hasRounds() {
        return nrounds > 0;
    }
}
