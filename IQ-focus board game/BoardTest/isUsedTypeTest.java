package comp1110.ass2.BoardTest;

import comp1110.ass2.PlayBoard;
import comp1110.ass2.piece.Piece;
import comp1110.ass2.piece.Pieces;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class isUsedTypeTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void ComplicatedCase() {
        PlayBoard playBoard = new PlayBoard();
        Piece[] pieces = (Pieces.getPieces("a100b130c711d011e212f001h601i523"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        assertTrue("The piece a332 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("a332"))
            , playBoard.isUsedTypePiece(Pieces.getPiece("a332")));
        assertTrue("The piece b022 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("b022"))
                , playBoard.isUsedTypePiece(Pieces.getPiece("b022")));
        assertFalse("The piece j332 hasn't been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("j332"))
                , playBoard.isUsedTypePiece(Pieces.getPiece("j332")));
    }

   @Test
   public void allUsed(){
       PlayBoard playBoard = new PlayBoard();
       Piece[] pieces = (Pieces.getPieces("a000b013c113d302e323f400g420h522i613j701"));
       for(Piece p:pieces){
           playBoard.putPiece(p);
       }
       assertTrue("The piece a332 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("a232"))
               , playBoard.isUsedTypePiece(Pieces.getPiece("a232")));
       assertTrue("The piece a332 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("b131"))
               , playBoard.isUsedTypePiece(Pieces.getPiece("b131")));
       assertTrue("The piece a332 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("i521"))
               , playBoard.isUsedTypePiece(Pieces.getPiece("i521")));
   }

    @Test
    public void simpleCase(){
        PlayBoard playBoard = new PlayBoard();
        playBoard.putPiece(Pieces.getPiece("a000"));
    assertTrue("The piece a332 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("a332"))
            , playBoard.isUsedTypePiece(Pieces.getPiece("a332")));

        playBoard.putPiece(Pieces.getPiece("c320"));
    assertFalse("The piece d602 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("d602"))
            , playBoard.isUsedTypePiece(Pieces.getPiece("d602")));
    assertFalse("The piece i513 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("i513"))
            , playBoard.isUsedTypePiece(Pieces.getPiece("i513")));
}

    @Test
    public void emptyBoard(){
        PlayBoard playBoard = new PlayBoard();
          assertFalse("The piece h601 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("h601"))
                  , playBoard.isUsedTypePiece(Pieces.getPiece("h601")));
          assertFalse("The piece i513 has been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("i513"))
                  , playBoard.isUsedTypePiece(Pieces.getPiece("i513")));
          assertFalse("The piece j332 hasn't been used but got"+ playBoard.isUsedTypePiece(Pieces.getPiece("j332"))
                  , playBoard.isUsedTypePiece(Pieces.getPiece("j332")));
      }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }
}
