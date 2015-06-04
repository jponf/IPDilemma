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

    File file;
    PrintWriter outputFile;

    /**
     * Creates a new PlayLogger associated to the given Play.
     * @param play
     */
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
        int count = 0;

        do {
            count += 1;
            file = new File(generateFileName(count));
        } while (file.exists());      // Ensure the new file does not exists

        assert(file.createNewFile()); // If the while above is OK, there should be no problem

        return file;
    }

    public String getFileName(){
        return file.getName();
    }

    private String generateFileName(int count) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();

        return String.format("%s_%s_%02d.log", BASE_FILE_NAME, dateFormat.format(date), count);
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
