package cat.udl.ipdilemma;

import java.util.HashMap;
import java.util.Map;

public class UtilityMatrix {

    private static enum PlayerActionKeys {

        A_COOP_B_COOP, A_COOP_B_DEFECT,
        A_DEFECT_B_COOP, A_DEFECT_B_DEFECT
    };
    Map<PlayerActionKeys, Pair<Integer>> matrix;

    /**
     * Builds a new payoff matrix
     *
     * The values have two restrictions: 1: T > R > P > S 2: R > (T + S) / 2
     *
     * @param t
     * @param r
     * @param p
     * @param s
     *
     * @throws IllegalArgumentException If one of the previous restrictions is
     * violated
     */
    public UtilityMatrix(int t, int r, int p, int s) {

        if (t <= r || r <= p || p <= s) {
            throw new IllegalArgumentException("Violation of condition: "
                    + "T > R > P > S");
        } else if (r <= (t + s) / 2.0f) {
            throw new IllegalArgumentException("Violation of condition: "
                    + "R > (T + S) / 2");
        }

        matrix = new HashMap<>();
        matrix.put(PlayerActionKeys.A_COOP_B_COOP, new Pair<>(r, r));
        matrix.put(PlayerActionKeys.A_COOP_B_DEFECT, new Pair<>(s, t));
        matrix.put(PlayerActionKeys.A_DEFECT_B_COOP, new Pair<>(t, s));
        matrix.put(PlayerActionKeys.A_DEFECT_B_DEFECT, new Pair<>(p, p));
    }

    /**
     *
     * @param pa_action
     * @param pb_action
     * @return A pair with the payoff of both players given their actions
     */
    public Pair<Integer> getPayoff(PlayerAction pa_action,
            PlayerAction pb_action) {

        return matrix.get(computeActionKey(pa_action, pb_action));
    }

    /**
     * Compute the key associated to the given actions
     *
     * @param pa_action Action performed by player A
     * @param pb_action Action performed by player B
     * @return The key associated to the given actions
     */
    private PlayerActionKeys computeActionKey(PlayerAction pa_action,
            PlayerAction pb_action) {

        if (pa_action == PlayerAction.COOPERATION) {

            if (pb_action == PlayerAction.COOPERATION) {
                return PlayerActionKeys.A_COOP_B_COOP;
            } else {
                return PlayerActionKeys.A_COOP_B_DEFECT;
            }

        } else {

            if (pb_action == PlayerAction.COOPERATION) {
                return PlayerActionKeys.A_DEFECT_B_COOP;
            } else {
                return PlayerActionKeys.A_DEFECT_B_DEFECT;
            }
        }
    }

    @Override
    public String toString(){
        int T = getPayoff(PlayerAction.COOPERATION, PlayerAction.DEFECTION).getSecond();
        int S = getPayoff(PlayerAction.COOPERATION, PlayerAction.DEFECTION).getFirst();
        int P = getPayoff(PlayerAction.DEFECTION,   PlayerAction.DEFECTION).getFirst();
        int R = getPayoff(PlayerAction.COOPERATION, PlayerAction.COOPERATION).getFirst();

        return String.format("Utility Matrix -> {T: %d; R: %d; P: %d; S: %d}\n", T, R, P, S);
    }
}
