package cat.udl.ipdilemma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MajorityRuleStrategyTest {

    MajorityRuleStrategy strategy;

    /**
     * Configuration of the strategy instance used in the tests.
     *
     * It is configured so as two of the three internal strategies next action
     * is always DEFECTION, and the other is always COOPERATION.
     */
    @Before
    public void setUp() {
        PlayerStrategy moreUsedStrategy = new MoreUsedStrategy();
        moreUsedStrategy.notifyRivalAction(PlayerAction.DEFECTION);

        // With the following configuration two strategies return DEFECTION
        // and one COOPERATE
        List<PlayerStrategy> strategies = new ArrayList<>();
        strategies.add(new DefectAlwaysStrategy());
        strategies.add(moreUsedStrategy);
        strategies.add(new CooperateAlwaysStrategy());

        strategy = new MajorityRuleStrategy(strategies);
    }

    /**
     * Since 2/3 are defection the next action should be defection too.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * Since 2/3 are always defection the next action should be always
     * defection.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = strategy.getNextAction();
        pa = strategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    /**
     * After notifying the rival action "COOPERATION" twice, the internal
     * "more used" strategy will return COOPERATION, and hence the internal
     * strategies will now vote 2/3 for COOPERATION and it should then be
     * the next action.
     */
    @Test
    public void testNotifyRivalAction() {
        // If notifyRivaAction propagates well, two strategies returns
        // COOPERATION and one DEFECTION
        strategy.notifyRivalAction(PlayerAction.COOPERATION);
        strategy.notifyRivalAction(PlayerAction.COOPERATION);

        assertEquals(PlayerAction.COOPERATION, strategy.getNextAction());
    }

    /**
     * A copy of the instance is equals to the instance being copied.
     */
    @Test
    public void testCopy() {
        assertEquals(strategy, strategy.copy());
    }
}
