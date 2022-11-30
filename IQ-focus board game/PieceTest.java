package comp1110.ass2;

import comp1110.ass2.piece.Piece;
import comp1110.ass2.piece.PieceA;
import comp1110.ass2.piece.PieceB;
import comp1110.ass2.piece.Pieces;
import org.junit.Test;

import java.util.Arrays;

import static comp1110.ass2.Color.*;
import static org.junit.Assert.*;

/**
 * The test is majorly focus on the activity of piece. Not about the string form of the piece.
 */
public class PieceTest {

	@Test
	public void testCreateOne() {
		Piece p = Pieces.getPiece("a000");
		assertTrue("it should be a kind of PieceA, but we have a class " + p.getClass().getSimpleName(), p instanceof PieceA);
		assertFalse("it shouldn't as row 1, but it is.", p.getRow() == 1);
		assertEquals("it should at column 0, but it is not, it is at " + p.getColumn(), 0, p.getColumn());
		assertNotEquals("it shouldn't head to 2, but it is", 2, p.getOrientation());
		assertArrayEquals("the first row of the piece pattern should be GREEN WHITE RED NULL, but we get" + Arrays.toString(p.getPattern()[0]),
				new Color[]{GREEN, WHITE, RED, null}, p.getPattern()[0]);
		assertNull("the first thing in second column piece pattern should be null, but we get " + p.getPattern()[1][0], p.getPattern()[1][0]);
		assertNotNull("the second thing in second column piece pattern should not be null, but we get null", p.getPattern()[1][1]);
		assertSame("two red color is the different position of the pattern is same, but the red at (0,2) and (1,1) is not the same",
				p.getPattern()[0][2], p.getPattern()[1][1]);
		Piece p2 = Pieces.getPiece("a000");
		assertNotSame("two pieces with same character should not be the same object, but they become the same one", p, p2);
	}

	@Test
	public void testCreateAll() {
		Piece[] pieces = Pieces.getPieces("b013a000c113d302e323f400g420h522i613j701");
		assertTrue("the first one is kind of PieceB, but we have type " +pieces[0].getClass().getSimpleName(), pieces[0] instanceof PieceB);
		Arrays.sort(pieces);
		assertTrue("the first one is kind of PieceA, but we get type " + pieces[0].getClass().getSimpleName(), pieces[0] instanceof PieceA);
		assertEquals("the length of the pieces should be 10, but we get + "  + pieces.length, 10, pieces.length);
	}
}
