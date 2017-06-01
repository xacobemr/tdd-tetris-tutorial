package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(NestedJUnit.class)
public class Step8KillingAllMutantsTest extends Assert {

  private final Board board = new Board(6, 8);

  @Before
  public void dropPiece() {
    board.drop(Tetromino.H_SHAPE);
  }

  // TODO: it will not move down over the board (will stop falling)
  @Test
  public void it_wil_not_move_over_the_board() {

    for (int i = 0; i <= 10; i++) {
      board.move_Down();
    }

    assertEquals("" + "........\n" + "........\n" + "........\n" 
        + "....H...\n" + "...HHH..\n" + "....H...\n",
        board.toString());

  }

}
