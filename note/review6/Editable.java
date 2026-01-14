package note.review6;

/**
 * An editable can overwrite or append a number of words to itself.
 */
public interface Editable {
  /**
   * Overwrites the number of words in the list starting at the given index.
   * 
   * @param index          the starting index
   * @param numberOfWords  the number of words to overwrite
   */
  public void overwrite(int index, int numberOfWords);
  
  /**
   * Appends a number of words to the end of the list.
   * 
   * @param numberOfWords  the number of words to append
   */
  public void append(int numberOfWords);
  
}
