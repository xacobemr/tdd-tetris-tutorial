package tetris;

public class Piece {

	private Block tablero[][];
	
	public Piece(String tab){
        String[] rows = tab.split("\n");
        
        for(int i=0; i<rows.length; i++){
            char[] column = rows[i].toCharArray();
            for(int j=0; j<column.length; j++){
                if((i==0) && (j==0)){
                	tablero = new Block[rows.length][column.length];
                }
                tablero[i][j] = new Block(column[j]);
            }
        }
    }

    public String toString(){
        String s = "";
        
        if(tablero != null){
            for(int i=0; i<tablero.length; i++){
                for(int j=0; j<tablero[i].length; j++){
                    s += tablero[i][j].getCharacter();
                }
            s += "\n";
            }
        }
        return s;
    }
	
}
