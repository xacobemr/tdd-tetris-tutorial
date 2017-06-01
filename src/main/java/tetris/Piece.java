package tetris;

// TODO: Auto-generated Javadoc
/**
 * The Class Piece.
 */
public class Piece implements GenericPiece {

  /** The tablero. */
  private Block[][] tablero;

  /**
   * Instantiates a new piece.
   *
   * @param tab the tab
   */
  public Piece(String tab) {
    String[] rows = tab.split("\n");

    for (int i = 0; i < rows.length; i++) {
      char[] column = rows[i].toCharArray();
      for (int j = 0; j < column.length; j++) {
        if ((i == 0) && (j == 0)) {
          tablero = new Block[rows.length][column.length];
        }
        tablero[i][j] = new Block(column[j]);
      }
    }
  }

  /**
   * Instantiates a new piece.
   *
   * @param tablero the tablero
   */
  public Piece(final Block[][] tablero) {
    this.tablero = tablero;
  }

  /* (non-Javadoc)
   * @see tetris.GenericPiece#width()
   */
  public int width() {
    return tablero[0].length;
  }

  /* (non-Javadoc)
   * @see tetris.GenericPiece#height()
   */
  public int height() {
    return tablero.length;
  }

  
  /** 
   * Is hollow at.
   * @param i the i
   * @param j the j
   * @return the boolean
   */
  public boolean is_hollow_at(final int i, final int j) {
    return tablero[i][j]
            .toString().equals(
            String.valueOf(
            GenericPiece.EMPTY));
  }

  
  /** 
   * To string.
   *
   * @return the string
   */
  public String toString() {
    String s = "";

    if (tablero != null) {
      for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
          s += tablero[i][j].toString();
        }
        s += "\n";
      }
    }
    return s;
  }

  /**
   * Tras tab.
   *
   * @param tab the tab
   * @return the block[][]
   */
  public Block[][] trasTab(final Block[][] tab) {
    Block[][] traspuestoTab = new Block[tab.length][tab[0].length];

    for (int i = 0; i < tab.length; i++) {
      for (int j = 0; j < tab[i].length; j++) {
        traspuestoTab[j][i] = tab[i][j];
      }
    }
    return traspuestoTab;
  }

  /**
   * Rotate right.
   *
   * @return the piece
   */
  public Piece rotateRight() {
    Block[][] traspuestoTab = trasTab(tablero);
    Block[][] resTab = new Block[
                                     traspuestoTab.length][
                                     traspuestoTab[0].length];

    for (int i = 0; i < traspuestoTab.length; i++) {
      for (int j = 0; j < traspuestoTab[i].length; j++) {
        resTab[i][j] = traspuestoTab[i][
                               traspuestoTab[i].length - j - 1];
      }
    }
    return new Piece(resTab);
  }

  /**
   * Rotate left.
   *
   * @return the piece
   */
  public Piece rotateLeft() {
    Block[][] traspuestoTab = trasTab(tablero);
    Block[][] resTab = new Block[
                                     traspuestoTab.length][
                                     traspuestoTab[0].length];

    for (int i = 0; i < traspuestoTab.length; i++) {
      for (int j = 0; j < traspuestoTab[i].length; j++) {
        resTab[i][j] = traspuestoTab[traspuestoTab.length - i - 1][j];
      }
    }
    return new Piece(resTab);
  }
}
