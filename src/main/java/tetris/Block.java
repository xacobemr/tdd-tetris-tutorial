package tetris;

public class Block implements GenericPiece {

  private char character;

  public Block(char character) {
    this.character = character;
  }

  @Override
  public String toString() {
    char[] blockAsString = {character};
    return new String(blockAsString);
  }

  public int width() {
    return 1;
  }

  public int height() {
    return 1;
  }

  public boolean is_hollow_at(final int i, final int j) {
    return ((i != 0) && (j != 0));
  }

}
