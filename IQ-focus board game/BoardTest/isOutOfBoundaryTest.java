package comp1110.ass2.BoardTest;

import comp1110.ass2.PlayBoard;
import comp1110.ass2.piece.Pieces;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class isOutOfBoundaryTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Test
    public void notOutOfBoundary() {
    assertFalse("The piece a000 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("a001"))+"but expected False",
            PlayBoard.isOutOfBoundary(Pieces.getPiece("a001")));
    assertFalse("The piece b400 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("b400"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("b400")));
    assertFalse("The piece h522 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("h522"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("h522")));
    assertFalse("The piece j701 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("j701"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("j701")));

    }

    @Test
    public void outOfBoundary(){
        assertTrue("The piece f800 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("f800"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("f800")));
        assertTrue("The piece h730 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("h730"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("h730")));
        assertTrue("The piece j531 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("j531"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("j531")));
        assertTrue("The piece c720 is"+ PlayBoard.isOutOfBoundary(Pieces.getPiece("c720"))+"but expected False",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("c720")));

    }

    @Test
    public void leftCornerTest() {
        assertTrue("The piece f640 which cover the left corner got " + PlayBoard.isOutOfBoundary(Pieces.getPiece("f640")) + " but expected true",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("f640")));
        assertTrue("The piece f821 which cover the left corner got " + PlayBoard.isOutOfBoundary(Pieces.getPiece("f821")) + " but expected true",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("f821")));
    }


    @Test
    public void rightCornerTest(){
        assertTrue("The piece f040 which cover the right corner got "+ PlayBoard.isOutOfBoundary(Pieces.getPiece("f040"))+" but expected true",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("f040")));

        assertTrue("The piece c030 which cover the right corner got "+ PlayBoard.isOutOfBoundary(Pieces.getPiece("c030"))+" but expected true",
                PlayBoard.isOutOfBoundary(Pieces.getPiece("c030")));
    }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }

}