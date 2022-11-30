package comp1110.ass2.BoardTest;

import comp1110.ass2.PlayBoard;
import comp1110.ass2.piece.Piece;
import comp1110.ass2.piece.Pieces;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class isCrashedWithCurrentPiecesTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(700);

    @Test
    public void isSingleCrashedWithCurrentPieces() {
        PlayBoard playBoard = new PlayBoard();
        playBoard.putPiece(Pieces.getPiece("a000"));

        assertTrue("The piece b101 is crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b101"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b101")));
        assertTrue("The piece c101 is crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("c101"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("c101")));

        playBoard.putPiece(Pieces.getPiece("h601"));

        assertTrue("The piece b601 is crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b601"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b601")));
        assertTrue("The piece d600 is crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("d600"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("d600")));
    }

    public boolean testPieces(Piece[] pieces, PlayBoard playBoard){
        for(Piece p:pieces){
            if(playBoard.isCrashedWithCurrentPieces(p)){
                return true;
            }
            else{
                playBoard.putPiece(p);
            }
        }
    return false;
    }
    @Test
    public void complicatedCrash(){
        PlayBoard playBoard = new PlayBoard();
        Piece[] pieces = (Pieces.getPieces("a000b013"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        Piece[] putPieces =Pieces.getPieces("d302e323f400g420h522");
        Piece[] putPieces1 = Pieces.getPieces("d302c300f400g420h522");
        assertFalse("Put the pieces should not be crash with current board,but get True",testPieces(putPieces, playBoard));
        assertTrue("Put the pieces should be crash with current board,but get False",testPieces(putPieces1, playBoard));
    }


    @Test
    public void isWholeCrashedWithCurrentPieces(){
        PlayBoard playBoard = new PlayBoard();

        Piece[] pieces = (Pieces.getPieces("a000b013d302e323f400g420h522"));
        for(Piece p:pieces){
            playBoard.putPiece(p);
        }
        assertFalse("The piece j701 isn't crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("j701"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("j701")));
        assertFalse("The piece i613 isn't crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("i613"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("i613")));
    }

    @Test
    public void emptyBoardTest(){
        PlayBoard playBoard = new PlayBoard();
        assertFalse("The piece j401 isn't crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("j401"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("j401")));
        assertFalse("The piece a201 isn't crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("a201"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("a201")));
        assertFalse("The piece c221 isn't crashed with current pieces but got "+ playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("d221"))
                , playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("d221")));

    }

}