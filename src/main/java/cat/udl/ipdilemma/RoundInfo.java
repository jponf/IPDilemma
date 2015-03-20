package cat.udl.ipdilemma;

public class RoundInfo {

	private PlayerAction pa_action;
	private PlayerAction pb_action;
	private int pa_score;
	private int pb_score;
	private int round_num;

	/**
	 * Builds a new instance of RoundInfo
	 * 
	 * @param pa_action Player A action
	 * @param pb_action Player B action
	 * @param pa_score Player A score
	 * @param pb_score Player B score
	 * @param round_num Round number
	 */
	public RoundInfo(PlayerAction pa_action, PlayerAction pb_action, 
			int pa_score, int pb_score, int round_num) {
		this.pa_action = pa_action;
		this.pb_action = pb_action;
		this.pa_score = pa_score;
		this.pb_score = pb_score;
		this.round_num = round_num;
	}

	
	/**
	 * @return Player A action
	 */
	public PlayerAction getPlayerAAction() {
		return pa_action;
	}

	/**
	 * @return Player B action
	 */
	public PlayerAction getPlayerBAction() {
		return pb_action;
	}

	/**
	 * @return Player A score
	 */
	public int getPlayerAScore() {
		return pa_score;
	}

	/**
	 * @return Player B score
	 */
	public int getPlayerBScore() {
		return pb_score;
	}

	/**
	 * @return The number of the current iteration
	 */
	public int getRoundNumber() {
		return round_num;
	}
}
