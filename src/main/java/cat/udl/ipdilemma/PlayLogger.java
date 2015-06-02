package cat.udl.ipdilemma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is responsible of logging the activity of
 * a play as more rounds are performed.
 */
public class PlayLogger implements Observer {

    FileWriter fileWriter;
    PrintWriter outputFile;
    int roundNum;

    public PlayLogger() {
        try {
            File file = new File("play_log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            outputFile = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeLog(UtilityMatrix utilityMatrix, Player playerA, Player playerB) {
        outputFile.println(String.format("Utility Matrix -> {%s}", utilityMatrix.toString()));
        outputFile.println(String.format("Player A Strategy: %s", playerA.getStrategyName()));
        outputFile.println(String.format("Player B Strategy: %s", playerB.getStrategyName()));
        outputFile.println();

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

        Play play = (Play) observable;
        RoundInfo roundInfo = (RoundInfo) data;

        roundNum += 1;

        outputFile.println(String.format("Round %d", roundNum));
        outputFile.println(String.format("\tPlayer A { action: %s, score: %d}",
                roundInfo.getPlayerAAction().toString(),
                roundInfo.getPlayerAScore()));
        outputFile.println(String.format("\tPlayer B { action: %s, score: %d}",
                roundInfo.getPlayerBAction().toString(),
                roundInfo.getPlayerBScore()));

        if (!play.hasMoreRounds()) {
            closeFile();
        }
    }

    private boolean closeFile(){
        try {
            outputFile.close();
            fileWriter.close();
            return true;
        } catch (IOException e)  {
            e.printStackTrace();
            return false;
        }
    }
}
