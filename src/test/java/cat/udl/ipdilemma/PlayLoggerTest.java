package cat.udl.ipdilemma;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 *
 */
public class PlayLoggerTest {
    private static final File dir = new File("tmp");

    @Before
    public void setUp()
    {

    }

    @Test
    public void testHeaders()
    {
        final File expected = new File (PlayLoggerTest.class.getResource(
                "/test/resources/header.txt").getFile());
        final File output   = new File ("");

        Assert.assertEquals(expected, output);
    }

    @Test
    public void testFiles()
    {

    }

}