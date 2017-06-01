package tetris;


// TODO: Auto-generated Javadoc
/**
 * The Interface GenericPiece.
 */
public interface GenericPiece {


  /** The empty. */
  char EMPTY = '.';

 
  /**
   * To string.
   *
   * @return the string
   */
  String toString();


  /**
   * Width.
   *
   * @return the int
   */
  int width();


  /**
   * Height.
   *
   * @return the int
   */
  int height();


  /**
   * Checks if is hollow at.
   *
   * @param i the i
   * @param j the j
   * @return true, if is hollow at
   */
  boolean is_hollow_at(int i, int j);

}
