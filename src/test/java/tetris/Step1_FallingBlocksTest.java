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
@RunWith(NestedJUnit.class)
public class Step1_FallingBlocksTest extends Assert {

    // Step 1: Starting small
    // - See the README for motivation
    // - Next step: RotatingPiecesOfBlocksTest

    private final Board board = new Board(3, 3);


    //public class A_new_board {

        @Test
        public void is_empty() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

        @Test
        public void has_no_falling_blocks() {
            assertFalse(board.hasFalling());
        }
    //}


    //public class When_a_block_is_dropped {
        private final Board board1 = new Board(3, 3);
        
        @Before
        public void dropBlock() {
            board1.drop(new Block('X'));
        }

        @Test
        public void the_block_is_falling() {
            assertTrue(board1.hasFalling());
        }

        @Test
        public void it_starts_from_the_top_middle() {
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board1.toString());
        }

        @Test
        public void it_moves_down_one_row_per_tick() {
            board1.tick();
            assertEquals("" +
                    "...\n" +
                    ".X.\n" +
                    "...\n", board1.toString());
        }

        @Test
        public void at_most_one_block_may_be_falling_at_a_time() {
            MyAsserts.assertThrows(IllegalStateException.class, "already falling",
                    () -> board1.drop(new Block('Y')));
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board1.toString());
        }
    //}



    //public class When_a_block_reaches_the_bottom {
        private final Board board2 = new Board(3, 3);
        
        @Before
        public void fallToLastRow() {
            board2.drop(new Block('X'));
            board2.tick();
            board2.tick();
        }

        @Test
        public void it_is_still_falling_on_the_last_row() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board2.toString());
            assertTrue("the player should still be able to move the block", board2.hasFalling());
        }

        @Test
        public void it_stops_when_it_hits_the_bottom() {
            board2.tick();
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board2.toString());
            assertFalse("the block should stop moving", board2.hasFalling());
        }
    //}



    //public class When_a_block_lands_on_another_block {
        private final Board board3 = new Board(3, 3);
        
        @Before
        public void landOnAnother() {
            board3.drop(new Block('X'));
            board3.tick();
            board3.tick();
            board3.tick();
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board3.toString());
            assertFalse(board3.hasFalling());

            board3.drop(new Block('Y'));
            board3.tick();
        }

        @Test
        public void it_is_still_falling_right_above_the_other_block() {
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board3.toString());
            assertTrue("the player should still be able to avoid landing on the other block", board3.hasFalling());
        }

        @Test
        public void it_stops_when_it_hits_the_other_block() {
            board3.tick();
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board3.toString());
            assertFalse("the block should stop moving when it lands on the other block", board3.hasFalling());
        }
    //}

}