// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//@Ignore("contains no test")
@RunWith(NestedJUnit.class)
public class Step5MovingAFallingPieceTest extends Assert {

  // Step 5: It's your turn now
  // - Remove the @Ignore annotation from this class
  // - The test names have been provided, you just need to fill in the test body
  // - Next step: RotatingAFallingPieceTest

  // public class A_falling_piece{

  private final Board board = new Board(6, 8);

  @Before
  public void dropPiece() {
    board.drop(Tetromino.H_SHAPE);
  }

  
  // TODO: a falling piece can be moved left
  @Test
  public void a_falling_piece_can_be_moved_left() {

    board.move_Left();

    assertEquals("" + "...H....\n" + "..HHH...\n" + "...H....\n" 
        + "........\n" + "........\n" + "........\n",
        board.toString());
  }

  // TODO: a falling piece can be moved right
  @Test
  public void a_falling_piece_can_be_moved_right() {

    board.move_Right();

    assertEquals("" + ".....H..\n" + "....HHH.\n" + ".....H..\n" 
        + "........\n" + "........\n" + "........\n",
        board.toString());

  }

  // TODO: a falling piece can be moved down
  @Test
  public void a_falling_piece_can_ben_moved_down() {

    board.tick();

    assertEquals("" + "........\n" + "....H...\n" + "...HHH..\n" + "....H...\n" 
        + "........\n" + "........\n",
        board.toString());
  }

  // TODO: it will not move left over the board
  @Test
  public void it_will_not_move_left_over_the_board() {

    for (int i = 0; i <= 10; i++) {
      board.move_Left();
    }

    assertEquals("" + ".H......\n" + "HHH.....\n" + ".H......\n" + "........\n" 
        + "........\n" + "........\n",
        board.toString());

  }

  // TODO: it will not move right over the board
  @Test
  public void it_will_not_move_right_over_the_board() {

    for (int i = 0; i <= 10; i++) {
      board.move_Right();
    }

    assertEquals("" + "......H.\n" + ".....HHH\n" + "......H.\n" + "........\n" 
        + "........\n" + "........\n",
        board.toString());

  }

  // TODO: it will not move down over the board (will stop falling)
  @Test
  public void it_wil_not_move_over_the_board() {

    for (int i = 0; i <= 10; i++) {
      board.tick();
    }

    assertEquals("" + "........\n" + "........\n" + "........\n" + "....H...\n" 
        + "...HHH..\n" + "....H...\n",
        board.toString());

  }

  // }

  // public class It_cannot_be_moved{

  private final Board board1 = new Board(
      "" + "X......X\n" + "X......X\n" + "X......X\n" + "X......X\n" + "X......X\n" + "XXXXXXXX\n");

  @Before
  public void dropPiece1() {
    board1.drop(Tetromino.H_SHAPE);
  }

  // TODO: it cannot be moved left if another piece is in the way
  @Test
  public void it_cannot_be_moved_left_if_another_piece_is_in_the_way() {
    for (int i = 0; i <= 10; i++) {
      board1.move_Left();
    }

    assertEquals("" + "X.H....X\n" + "XHHH...X\n" + "X.H....X\n" 
        + "X......X\n" + "X......X\n" + "XXXXXXXX\n",
        board1.toString());
  }

  // TODO: it cannot be moved right if another piece is in the way
  @Test
  public void it_cannot_be_moved_right_if_another_piece_is_in_the_way() {
    for (int i = 0; i <= 10; i++) {
      board1.move_Right();
    }

    assertEquals("" + "X....H.X\n" + "X...HHHX\n" + "X....H.X\n" 
        + "X......X\n" + "X......X\n" + "XXXXXXXX\n",
        board1.toString());
  }

  // TODO: it cannot be moved down if another piece is in the way (will stop
  // falling)
  @Test
  public void it_cannot_be_moved_down_if_another_piece_is_in_the_way() {
    for (int i = 0; i <= 10; i++) {
      board1.move_Down();
    }

    assertEquals("" + "X......X\n" + "X......X\n" + "X...H..X\n" 
        + "X..HHH.X\n" + "X...H..X\n" + "XXXXXXXX\n",
        board1.toString());
  }

  // }
  // P.S. Take into consideration, that part of the piece's area may be empty
  // cells.
  // Only non-empty cells should take part in the collision checks.
}
