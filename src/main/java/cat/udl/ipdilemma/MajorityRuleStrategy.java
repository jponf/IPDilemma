package cat.udl.ipdilemma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This strategy returns the action more 'voted' or randomly selects one if all
 * the options have the same amount of 'votes'
 */
public class MajorityRuleStrategy implements PlayerStrategy {

    List<PlayerStrategy> strategies;
    PlayerStrategy random_strategy;

    /**
     * Creates a MajorityRuleStrategy that depends on the base implemented
     * strategies:
     *
     * 1- CooperateAlwaysStrategy 2- DefectAlwaysStrategy 3- RandomStrategy 4-
     * MoreUsedStrategy
     */
    public MajorityRuleStrategy() {
        strategies = new ArrayList<>();
        strategies.add(new CooperateAlwaysStrategy());
        strategies.add(new DefectAlwaysStrategy());
        strategies.add(new RandomStrategy());
        strategies.add(new MoreUsedStrategy());

        random_strategy = new RandomStrategy();
    }

    /**
     * Creates a MajorityRuleStrategy with the given strategies
     *
     * @param strategies The list of strategies
     * @throws IllegalArgumentException if strategies is null or it's size is
     * equals to 0
     */
    public MajorityRuleStrategy(List<PlayerStrategy> strategies) {
        if (strategies == null) {
            throw new IllegalArgumentException("Null list of strategies");
        }
        if (strategies.isEmpty()) {
            throw new IllegalArgumentException(
                    "Given an empty list of strategies");
        }

        setFromStrategiesList(strategies);
        random_strategy = new RandomStrategy();
    }

    /**
     * Copy constructor
     */
    private MajorityRuleStrategy(MajorityRuleStrategy other) {
        setFromStrategiesList(other.strategies);
        random_strategy = other.random_strategy.copy();
    }

    /**
     * Copies all the strategies from the given list to the internal list
     */
    private void setFromStrategiesList(List<PlayerStrategy> strategies) {
		// Store a copy of the given strategies to avoid 'possible' external
        // modifications
        this.strategies = new ArrayList<>(strategies.size());
        for (PlayerStrategy ps : strategies) {
            this.strategies.add(ps.copy());
        }
    }

    /**
     * Returns the action that the majority of the other strategies would take.
     *
     * @return the action that the majority of the other strategies would take.
     */
    @Override
    public PlayerAction getNextAction() {

        int ndefections = 0;
        int ncooperations = 0;

        for (PlayerStrategy ps : this.strategies) {
            if (ps.getNextAction() == PlayerAction.COOPERATION) {
                ncooperations++;
            } else {
                ndefections++;
            }
        }

        if (ndefections > ncooperations) {
            return PlayerAction.DEFECTION;
        } else if (ndefections < ncooperations) {
            return PlayerAction.COOPERATION;
        }

        return random_strategy.getNextAction();
    }

    /**
     * Propagates the action to all the internal strategies
     *
     * @param pa Rival action
     */
    @Override
    public void notifyRivalAction(PlayerAction pa) {
        // Propagate action to all the strategies
        for (PlayerStrategy ps : this.strategies) {
            ps.notifyRivalAction(pa);
        }
    }

    /**
     * @return A deep copy of this instance
     */
    @Override
    public PlayerStrategy copy() {
        return new MajorityRuleStrategy(this);
    }

    // Used in tests
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final MajorityRuleStrategy other = (MajorityRuleStrategy) obj;
        return this.strategies.equals(other.strategies)
                && this.random_strategy.equals(other.random_strategy);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.strategies);
        hash = 47 * hash + Objects.hashCode(this.random_strategy);
        return hash;
    }
}
