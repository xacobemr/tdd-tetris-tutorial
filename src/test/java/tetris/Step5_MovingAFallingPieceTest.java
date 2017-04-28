// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

//@Ignore("contains no test")
@RunWith(NestedJUnit.class)
public class Step5_MovingAFallingPieceTest extends Assert {

    // Step 5: It's your turn now
    // - Remove the @Ignore annotation from this class
    // - The test names have been provided, you just need to fill in the test body
    // - Next step: RotatingAFallingPieceTest

	
	
	
	public class A_falling_piece{
		
		private final Board board = new Board(6, 8);
		
		@Before
		public void dropPiece(){
			board.drop(Tetromino.T_SHAPE);
		}
		
		// TODO: a falling piece can be moved left
		@Test
		public void a_falling_piece_can_be_moved_left(){
			
			board.move_Left();
				
			assertEquals("" +
		           "...T....\n" +
		           "..TTT...\n" +
		           "........\n" +
		           "........\n" +
		           "........\n" +
		           "........\n", board.toString());
	    }
		
	    // TODO: a falling piece can be moved right
		@Test
		public void a_falling_piece_can_be_moved_right(){
			
			board.move_Right();
			
			assertEquals("" +
			           ".....T..\n" +
			           "....TTT.\n" +
			           "........\n" +
			           "........\n" +
			           "........\n" +
			           "........\n", board.toString());
			
		}
	
		// TODO: a falling piece can be moved down
		@Test
		public void a_falling_piece_can_ben_moved_down(){
			
			board.tick();
			
			assertEquals("" +
			           "........\n" +
			           "....T...\n" +
			           "...TTT..\n" +
			           "........\n" +
			           "........\n" +
			           "........\n", board.toString());
		}
	
	
	    // TODO: it will not move left over the board
		@Test
		public void it_will_not_move_left_over_the_board(){
		
			for(int i=0; i<=10; i++){
				board.move_Left();
			}
			
			assertEquals("" +
			           ".T......\n" +
			           "TTT.....\n" +
			           "........\n" +
			           "........\n" +
			           "........\n" +
			           "........\n", board.toString());
			
		}
	
	    // TODO: it will not move right over the board
	    @Test
	    public void it_will_not_move_right_over_the_board(){
	    	
	    	for(int i=0; i<=10; i++){
				board.move_Right();
			}

	    	assertEquals("" +
			           "......T.\n" +
			           ".....TTT\n" +
			           "........\n" +
			           "........\n" +
			           "........\n" +
			           "........\n", board.toString());

	    	
	    }
		
		
		// TODO: it will not move down over the board (will stop falling)
	    @Test
	    public void it_wil_not_move_over_the_board(){
	    	
	    	for(int i=0; i<=10; i++){
				board.tick();
			}
	    	
	    	assertEquals("" +
			           "........\n" +
			           "........\n" +
			           "........\n" +
			           "........\n" +
			           "....T...\n" +
			           "...TTT..\n", board.toString());
	    	
	    }
	    
	}
	
	public class It_cannot_be_moved{
		
		private final Board board = new Board("" +
		           "X......X\n" +
		           "X......X\n" +
		           "X......X\n" +
		           "X......X\n" +
		           "X......X\n" +
		           "XXXXXXXX\n");
		
		@Before
		public void dropPiece(){
			board.drop(Tetromino.T_SHAPE);
		}
			
		// TODO: it cannot be moved left if another piece is in the way
		@Test
		public void it_cannot_be_moved_left_if_another_piece_is_in_the_way(){
			for(int i=0; i<=10; i++){
				board.move_Left();
			}
			
			assertEquals("" +
			           "X.T....X\n" +
			           "XTTT...X\n" +
			           "X......X\n" +
			           "X......X\n" +
			           "X......X\n" +
			           "XXXXXXXX\n", board.toString());
		}
	
	    // TODO: it cannot be moved right if another piece is in the way
		@Test
		public void it_cannot_be_moved_right_if_another_piece_is_in_the_way(){
			for(int i=0; i<=10; i++){
				board.move_Right();
			}
			
			assertEquals("" +
			           "X....T.X\n" +
			           "X...TTTX\n" +
			           "X......X\n" +
			           "X......X\n" +
			           "X......X\n" +
			           "XXXXXXXX\n", board.toString());
		}
		
	    // TODO: it cannot be moved down if another piece is in the way (will stop falling)
	}
    // P.S. Take into consideration, that part of the piece's area may be empty cells.
    // Only non-empty cells should take part in the collision checks.
}
