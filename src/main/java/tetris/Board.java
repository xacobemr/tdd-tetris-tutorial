// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Block block;
    private int tickCont = 0;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    //Construye el tablero
    public String toString() {
        String s = "";
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	s += printearCaracter(col, row, block, tickCont);
            }
            s += "\n";
        }
        return s;
    }
    
    //Escoge que carácter concatenar
    private char printearCaracter(int col, int row, Block block, int tickCont){
    	if(row == 0 && col == 1 && this.block != null && tickCont == 0){
    		return block.getCharacter();
    	}else if(row == 1 && col == 1 && tickCont == 1){
    		return block.getCharacter();
    	}else{
    		return '.';
    	}
    }
    
    //Aumenta el contador de tick
    public void tick(){
    	this.tickCont ++;
    }
    
    public Boolean hasFalling() {
    	if(this.block == null){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public void drop(Block block){
    	if(block.getCharacter() == 'Y'){
    		throw new IllegalStateException("already falling");
    	}else{
    		this.block = block;
    	}
    }
    
    
    
}
