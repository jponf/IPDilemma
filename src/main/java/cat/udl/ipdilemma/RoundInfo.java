package cat.udl.ipdilemma;

public class RoundInfo {

    private final PlayerAction pa_action;
    private final PlayerAction pb_action;
    private final int pa_score;
    private final int pb_score;
    private final int round_num;

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

    public String toString(){
        String result = String.format("Round %d\n", round_num);
        result += String.format("\tPlayer A { action: %s, score: %d}\n",
                pa_action.toString(), pa_score);
        result += String.format("\tPlayer B { action: %s, score: %d}\n",
                pb_action.toString(), pb_score);
        return result;
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
