// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Block block;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
            	if(row == 0 && col == 1 && this.block != null){
            		s += "X";
            	}else{
            		s += ".";
            	}
            }
            s += "\n";
        }
        return s;
    }
    
    public Boolean hasFalling() {
    	if(this.block == null){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public void drop(Block block){
    	this.block = block;
    }
    
    
    
}
