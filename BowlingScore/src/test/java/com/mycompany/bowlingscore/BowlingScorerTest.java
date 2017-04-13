package com.mycompany.bowlingscore;

import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingScorerTest {
    
    @Test
    public void testTotalScore() {
        BowlingScorer instance = new BowlingScorer();
        assertEquals(300, instance.totalScore("xxxxxxxxxx"));
        assertEquals(90, instance.totalScore("9-9-9-9-9-9-9-9-9-9-"));
        assertEquals(150, instance.totalScore("5/5/5/5/5/5/5/5/5/5/5"));
        assertEquals(167, instance.totalScore("x7/9-x-88/-6xxx81"));
    }
    
}
