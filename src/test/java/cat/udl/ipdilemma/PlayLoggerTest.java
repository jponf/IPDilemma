package cat.udl.ipdilemma;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 *
 */
public class PlayLoggerTest {

    @Before
    public void setUp() {
        PlayBuilder pbuilder = new PlayBuilder();
        pbuilder.setUtilityMatrix(4, 3, 2, 1);
        pbuilder.setNumberOfRounds(5);
        pbuilder.setPlayerAStrategy(new CooperateAlwaysStrategy());
        pbuilder.setPlayerBStrategy(new DefectAlwaysStrategy());
        pbuilder.enableLogging();

        pbuilder.create().runAll();
    }

    @Test
    public void testLogFile() throws IOException {


        final File expected = new File (PlayLoggerTest.class.getResource(
                "/full_log.txt").getFile());
        final File output = new File ("play_log.txt");

        Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
    }
}