package cat.udl.ipdilemma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is responsible of logging the activity of
 * a play as more rounds are performed.
 */
public class PlayLogger implements Observer {
    private static int count = 0;

    File filename;
    FileWriter fileWriter;
    PrintWriter outputFile;
    int roundNum;

    public PlayLogger() {
        try {
            fileWriter = new FileWriter(generateFile());
            outputFile = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File generateFile() throws IOException {
        filename = new File(generateFileName());
        filename.createNewFile();
        return filename;
    }

    public String getFileName(){
        return filename.getName();
    }

    private String generateFileName()
    {
        String result = "PlayLog_";

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();

        PlayLogger.count += 1;
        if(PlayLogger.count<10)
            result += '0';
        result += String.format("%d_%s.log",PlayLogger.count,dateFormat.format(date));
        return result;
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
