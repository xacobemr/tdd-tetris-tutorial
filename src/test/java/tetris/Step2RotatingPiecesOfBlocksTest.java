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
public class Step2RotatingPiecesOfBlocksTest extends Assert {

  // Step 2: Stepping stone for rotation algorithms
  // - Remove the @Ignore annotation from this class
  // - See README for motivation
  // - Next step: RotatingTetrominoesTest


  private Piece piece;


  //public class A_piece_of_3x3_blocks {

  /**
   * Creates the piece.
   */
  @Before
  public void createPiece() {
    piece = new Piece("" 
          +
                    ".X.\n" 
          +
                    ".X.\n" 
          +
                    "...\n");
  }

  @Test
  public void consists_of_many_blocks() {
    assertEquals("" 
          +
                    ".X.\n" 
          +
                    ".X.\n" 
          +
                    "...\n", piece.toString());
  }

  @Test
  public void can_be_rotated_right() {
    piece = piece.rotateRight();
    assertEquals("" 
           +
                    "...\n" 
           +
                    ".XX\n" 
           +
                    "...\n", piece.toString());
  }

  @Test
  public void can_be_rotated_left() {
    piece = piece.rotateLeft();
    assertEquals("" 
           +
                    "...\n" 
           +
                    "XX.\n" 
           +
                    "...\n", piece.toString());
  }
  //}



  /** The piece 1. */
  //public class A_piece_of_5x5_blocks {
  private Piece piece1;
        
        
  /**
   * Creates the piece 1.
   */
  @Before
  public void createPiece1() {
    piece1 = new Piece("" 
           +
                    "..XXX\n" 
           +
                    "..XX.\n" 
           +
                    "..X..\n" 
           +
                    ".....\n" 
           +
                    ".....\n");
  }

  @Test
  public void consists_of_many_blocks1() {
    assertEquals("" 
           +
                    "..XXX\n" 
           +
                    "..XX.\n" 
           +
                    "..X..\n" 
           +
                    ".....\n" 
           +
                    ".....\n", piece1.toString());
  }

  @Test
  public void can_be_rotated_right1() {
    piece1 = piece1.rotateRight();
    assertEquals("" 
           +
                    ".....\n" 
           +
                    ".....\n" 
           +
                    "..XXX\n" 
           +
                    "...XX\n" 
           +
                    "....X\n", piece1.toString());
  }

  @Test
  public void can_be_rotated_left1() {
    piece1 = piece1.rotateLeft();
    assertEquals("" 
            +
                    "X....\n" 
            +
                    "XX...\n" 
            +
                    "XXX..\n" 
            +
                    ".....\n" 
            +
                    ".....\n", piece1.toString());
  }
  //}

}
