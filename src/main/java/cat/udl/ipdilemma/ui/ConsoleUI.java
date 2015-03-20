package cat.udl.ipdilemma.ui;

import cat.udl.ipdilemma.Play;
import cat.udl.ipdilemma.PlayBuilder;
import cat.udl.ipdilemma.Register;
import cat.udl.ipdilemma.RoundInfo;
import cat.udl.ipdilemma.exceptions.NonExistingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class ConsoleUI implements Observer {

	// Used to give format to user input
	private Scanner stdinscn;

	private static enum Player {

		PlayerA, PlayerB
	}

	/**
	 * Builds a new instance of ConsoleUI
	 */
	public ConsoleUI() {
		stdinscn = new Scanner(System.in);
	}

	/**
	 * Start the execution of the program, it will interact with the user
	 * through the terminal
	 */
	public void run() {
		Play play = buildPlay();

		System.out.println("Enter 'r' to execute a round or 'ra' to "
				+ "execute all the remaining rounds");

		while (play.hasMoreRounds()) {
			String input = stdinscn.next();
			switch (input) {
				case "r":
					play.runRound();
					break;
				case "ra":
					play.runAll();
					break;
				default:
					System.out.println("Unknown action");
					break;
			}
		}

		System.out.println("Game have finished");

	}

	/**
	 * This method is called by the Play to give information at the end of
	 * every round
	 * @param o
	 * @param arg 
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		if (arg.getClass() != RoundInfo.class) {
			System.err.println("Unexpected arg type: "
					+ arg.getClass().toString());
		} else {
			RoundInfo rinfo = (RoundInfo) arg;
			System.out.println("Round: " + rinfo.getRoundNumber());
			
			System.out.println("Player A chosed the action " + 
					rinfo.getPlayerAAction()
					+ ". His socore is: " + rinfo.getPlayerAScore());
			
			System.out.println("Player B chosed the action " + 
					rinfo.getPlayerBAction()
					+ ". His socore is: " + rinfo.getPlayerBScore());
		}
	}

	/***********/
	/* PRIVATE */
	/***********/
	private Play buildPlay() {
		PlayBuilder builder = new PlayBuilder();
		setPlayer(builder, Player.PlayerA);
		setPlayer(builder, Player.PlayerB);
		setPayoffMatrix(builder);
		setNumberOfRounds(builder);

		Play play = builder.create();
		play.addObserver(this);
		return play;
	}

	private void setPlayer(PlayBuilder builder, Player player) {
		boolean done = false;

		while (!done) {
			try {
				switch (player) {
					case PlayerA:
						System.out.println("Select the strategy for player A");
						builder.setPlayerAStrategy(askForPlayerStrategy());
						break;
					case PlayerB:
						System.out.println("Select the strategy for player B");
						builder.setPlayerBStrategy(askForPlayerStrategy());
						break;
				}
				done = true;

			} catch (NonExistingException ex) {
				ex.printStackTrace(System.err);
			}
		}
	}

	private void setPayoffMatrix(PlayBuilder builder) {
		boolean done = false;

		while (!done) {
			System.out.println("The following restrictions are necessary to "
					+ "have a valid prisoner's dilemma payoff matrix:");
			System.out.println("\tT > R > P > S");
			System.out.println("\tR > (T + S) / 2");
			System.out.println("");

			System.out.println("Input the (T)temptation's payoff:");
			int t = stdinscn.nextInt();
			System.out.println("Input the (R)reward's payoff:");
			int r = stdinscn.nextInt();
			System.out.println("Input the (P)punishment's payoff:");
			int p = stdinscn.nextInt();
			System.out.println("Input the (S)sucker's payoff:");
			int s = stdinscn.nextInt();

			try {
				builder.setUtilityMatrix(t, r, p, s);
				done = true;
			} catch (IllegalArgumentException ex) {
				System.out.println("The introduced values doesn't match some "
						+ "or all the mentioned restrictions");
			}
		}
	}

	private void setNumberOfRounds(PlayBuilder builder) {
		boolean done = false;

		while (!done) {
			System.out.println("Input the number of rounds to simulate");
			int nrounds = stdinscn.nextInt();

			try {			
				builder.setNumberOfRounds(nrounds);
				done = true;
			} catch (IllegalArgumentException ex) {
				System.out.println("The value have to be greater than 0");
			}			
		}
	}

	private String askForPlayerStrategy() {

		List<String> strategies_name = new ArrayList<>(
				Register.getRegister().getRegisteredNames());

		for (int i = 0; i < strategies_name.size(); i++) {
			System.out.println((i + 1) + " - " + strategies_name.get(i));
		}

		System.out.println("Chose the strategy number[1-"
				+ strategies_name.size() + "]:");


		int selected_value = 0;

		do {
			selected_value = stdinscn.nextInt();
			if (selected_value < 1 || selected_value > strategies_name.size()) {
				System.out.println("Value must be into the specified range");
			}
		} while (selected_value < 1 || selected_value > strategies_name.size());

		return strategies_name.get(selected_value - 1);
	}
}
