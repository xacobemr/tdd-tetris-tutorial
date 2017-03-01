package tetris;

public class Tetromino {

	private Piece piece;
	
	private Tetromino(Piece piece){
		this.piece = piece;
	}
	
	public static Tetromino T_SHAPE = new Tetromino(new Piece(".T.\n" +
													  		  "TTT\n" +
													  		  "..."));
	
	public Tetromino rotateRight(){
		Tetromino newTetr = new Tetromino(piece.rotateRight());
		return newTetr;
	}
	
	public void rotateLeft(){
		
	}
	
	public String toString(){
		return piece.toString();
	}
	
}
