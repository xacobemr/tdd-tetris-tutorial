// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

	public  static final String ALREADY_FALLING = "already falling";
	
    private final int rows;
    private final int columns;
    private GenericPiece block;
    private char tablero[][];
    private int rowCont;
    private int colCont;
    private boolean last_tick;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.block = null;
        this.tablero = new char[rows][columns];
        fill_with(tablero, GenericPiece.EMPTY);
        this.last_tick = false;
    }
    
    public String toString() {
        String s = "";
        for (int i=0; i<tablero.length; i++) {
            for (int j=0; j<tablero[0].length; j++) {
                if (falling_block_is_at(i,j)) {
                    char tablero[][] = new char[block.width()][block.height()];
                    fill_with(tablero, block.toString());
                    s += tablero[(i-rowCont)][(j-colCont)];
                } else {
                    char c[] = { tablero[i][j] };
                    s += new String(c);
                }
            }
            s += "\n";
        }
        return s;
    }
    
//    //Construye el tablero
//    public String toString() {
//        String s = "";
//        
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < columns; col++) {
//            	s += printearCaracter(col, row, this.block, this.tablero, this.rowCont);
//            }
//            s += "\n";
//        }
//        return s;
//    }
    
    //Escoge que carácter concatenar
//    private String printearCaracter(int col, int row, GenericPiece block, char tab[][], int rowCont){
//    	if((block != null) && (row == rowCont) && (col == colCont)){
//    		return block.toString();
//    	}else{
//    		if(tab[row][col] != null) {
//                return tab[row][col].toString();
//            } else {
//            	return ".";
//            }
//    		
//    	}
//    	
//    }
    
    //Aumenta el contador de tick
    public void tick() {
        if (block != null) {
            if (!last_tick) {
            	rowCont++;
                if (reached_bottom() || touched_another_block()) {
                    last_tick = true;
                }
            } else {
                fill_with(tablero, toString());
                block = null;
                last_tick = false;
            }
        }
    }
    
    private boolean reached_bottom() {
        int reached_row = rowCont;
        String[] s = block.toString().split("\n");

        for (int i=0; i<s.length; i++) {
            if (s[i].replace(GenericPiece.EMPTY, ' ').trim().length() != 0) {
                reached_row++;
            }
        }

        return (reached_row == rows);
    }
    
    private boolean touched_another_block() {
        for (int i=0; i<rows-1; i++) {
            for (int j=0; j<columns; j++) {
                if ((tablero[i+1][j] != GenericPiece.EMPTY) &&
                    falling_block_is_at(i, j)) {
                    return true;
                }
            }
        }
        return false;
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
    public void drop(GenericPiece b) throws IllegalStateException{
    	if ((block == null) || (last_tick)) {
            block = b;
            rowCont = 0;
            colCont = (this.columns / 2) - (b.width() / 2);
        } else {
            throw new IllegalStateException(Board.ALREADY_FALLING);
        }
    }
    
    private void fill_with(char matrix[][], char c) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = c;
            }
        }
    }

    private void fill_with(char matrix[][], String s) {
        String[] rows = s.split("\n");
        for (int i=0; i<rows.length; i++) {
            char[] column = rows[i].toCharArray();
            for (int j=0; j<column.length; j++) {
                matrix[i][j] = column[j];
            }
        }
    }
    
    private boolean falling_block_is_at(int row, int column) {
        if (block != null) {
            return ((rowCont <= row) &&
                    (row < rowCont + block.height()) &&
                    (colCont <= column) &&
                    (column < colCont + block.width()) &&
                    (!block.is_hollow_at(row - rowCont,
                                                 column - colCont + block.width()/2 - 1)));
        } else {
            return false;
        }
    }
    
    public void move_Left(){
    	colCont --;
    }
    
    public void move_Right(){
    	colCont ++;
    }
    
}
