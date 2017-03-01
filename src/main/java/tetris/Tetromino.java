package tetris;

public class Tetromino {

	private Piece piece;
	
	private Tetromino(Piece piece){
		this.piece = piece;
	}
	
	public static Tetromino T_SHAPE = new Tetromino(new Piece(".T.\n" +
													  		  "TTT\n" +
													  		  "..."));
	
	public static Tetromino I_SHAPE = new Tetromino(new Piece("....\n" +
	  		  												  "IIII\n" +
	  		  												  "....\n" +
	  		  												  "...."));
	
	public static Tetromino O_SHAPE = new Tetromino(new Piece(".OO\n" +
				  											  ".OO\n" +
				  											  "..."));
	
	public Tetromino rotateRight(){
		Tetromino newTetr = new Tetromino(piece.rotateRight());
		return newTetr;
	}
	
	public Tetromino rotateLeft(){
		Tetromino newTetr = new Tetromino(piece.rotateLeft());
		return newTetr;
	}
	
	public String toString(){
		return piece.toString();
	}
	
}
