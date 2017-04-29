// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

/**
 * @author Esko Luontola
 */
//@Ignore("contains no test")
@RunWith(NestedJUnit.class)
public class Step4_FallingPiecesTest extends Assert {

    // Step 4: Safe steps
    // - Remove the @Ignore annotation from this class
    // - See the README for how to proceed with this refactoring in safe steps
    // - Next step: MovingAFallingPieceTest


    private final Board board = new Board(6, 8);


    //public class When_a_piece_is_dropped {

        @Before
        public void dropPiece() {
            board.drop(Tetromino.T_SHAPE);
        }

        @Test
        public void it_starts_from_top_middle() {
            assertEquals("" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        }
   // }



    //public class When_a_piece_reaches_the_bottom {
        private final Board board1 = new Board(6, 8);
        
        @Before
        public void fallToLastRow() {
            board1.drop(Tetromino.T_SHAPE);
            board1.tick();
            board1.tick();
            board1.tick();
            board1.tick();
        }

        @Test
        public void it_is_still_falling_on_the_last_row() {
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board1.toString());
            assertTrue(board1.hasFalling());
        }

        @Test
        public void it_stops_when_it_hits_the_bottom() {
            board1.tick();
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board1.toString());
            assertFalse(board1.hasFalling());
        }
    //}



    //public class When_a_piece_lands_on_another_piece {
        private final Board board2 = new Board(6, 8);
        
        @Before
        public void landOnAnother() {
            board2.drop(Tetromino.T_SHAPE);
            board2.tick();
            board2.tick();
            board2.tick();
            board2.tick();
            board2.tick();
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board2.toString());
            assertFalse(board2.hasFalling());

            board2.drop(Tetromino.T_SHAPE);
            board2.tick();
            board2.tick();
        }

        @Test
        public void it_is_still_falling_right_above_the_other_piece() {
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board2.toString());
            assertTrue(board2.hasFalling());
        }

        @Test
        public void it_stops_when_it_hits_the_other_piece() {
            board2.tick();
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board2.toString());
            assertFalse(board2.hasFalling());
        }
    //}

}
