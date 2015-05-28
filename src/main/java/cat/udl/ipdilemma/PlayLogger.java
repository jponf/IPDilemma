package cat.udl.ipdilemma;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is responsible of logging the activity of
 * a play as more rounds are performed.
 */
public class PlayLogger implements Observer {

    StringBuilder log;
    int roundNum;

    public PlayLogger() {
        log = new StringBuilder();
    }

    public void initializeLog(UtilityMatrix utilityMatrix, Player playerA, Player playerB) {
        log.append("Utility Matrix -> {").append(utilityMatrix.toString()).append("}\n");
        log.append("Player A Strategy: ").append(playerA.getStrategyName()).append('\n');
        log.append("Player B Strategy: ").append(playerB.getStrategyName()).append("\n\n");

        roundNum = 0;
    }

    @Override
    public void update(Observable observable, Object data) {
        if (!(data instanceof RoundInfo)) {
            throw new IllegalArgumentException(
                    "The expected data is not a valid RoundInfo object.");
        }

        if (!(observable instanceof Play)) {
            throw new IllegalArgumentException("The observed instance is not a Play.");
        }

        Play play = (Play)observable;
        RoundInfo roundInfo = (RoundInfo)data;
        roundNum += 1;

        log.append("Round ").append(roundNum).append('\n');
        log.append('\t').append("Player A { action: ")
                .append(roundInfo.getPlayerAAction().toString()).append(", score: ")
                .append(roundInfo.getPlayerAScore()).append("}\n");
        log.append('\t').append("Player B { action: ")
                .append(roundInfo.getPlayerBAction().toString())
                .append(", score: ").append(roundInfo.getPlayerBScore()).append("}\n");

        if (!play.hasMoreRounds()) {
            print();
        }
    }

    public void print() {
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter("play_log.txt"));
            buf.write(log.toString());
            buf.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
