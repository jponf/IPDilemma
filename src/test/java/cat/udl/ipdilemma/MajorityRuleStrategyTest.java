package cat.udl.ipdilemma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MajorityRuleStrategyTest {

    MajorityRuleStrategy strategy;

    @Before
    public void setUp() {
        PlayerStrategy more_used_strategy = new MoreUsedStrategy();
        more_used_strategy.notifyRivalAction(PlayerAction.DEFECTION);

        // With the following configuration two strategies retunrs DEFECTION
        // and one COOPERATE
        List<PlayerStrategy> strategies = new ArrayList<>();
        strategies.add(new DefectAlwaysStrategy());
        strategies.add(more_used_strategy);
        strategies.add(new CooperateAlwaysStrategy());

        strategy = new MajorityRuleStrategy(strategies);

    }

    /**
     * Basic Test: Testing if our strategy will betray its partner once (2 DEFECTION, 1 COOPERATE).
     */
    @Test
    public void testGetNextActionOnce() {
        assertEquals(PlayerAction.DEFECTION, strategy.getNextAction());
    }

    /**
     * Basic Test: Testing if our strategy will betray its partner twice (2 DEFECTION, 1 COOPERATE).
     */
    @Test
    public void testGetNextActionMoreThanOnce() {
        PlayerAction pa = strategy.getNextAction();
        pa = strategy.getNextAction();
        assertEquals(PlayerAction.DEFECTION, pa);
    }

    /**
     * Basic Test: Testing if our strategy will be able to cooperate if he has a nice partner (1DEFECTION, 2 COOPERATE).
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
     * Basic Test: Testing if our strategy will be able to give us a copy of itself.
     */
    @Test
    public void testCopy() {
        assertEquals(strategy, strategy.copy());
    }
}
