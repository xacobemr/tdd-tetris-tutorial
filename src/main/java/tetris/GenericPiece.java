package tetris;

public interface GenericPiece {

	public static final char EMPTY = '.';
	
	public String toString();
	
	public int width();

    public int height();
    
    public boolean is_hollow_at(int i, int j);
	
}
