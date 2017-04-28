package tetris;

public class Tetromino implements GenericPiece{

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
	
	public static Tetromino H_SHAPE = new Tetromino(new Piece(".H.\n" +
	  		  												  "HHH\n" +
	  		  												  ".H."));
	
	public int width() {
        return piece.width();
    }

    public int height() {
        return piece.height();
    }
    
    public boolean is_hollow_at(int i, int j) {
        return piece.is_hollow_at(i, j);
    }
	
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
