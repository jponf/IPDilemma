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
    private static final String BASE_FILE_NAME = "PlayLog";
    private static int count = 0;

    File file;
    PrintWriter outputFile;

    public PlayLogger(Play play) {
        try {
            initializeFile();
            outputFile = new PrintWriter(new FileWriter(file));

            outputFile.print(play.getInfoGame());
            outputFile.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File initializeFile() throws IOException {
        do {
            file = new File(generateFileName());
        } while (file.exists()); // Ensure the new file does not exists

        file.createNewFile();

        return file;
    }

    public String getFileName(){
        return file.getName();
    }

    private String generateFileName() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();

        PlayLogger.count += 1;

        return String.format("%s_%02d_%s.log", BASE_FILE_NAME, PlayLogger.count, dateFormat.format(date));
    }

    @Override
    public void update(Observable observable, Object data) {
        if (areValidUpdateParameters(observable, data)) {
            Play play = (Play) observable;
            RoundInfo roundInfo = (RoundInfo) data;

            outputFile.print(roundInfo.toString());

            if (!play.hasMoreRounds()) {
                closeFile();
            }
        }
    }

    private boolean areValidUpdateParameters(Observable observable, Object data)
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

    private void closeFile(){
        outputFile.close();
    }
}
