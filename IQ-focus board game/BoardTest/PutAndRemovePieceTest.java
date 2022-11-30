package comp1110.ass2.BoardTest;

import comp1110.ass2.PlayBoard;
import comp1110.ass2.Color;
import comp1110.ass2.piece.Piece;
import comp1110.ass2.piece.Pieces;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PutAndRemovePieceTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    PlayBoard playBoard = new PlayBoard();

    @Test
    public void putSinglePiece() {

        playBoard.putPiece(Pieces.getPiece("a001"));
        assertTrue("Color in board[1][0] is "+ playBoard.board[1][0]+" but expected RED", playBoard.board[1][0]== Color.RED);
        playBoard.removePiece(Pieces.getPiece("a001"));

        playBoard.putPiece(Pieces.getPiece("d302"));
        assertTrue("Color in board[0][3] is "+ playBoard.board[0][3]+" but expected BLUE", playBoard.board[0][3]==Color.BLUE);
        playBoard.removePiece(Pieces.getPiece("d302"));

        playBoard.putPiece(Pieces.getPiece("f601"));
        assertTrue("Color in board[0][6] is "+ playBoard.board[0][6]+" but expected WHITE", playBoard.board[0][6]==Color.WHITE);
        playBoard.removePiece(Pieces.getPiece("f601"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void putEmpty(){
        playBoard.putPiece(Pieces.getPiece(""));
        assertTrue("Color in board[4][3] should be null, but got "+ playBoard.board[4][3], playBoard.board[4][3]==null);
        assertTrue("Color in board[2][7] should be null, but got "+ playBoard.board[2][7], playBoard.board[2][7]==null);
        assertFalse("Color in board[4][5] should be null, but got "+ playBoard.board[4][5], playBoard.board[4][5]==Color.BLUE);
        assertFalse("Color in board[1][2] should be null, but got "+ playBoard.board[1][2], playBoard.board[1][2]==Color.RED);

    }

    @Test
    public void putWholePiece(){
        Piece[] pieces = (Pieces.getPieces("a100b130c711d011e212g402h601i523j332"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        assertTrue("Color in board[0][6] is "+ playBoard.board[0][6]+" but expected WHITE", playBoard.board[0][6]==Color.WHITE);
        assertTrue("Color in board[2][2] is "+ playBoard.board[2][2]+" but expected BLUE", playBoard.board[2][2]==Color.BLUE);
        assertTrue("Color in board[1][3] is "+ playBoard.board[1][3]+" but expected RED", playBoard.board[1][3]==Color.RED);
        assertTrue("Color in board[4][7] is "+ playBoard.board[4][7]+" but expected BLUE", playBoard.board[4][7]==Color.BLUE);
        for(Piece p:pieces){
            playBoard.removePiece(p);
        }
    }

    @Test
    public void removeWholePieces() {
        Piece[] pieces = (Pieces.getPieces("a611b103c430d513e201f001g030h400i333j701"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        for(Piece p:pieces){
            playBoard.removePiece(p);
        }
        assertTrue("Color in board[0][6] is "+ playBoard.board[0][6]+" but expected null", playBoard.board[0][6]==null);
        assertTrue("Color in board[2][2] is "+ playBoard.board[2][2]+" but expected null", playBoard.board[2][2]==null);
        assertTrue("Color in board[1][3] is "+ playBoard.board[1][3]+" but expected null", playBoard.board[1][3]==null);
        assertTrue("Color in board[4][7] is "+ playBoard.board[4][7]+" but expected null", playBoard.board[4][7]==null);
    }

    @Test
    public void removeSinglePieces() {
        Piece[] pieces = (Pieces.getPieces("a100b130c711d011e212f001g400h601i523j332"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        playBoard.removePiece(Pieces.getPiece("a100"));
        assertTrue("Color in board[0][1] is "+ playBoard.board[0][1]+" but expected null", playBoard.board[0][1]==null);
        assertTrue("Color in board[0][2] is "+ playBoard.board[0][2]+" but expected null", playBoard.board[0][2]==null);

        playBoard.removePiece(Pieces.getPiece("b130"));
        assertTrue("Color in board[4][1] is "+ playBoard.board[4][1]+" but expected null", playBoard.board[4][1]==null);
        assertTrue("Color in board[4][2] is "+ playBoard.board[4][2]+" but expected null", playBoard.board[4][2]==null);
    }

    @Test(expected = IllegalArgumentException.class)
        public void removeEmpty() {
            Piece[] pieces = (Pieces.getPieces("a611b103c430d513e201f001g030h400i333j701"));
            for (Piece p : pieces) {
                playBoard.putPiece(p);
            }
            playBoard.removePiece(Pieces.getPiece(" "));
        }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
        System.setErr(new PrintStream(this.errContent));
    }
}