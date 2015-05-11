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
    
    @Test
    public void getFirstTest(){     
        assertEquals(p.getFirst(), FIRST);
    }
    
    @Test
    public void getSecondTest(){
        assertEquals(p.getSecond(), SECOND);
    }
    
    @Test
    public void hashCodeTest(){
        Pair second = new Pair(FIRST, SECOND);
        
        assertEquals(p.hashCode(), second.hashCode());
    }
    
    @Test
    public void equalsTest(){
        Pair second = new Pair(FIRST, SECOND);
        
        assertTrue(p.equals(second));
    }
}