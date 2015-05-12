package cat.udl.ipdilemma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    private static class DummyStrategy implements PlayerStrategy {

        boolean notified = false;
                
        @Override
        public PlayerAction getNextAction() {
            if(notified)
                return PlayerAction.DEFECTION;
            return PlayerAction.COOPERATION;
        }

        @Override
        public void notifyRivalAction(PlayerAction pa) {
            notified = true;
        }

        @Override
        public PlayerStrategy copy() {
            throw new UnsupportedOperationException("Not used");
        }
        
    }
    
    Player player;
    
    @Before
    public void setUp() {
        player = new Player(new DummyStrategy());
    }

    /**
     * Basic Test: Test of nextAction method, of class Player.
     * Reason: Test the result of netxAction method, of class Player.
     */
    @Test
    public void testPerformAction() {
        assertEquals(PlayerAction.COOPERATION, player.nextAction());
    }

    /**
     * Basic Test: Test of notifyRivalAction method, of class Player.
     * Reason: Test the result of notifyRivalAction method, of class Player.
     */
    @Test
    public void testNotifyRivalAction() {
        player.notifyRivalAction(PlayerAction.DEFECTION);
        assertEquals(PlayerAction.DEFECTION, player.nextAction());
    }
}