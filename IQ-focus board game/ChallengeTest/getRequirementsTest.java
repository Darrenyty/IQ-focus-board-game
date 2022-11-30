package comp1110.ass2.ChallengeTest;

import comp1110.ass2.challenge.CenterNineColorChallenge;
import comp1110.ass2.challenge.Challenge;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static comp1110.ass2.Color.*;
import static org.junit.Assert.*;

public class getRequirementsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Test
    public void normalRequirements() {
        Challenge challenge = new CenterNineColorChallenge("RRRBWBBRB");

        Challenge.ColorRequirement c1 = new Challenge.ColorRequirement(1,3, RED);
        assertTrue("The ColorRequirement in [1][3] should be RED, but got"+c1+" "+challenge.getColorRequirements().get(0),
                challenge.getColorRequirements().get(0).equals(c1));

        Challenge.ColorRequirement c2 = new Challenge.ColorRequirement(2,3, BLUE);
        assertTrue("The ColorRequirement in [2][3] should be BLUE, but got"+c2+" "+challenge.getColorRequirements().get(3),
                challenge.getColorRequirements().get(3).equals(c2));

        Challenge.ColorRequirement c3 = new Challenge.ColorRequirement(2,4, WHITE);
        assertTrue("The ColorRequirement in [2][4] should be WHITE, but got"+c3+" "+challenge.getColorRequirements().get(4),
                challenge.getColorRequirements().get(4).equals(c3));

        Challenge.ColorRequirement c4 = new Challenge.ColorRequirement(3,3, BLUE);
        assertTrue("The ColorRequirement in [3][3] should be BLUE, but got"+c4+" "+challenge.getColorRequirements().get(6),
                challenge.getColorRequirements().get(6).equals(c4));

        Challenge.ColorRequirement c5 = new Challenge.ColorRequirement(3,3, RED);
        assertFalse("The ColorRequirement in [3][3] should be BLUE, but got"+c5+" "+challenge.getColorRequirements().get(6),
                challenge.getColorRequirements().get(6).equals(c5));

        Challenge.ColorRequirement c6 = new Challenge.ColorRequirement(2,4, WHITE);
        assertFalse("The ColorRequirement in [1][4] should be WHITE, but got"+c6+" "+challenge.getColorRequirements().get(1),
                challenge.getColorRequirements().get(1).equals(c6));

    }

    @Test
    public void allSameColors(){
        Challenge challenge = new CenterNineColorChallenge("WWWWWWWWW");
        int index = 0;
        for(int i=3;i<4;i++){
            Challenge.ColorRequirement c = new Challenge.ColorRequirement(i/3,i%3+3, WHITE);
            assertTrue("The ColorRequirement should be WHITE, but got"+c+" "+challenge.getColorRequirements().get(index),
                    challenge.getColorRequirements().get(index).equals(c));
            index++;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotNineArgument(){
        Challenge challenge = new CenterNineColorChallenge("WRBW");

        Challenge challenge1 = new CenterNineColorChallenge("RWRBWG");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testException(){
        Challenge challenge = new CenterNineColorChallenge("YTY");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyColorString(){
        Challenge challenge = new CenterNineColorChallenge(" ");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }
}