package cat.udl.ipdilemma;

import cat.udl.ipdilemma.exceptions.NonExistingException;

public class PlayBuilder {

    Player playerA;
    Player playerB;
    UtilityMatrix umatrix;
    int nrounds;
    boolean logginEnable;

    /**
     * Initializes the builder attributes to their default values.
     */
    public PlayBuilder() {
        playerA = playerB = null;
        umatrix = null;
        nrounds = 0;
        logginEnable = false;
    }

    /**
     * Set up the strategy for player A.
     *
     * @param name Strategy's name
     * @throws NonExistingException If the given name doesn't belong to a
     * strategy
     */
    public void setPlayerAStrategy(String name) throws NonExistingException {
        this.playerA = new Player(name);
    }

    /**
     * Set up the strategy for player A.
     *
     * @param playerStrategy The player strategy.
     */
    public void setPlayerAStrategy(PlayerStrategy playerStrategy) {
        this.playerA = new Player(playerStrategy);
    }

    /**
     * Set up the strategy for player B.
     *
     * @param name Strategy's name
     * @throws NonExistingException If the given name doesn't belong to a
     * strategy
     */
    public void setPlayerBStrategy(String name) throws NonExistingException {
        this.playerB = new Player(name);
    }

    /**
     * Set up the strategy for player B.
     *
     * @param playerStrategy The player strategy.
     */
    public void setPlayerBStrategy(PlayerStrategy playerStrategy) {
        this.playerB = new Player(playerStrategy);
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
     * @throws IllegalStateException If there are not enough data to create the Play
     */
    public Play create() {
       
        if(hasPlayers() && hasUtilityMatrix() && hasRounds()) {
            Play play = new Play(nrounds, playerA, playerB, umatrix);
            if(logginEnable){
                PlayLogger logger = new PlayLogger();
                logger.initializeLog(play);
                play.addObserver(logger);
            }
            return play;
        }
        throw new IllegalStateException("Lack of information to build the Play");
    }

    /**
     * Enables the creation of the play log.
     * This method is only effective before calling create().
     */
    public void enableLogging() {
        this.logginEnable = true;
    }

    /**
     * Disables the creation of the play log.
     * This method is only effective before calling create().
     */
    public void dissableLogging() {
        this.logginEnable = false;
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
