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
     * Basic Test: Since 2/3 are defection the next action should be defection.
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * Basic Test: Since 2/3 are always defection the next action should be
     *             always defection.
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = strategy.getNextAction();
        pa = strategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    /**
     * Basic Test: Testing if our strategy will be cooperate if he has a nice
     *             partner (1DEFECTION, 2 COOPERATE).
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
     * Basic Test: Testing if our strategy will give us a correct copy of
     *             itself.
     */
    @Test
    public void testEquals() {
        assertTrue(strategy.equals(strategy.copy()));
    }

    /**
     * Basic Test: Testing if a copy will return the same hash code as the
     *             as the original instance.
     */
    @Test
    public void testHashcode() {
        assertEquals(strategy.hashCode(), strategy.copy().hashCode());
    }

    /**
     * Basic Test: Testing if our strategy will return  a correct copy of
     *             itself.
     */
    @Test
    public void testCopy() {
        assertEquals(strategy, strategy.copy());
    }
}
