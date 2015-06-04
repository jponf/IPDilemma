package cat.udl.ipdilemma;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class PlayLoggerTest {

    private static PlayLogger logger;
    private static Play play;

    @Before
    public void setUp() {
        UtilityMatrix utilityMatrix = new UtilityMatrix(4, 3, 2, 1);
        Player playerA = new Player(new CooperateAlwaysStrategy());
        Player playerB = new Player(new DefectAlwaysStrategy());
        int numberOfRounds = 5;


        play = new Play(numberOfRounds, playerA, playerB, utilityMatrix);
        logger = new PlayLogger(play);
        play.addObserver(logger);
    }

    @Test
    public void testLogFile() throws IOException {
        play.runAll();

        final File output   = new File (logger.getFileName());
        final File expected = new File ("src/test/resources/full_log.txt");

        Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
    }
}