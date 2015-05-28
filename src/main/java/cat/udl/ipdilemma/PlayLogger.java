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

    PlayLogger() {
        log = new StringBuilder();
    }

    public void initializeLog(UtilityMatrix u, Player pa, Player pb) {
        log.append("Utility Matrix:").append('\n').append(u.toString()).append('\n');
        log.append("Player A: ").append(pa.getClass().getName()).append('\n');
        log.append("Player B: ").append(pb.getClass().getName()).append('\n');

        roundNum = 0;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (!(o instanceof RoundInfo)) {
            throw new IllegalArgumentException(
                    "The expected data is not a valid RoundInfo object.");
        }

        RoundInfo ri = (RoundInfo)o;

        log.append("Round ").append(roundNum).append('\n');
        log.append('\t').append("Player A { action: ").append(ri.getPlayerAAction().toString())
                .append(", score: ").append(ri.getPlayerAScore()).append("}\n");
        log.append('\t').append("Player B { action: ").append(ri.getPlayerBAction().toString())
                .append(", score: ").append(ri.getPlayerBScore()).append("}\n");
    }

    public void print() throws IOException {
        BufferedWriter b = new BufferedWriter(new FileWriter("play_log.txt"));
        b.write(log.toString());
    }
}
