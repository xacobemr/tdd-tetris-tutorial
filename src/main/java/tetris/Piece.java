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
	
	public Piece(Block tablero[][]){
        this.tablero = tablero;
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
    
    public Block[][] trasTab(Block tab[][]){
    	Block[][] traspuestoTab = new Block[tab.length][tab[0].length];
    	
    	for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length; j++){
            	traspuestoTab[j][i] = tab[i][j];
            }
        }
        return traspuestoTab;
    }
    
    public Piece rotateRight() {
    	Block[][] traspuestoTab = trasTab(tablero);
        Block[][] resTab = new Block[traspuestoTab.length][traspuestoTab[0].length];
        
        for(int i=0; i<traspuestoTab.length; i++){
            for(int j=0; j<traspuestoTab[i].length; j++){
            	resTab[i][j] = traspuestoTab[i][traspuestoTab[i].length-j-1];
            }
        }
        return new Piece(resTab);
    }
    
	
}
