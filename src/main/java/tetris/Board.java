// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Block block;
    private Block tablero[][];
    private int rowCont = 0;
    private int colCont = 1;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.block = null;
        this.tablero = new Block[rows][columns];
    }
    
    //Construye el tablero
    public String toString() {
        String s = "";
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	s += printearCaracter(col, row, this.block, this.tablero, this.rowCont);
            }
            s += "\n";
        }
        return s;
    }
    
    //Escoge que carácter concatenar
    private char printearCaracter(int col, int row, Block block, Block tab[][], int rowCont){
    	if((block != null) && (row == rowCont) && (col == colCont)){
//	    	if(row == 0 && col == 1 && block != null && tickCont == 0){
//	    		return block.getCharacter();
//	    	}else if(row == 1 && col == 1 && tickCont == 1){
//	    		return block.getCharacter();
//	    	}else if(row == 2 && col == 1 && (tickCont == 2 || tickCont == 3)){
//	    		return block.getCharacter();
//	    	}else{
//	    		return '.';
//	    	}
    		return block.getCharacter();
    	}else{
    		if (tab[row][col] != null) {
                return tab[row][col].getCharacter();
            } else {
            	return '.';
            }
    		
    	}
    }
    
    //Aumenta el contador de tick
    public void tick(){
    	this.rowCont ++;
    	if(this.rowCont == rows){
    		this.tablero[rowCont-1][colCont] = block;
    		this.block = null;
    	}
    }
    
    
    //Detecta si el bloque puede seguir cayendo
    public Boolean hasFalling() {
    	if(this.block == null){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    //Inserta un nuevo bloque
    public void drop(Block b) throws IllegalStateException{
    	if(this.block != null){
    		throw new IllegalStateException("already falling");
    	}else{
    		this.block = b;
    		this.rowCont = 0;
    	}
    }
    
    
    
}
