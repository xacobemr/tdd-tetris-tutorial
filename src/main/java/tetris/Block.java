package tetris;

public class Block implements GenericPiece{

	private char character;
	
	public Block(char character){
		this.character = character;
	}

	public String toString() {
		
		return String.valueOf(character);
	}
	
	
}
