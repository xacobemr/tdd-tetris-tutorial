// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board {

  /** The Constant ALREADY_FALLING. */
  public  static final String ALREADY_FALLING = "already falling";

  /** The rows. */
  private final int rows;

  /** The columns. */
  private final int columns;

  /** The block. */
  private GenericPiece block;

  /** The tablero. */
  private char[][] tablero;

  /** The row cont. */
  private int rowCont;

  /** The col cont. */
  private int colCont;

  /** The last tick. */
  private boolean lastTick;


 
  /**
   * Instantiates a new board.
   *
   * @param board the board
   */
  public Board(String board) {
    String[] rows = board.split("\n");
    this.rows = rows.length;
    this.columns = rows[0].length();
    this.tablero = new char[rows.length][rows[0].length()];
    for (int i = 0; i < rows.length; i++) {
      char[] column = rows[i].toCharArray();
      for (int j = 0; j < column.length; j++) {
        tablero[i][j] = column[j];
      }
    }
  }


  /**
   * Instantiates a new board.
   *
   * @param rows the rows
   * @param columns the columns
   */
  public Board(final int rows, final int columns) {
    this.rows = rows;
    this.columns = columns;
    this.block = null;
    this.tablero = new char[rows][columns];
    fill_with(tablero, GenericPiece.EMPTY);
    this.lastTick = false;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String s = "";
    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero[0].length; j++) {
        if (falling_block_is_at(i, j)) {
          char[][] tablero =
            new char[
                                block.width()][
                                block.height()];
          fill_with(tablero, block.toString());
          s += tablero[
                                (i - rowCont)][(j - colCont)];
        } else {
          char[] c = {tablero[i][j]};
          s += new String(c);
        }
      }
      s += "\n";
    }
    return s;
  }


  /**
   * Tick.
   */
  //Aumenta el contador de tick
  public void tick() {
    if (block != null) {
      if (!lastTick) {
        rowCont++;
        if (reached_bottom()
                     ||
                    touched_another_block()) {
          lastTick = true;
        }
      } else {
        fill_with(tablero, toString());
        block = null;
        lastTick = false;
      }
    }
  }

 
  /**
   * Reached bottom.
   *
   * @return true, if successful
   */
  private boolean reached_bottom() {
    int reachedRow = rowCont;
    String[] s = block.toString().split("\n");

    for (int i = 0; i < s.length; i++) {
      if (s[i].replace(GenericPiece.EMPTY, ' ')
                    .trim().length() != 0) {
        reachedRow++;
      }
    }

    return (reachedRow == rows);
  }


  /**
   * Touched another block.
   *
   * @return true, if successful
   */
  private boolean touched_another_block() {
    for (int i = 0; i < rows - 1; i++) {
      for (int j = 0; j < columns; j++) {
        if ((tablero[i + 1][j] != GenericPiece.EMPTY) 
            &&
            falling_block_is_at(i, j)) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   * Checks for falling.
   *
   * @return the boolean
   */
  //Detecta si el bloque puede seguir cayendo
  public Boolean hasFalling() {
    if (this.block == null) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Drop.
   *
   * @param b the b
   * @throws IllegalStateException the illegal state exception
   */
  //Inserta un nuevo bloque
  public void drop(final GenericPiece b) throws IllegalStateException {
    if ((block == null) || (lastTick)) {
      block = b;
      rowCont = 0;
      colCont = (this.columns / 2) - (b.width() / 2);
    } else {
      throw new IllegalStateException(Board.ALREADY_FALLING);
    }
  }

  
  /**
   * Fill with.
   *
   * @param matrix the matrix
   * @param c the c
   */
  private void fill_with(final char[][] matrix, final char c) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = c;
      }
    }
  }


  /**
   * Fill with.
   *
   * @param matrix the matrix
   * @param s the s
   */
  private void fill_with(final char[][] matrix, final String s) {
    String[] rows = s.split("\n");
    for (int i = 0; i < rows.length; i++) {
      char[] column = rows[i].toCharArray();
      for (int j = 0; j < column.length; j++) {
        matrix[i][j] = column[j];
      }
    }
  }


  /**
   * Falling block is at.
   *
   * @param row the row
   * @param column the column
   * @return true, if successful
   */
  private boolean falling_block_is_at(int row, int column) {
    if (block != null) {
      return ((rowCont <= row)
        &&
        (row < rowCont + block.height())
        &&
        (colCont <= column)
        &&
        (column < colCont + block.width())
        &&
        (!block.is_hollow_at(row - rowCont,
        column - colCont
        +
        block.width()
        /
        2 - 1)));
    } else {
      return false;
    }
  }


  /**
   * Move left.
   */
  public void move_Left() {
    if (colCont > 0 && can_move_Left()) {
      colCont--;
    }
  }


  /**
   * Move right.
   */
  public void move_Right() {
    if ((colCont + block.width()) < columns && can_move_Right()) {
      colCont++;
    }
  }


  /**
   * Move down.
   */
  public void move_Down() {
    if ((rowCont + block.height()) < rows && can_move_Down()) {
      rowCont++;
    }
  }


  /**
   * Can move left.
   *
   * @return true, if successful
   */
  private boolean can_move_Left() {
    return (tablero[rowCont][colCont - 1] == '.');
  }


  /**
   * Can move right.
   *
   * @return true, if successful
   */
  private boolean can_move_Right() {
    return (tablero[rowCont][colCont + block.width()] == '.');
  }


  /**
   * Can move down.
   *
   * @return true, if successful
   */
  private boolean can_move_Down() {
    return (tablero[rowCont + block.height()][colCont] == '.');
  }

}
