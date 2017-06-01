//Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
//You may use and modify this source code freely for personal non-commercial use.
//This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(NestedJUnit.class)
public class Step3RotatingTetrominoesTest extends Assert {

  // Step 3: The actual rotation algorithms
  // - Remove the @Ignore annotation from this class
  // - See README for how "Tetromino" is different from "Piece"
  // - Next step: FallingPiecesTest

  private Tetromino shape;

  //public class All_shape_instances {

  @Before
  public void createAnyShape() {
    shape = Tetromino.T_SHAPE;
  }

  @Test
  public void are_immutable() {
    String original = shape.toString();
    shape.rotateRight();
    assertEquals(original, shape.toString());
    shape.rotateLeft();
    assertEquals(original, shape.toString());
  }
  //}


  //public class The_T_shape {

  @Before
  public void createTShape() {
    shape = Tetromino.T_SHAPE;
  }

  @Test
  public void is_shaped_like_T() {
    assertEquals("" 
          +
                 ".T.\n" 
          +
                 "TTT\n" 
          +
                 "...\n", shape.toString());
  }

  @Test
  public void can_be_rotated_right_3_times() {
    shape = shape.rotateRight();
    assertEquals("" 
          +
                ".T.\n" 
          +
                ".TT\n" 
          +
                ".T.\n", shape.toString());
    shape = shape.rotateRight();
    assertEquals("" 
          +
                "...\n" 
          +
                "TTT\n" 
          +
                ".T.\n", shape.toString());
    shape = shape.rotateRight();
    assertEquals("" 
          +
                ".T.\n" 
          +
                "TT.\n" 
          +
                ".T.\n", shape.toString());
  }

  @Test
  public void can_be_rotated_left_3_times() {
    shape = shape.rotateLeft();
    assertEquals("" 
          +
                ".T.\n" 
          +
                "TT.\n" 
          +
                ".T.\n", shape.toString());
    shape = shape.rotateLeft();
    assertEquals("" 
          +
                "...\n" 
          +
                "TTT\n" 
          +
                ".T.\n", shape.toString());
    shape = shape.rotateLeft();
    assertEquals("" 
          +
                ".T.\n" 
          +
                ".TT\n" 
          +
                ".T.\n", shape.toString());
  }

  @Test
  public void rotating_it_4_times_will_go_back_to_the_original_shape() {
    String originalShape = shape.toString();
    shape = shape.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shape.toString());
    shape = shape.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shape.toString());
  }
  //}



  //public class The_I_shape {
  private Tetromino shapeI;
    
  @Before
  public void createIShape() {
    shapeI = Tetromino.I_SHAPE;
  }

  @Test
  public void is_shaped_like_I() {
    assertEquals("" 
          +
                "....\n" 
          +
                "IIII\n" 
          +
                "....\n" 
          +
                "....\n", shapeI.toString());
  }

  @Test
  public void can_be_rotated_right_four_timesI() {
    shapeI = shapeI.rotateRight();
    assertEquals("" 
          +
               "..I.\n" 
          +
               "..I.\n" 
          +
               "..I.\n" 
          +
               "..I.\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" 
          +
               "....\n" 
          +
               "....\n" 
          +
               "IIII\n" 
          +
               "....\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" 
          +
               ".I..\n" 
          +
               ".I..\n" 
          +
               ".I..\n" 
          +
               ".I..\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" 
          +
               "....\n" 
          +
               "IIII\n" 
          +
               "....\n" 
          +
               "....\n", shapeI.toString());
  }

  @Test
  public void can_be_rotated_left_four_timesI() {
    shapeI = shapeI.rotateLeft();
    assertEquals("" 
           +
               ".I..\n" 
           +
               ".I..\n" 
           +
               ".I..\n" 
           +
               ".I..\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" 
           +
               "....\n" 
           +
               "....\n" 
           +
               "IIII\n" 
           +
               "....\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" 
           +
               "..I.\n" 
           +
               "..I.\n" 
           +
               "..I.\n" 
           +
               "..I.\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" 
           +
               "....\n" 
           +
               "IIII\n" 
           +
               "....\n" 
           +
               "....\n", shapeI.toString());
  }

  @Test
  public void rotating_it_four_times_will_get_back_to_the_original_shapeI() {
    String originalShape = shapeI.toString();
    shapeI = shapeI.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shapeI.toString());
    shapeI = shapeI.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shapeI.toString());
  }

  @Test
  public void rotating_it_twice_right_or_left_is_equivalentI() {
    assertEquals(shapeI.rotateRight().rotateRight().toString(), 
        shapeI.rotateLeft().rotateLeft().toString());
  }

  // }

  // public class The_O_shape {
  private Tetromino shapeO;

  @Before
  public void createOShape() {
    shapeO = Tetromino.O_SHAPE;
  }

  @Test
  public void is_shaped_like_O() {
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void can_be_rotated_right_four_timesO() {
    shapeO = shapeO.rotateRight();
    assertEquals("" + "...\n" + ".OO\n" + ".OO\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + "...\n" + "OO.\n" + "OO.\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + "OO.\n" + "OO.\n" + "...\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void can_be_rotated_left_four_timesO() {
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "OO.\n" + "OO.\n" + "...\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "...\n" + "OO.\n" + "OO.\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "...\n" + ".OO\n" + ".OO\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void rotating_it_four_times_will_get_back_to_the_original_shapeO() {
    String originalShape = shapeO.toString();
    shapeO = shapeO.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shapeO.toString());
    shapeO = shapeO.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shapeO.toString());
  }

  @Test
  public void rotating_it_twice_right_or_left_is_equivalentO() {
    assertEquals(shapeO.rotateRight().rotateRight().toString(), 
        shapeO.rotateLeft().rotateLeft().toString());
  }

  // }

}
