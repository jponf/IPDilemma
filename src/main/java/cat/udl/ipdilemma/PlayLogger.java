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

    public PlayLogger(Play play) {
        try {
            fileWriter = new FileWriter(generateFile());
            outputFile = new PrintWriter(fileWriter);

            outputFile.print(play.getInfoGame());
            outputFile.println();
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

    @Override
    public void update(Observable observable, Object data) {
        if(areValidateParameters(observable,data))
        {
            Play play = (Play) observable;
            RoundInfo roundInfo = (RoundInfo) data;

            outputFile.print(roundInfo.toString());

            if (!play.hasMoreRounds()) {
                closeFile();
            }
        }
    }

    boolean areValidateParameters(Observable observable, Object data)
    {
        if (!(data instanceof RoundInfo)) {
            throw new IllegalArgumentException(
                    "The expected data is not a valid RoundInfo object.");
        }else if (!(observable instanceof Play)) {
            throw new IllegalArgumentException("The observed instance is not a Play.");
        }else{
            return true;
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
