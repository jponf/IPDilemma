package cat.udl.ipdilemma;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PairTest {
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private Pair p;
    
    @Before
    public void init(){
        p = new Pair(FIRST, SECOND);
    }

    /**
     * Basic Test: Testing if the first element will be saved as first element.
     */
    @Test
    public void getFirstTest(){     
        assertEquals(p.getFirst(), FIRST);
    }

    /**
     * Basic Test: Testing if the second element will be saved as second element.
     */
    @Test
    public void getSecondTest(){
        assertEquals(p.getSecond(), SECOND);
    }


    @Test
    public void hashCodeTest(){
        Pair second = new Pair(FIRST, SECOND);
        
        assertEquals(p.hashCode(), second.hashCode());
    }

    /**
     * Basic Test: Testing if it's able to compare a pair of elements
     */
    @Test
    public void equalsTest(){
        Pair second = new Pair(FIRST, SECOND);
        
        assertTrue(p.equals(second));
    }
}