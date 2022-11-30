package comp1110.ass2;

import comp1110.ass2.piece.Pieces;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class isLegalToPutTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Test
    public void LegalToPut(){
        PlayBoard playBoard = new PlayBoard();
        boolean r1 = PlayBoard.isOutOfBoundary(Pieces.getPiece("b222"))
                & playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b222"))
                & playBoard.isUsedTypePiece(Pieces.getPiece("b222"));
        assertFalse("The piece b222 is"+ r1 +"but expected False",
                r1);
        boolean r2 = PlayBoard.isOutOfBoundary(Pieces.getPiece("b501"))
                & playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b501"))
                & playBoard.isUsedTypePiece(Pieces.getPiece("b501"));
        assertFalse("The piece b501 is"+ r2 +"but expected False",
                r2);
    }
    @Test
    public void NotLegalToPut(){
        PlayBoard playBoard = new PlayBoard();
        boolean r1 = !(PlayBoard.isOutOfBoundary(Pieces.getPiece("c333"))
                || playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("c333"))
                || playBoard.isUsedTypePiece(Pieces.getPiece("c333")));
        assertFalse("The piece c333 is"+ r1 +"but expected False",
                r1);
        boolean r2 = !(PlayBoard.isOutOfBoundary(Pieces.getPiece("b541"))
                || playBoard.isCrashedWithCurrentPieces(Pieces.getPiece("b541"))
                || playBoard.isUsedTypePiece(Pieces.getPiece("b541")));
        assertFalse("The piece b541 is"+ r2 +"but expected False",
                r2);
}}
