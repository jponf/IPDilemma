package cat.udl.ipdilemma;

import java.util.Observable;
import java.util.Observer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josep
 */
public class PlayObserverTest implements Observer {

	Play play;
	int expected_A_score;
	int expected_B_score;
	int expected_round;
	
	
	@Before
	public void setUp() {
		play = new Play(2,
				new Player(new DefectAlwaysStrategy()),
				new Player(new CooperateAlwaysStrategy()),
				new UtilityMatrix(3, 2, 1, 0));
		play.addObserver(this);
	}

	/**
	 * Execute a round that should call the update method
	 */
	@Test
	public void observerUpdateOnceTest() {
		// Set up expected valus on update
		expected_A_score = 3;
		expected_B_score = 0;
		expected_round = 1;
		play.runRound();
	}
	
	@Test
	public void observerUpdateTwiceTest() {
		// Set up expected valus on update
		expected_A_score = 3;
		expected_B_score = 0;
		expected_round = 1;
		play.runRound();
		
		expected_A_score = 6;
		expected_B_score = 0;
		expected_round = 2;
		play.runRound();
	}

	@Override
	public void update(Observable o, Object arg) {
		assertEquals("Observable must be a Play instance", 
				Play.class, o.getClass());
		assertEquals("Argument must be a RoundInfo instance",
				RoundInfo.class, arg.getClass());

		RoundInfo rinfo = (RoundInfo) arg;
		
		assertEquals("Player A action must be DEFECTION",
				PlayerAction.DEFECTION, rinfo.getPlayerAAction());
		assertEquals("Player B action must be COOPERATION",
				PlayerAction.COOPERATION, rinfo.getPlayerBAction());
		
		assertEquals(expected_A_score, rinfo.getPlayerAScore());
		assertEquals(expected_B_score, rinfo.getPlayerBScore());

		assertEquals(expected_round, rinfo.getRoundNumber());
	}
}
