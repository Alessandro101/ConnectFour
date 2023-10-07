package connectfour;

/**
*This class creates a string representation of the board for the connect four game. 
*It checks the win conditions for the game.
*It will also allow the user to save the contents of the board string to a separate file, and
*load a new string into the current board.
*
*@author Alessandro Arezza
*
*/
public class Board{

  private StringBuilder board;
  private String boardString;
  private int[] boardIndex;
  private int lastRow;
  private boolean winner;
  private int loaded;
  private StringBuilder loadedBoard;
  private int error;
  private boolean tie;
  
  /**
  This constructor defines initial values for the winning status and board string
  */
  public Board(){
    lastRow = 70;
    error = 1;
    loadedBoard = new StringBuilder("");
    winner = false;
    tie = false;
    boardIndex = new int[] {0,2,4,6,8,10,12};
    board = new StringBuilder("0,0,0,0,0,0,0\n0,0,0,0,0,0,0\n0,0,0,0,0,0,0\n0,0,0,0,0,0,0");
    board.append("\n0,0,0,0,0,0,0\n0,0,0,0,0,0,0"); 
    setBoardString();
  }

  /**
  This method returns the board string
  @return The string representation of the board
  */
  @Override
  public String toString(){
    return boardString;
  }
  
  private void setBoardString(){
    boardString = board.toString();
  }

  public String getLoadedBoard(){
    return loadedBoard.toString();
  }
  public void setLoadedBoard(StringBuilder s){
    loadedBoard = s;
  }

  public int getError(){
    return error;
  }

  /**
  This method changes the current board string to a new StringBuilder loaded by a file.
  Checks if the file string has valid formatting and contents.
  */
  public void checkLoadedBoard() throws Exception{
    
    if (loadedBoard.length() != 83){
      throw new Exception("Invalid file (Board must consist of 83 characters)");
    }

    if (loadedBoard.length() == 83){
    for (int i = 0; i < loadedBoard.length(); i+=2){
      if(loadedBoard.charAt(i) != '1' && loadedBoard.charAt(i) != '2' && loadedBoard.charAt(i) != '0'){
        throw new Exception("Invalid file (Characters in board must be 1,2,or 0)");
      }
    for (int j = 0; j < loadedBoard.length()-14;j+=2){
      if ((loadedBoard.charAt(j) == '1' || loadedBoard.charAt(j) == '2') &&  loadedBoard.charAt(j+14) == '0'){
        throw new Exception("Invalid file (player chip in invalid position)");
      }
    }    
    loaded = 1;
      
      }
    }
    if (loaded == 1){
      board = loadedBoard;
    }
    
    setBoardString();
    
  }

  /**
  This changes a spot on the board based on user input and symbol
  @param x position input given by the user
  @param c the symbol of the current player
  */
  public void changeBoard(int x, char c){

    for (int i = 0; i <= lastRow; i+=14){
      if (board.charAt(boardIndex[x-1]) == '1' || board.charAt(boardIndex[x-1]) == '2'){
        error = 1;
        break;
    }
      if ((i+14) > lastRow){
        board.setCharAt(boardIndex[x-1] + lastRow,c);
        error = 0;
        break;
        
      }else if (board.charAt(boardIndex[x-1]+(i+14)) == '1'|| board.charAt(boardIndex[x-1]+(i+14)) == '2'){
        board.setCharAt(boardIndex[x-1]+(i),c);
        error = 0;
        break;
      }
    }
    setBoardString();
  }

  /**
  This method checks the various win conditions for the game. Will check for four in a row
  in vertical, horizontal, and diagonal orientations.
  @return the status of the winner 
  */
  public boolean checkWin(){
    checkVerticalWin();
    checkHorizontalWin();
    checkDiagonalWin();
    return winner;
  }

  /**
  This method checks if the game has ended in a tie
  @return the status of a tie 
  */
  public boolean checkTie(){
    checkTieCondition();
    return tie;
  }
  private void checkVerticalWin(){
      
      for (int i = 0; i <= 12; i+=2){
      for(int j = i; j < (i + lastRow); j+=14){
      if ((j+42) > (i + lastRow)){
        break;
      }else if ((board.charAt(j) == '1' || board.charAt(j) == '2') 
      && board.charAt(j) == board.charAt(j+14) && board.charAt(j+14) == board.charAt(j+28) 
      && board.charAt(j+28) == board.charAt(j+ 42)){
          winner = true;
          
        }
      }
      }
    }

private void checkHorizontalWin(){
  for (int j = 0; j <= lastRow; j+=14){
    for (int k = j; k < (j+8);k+=2){

   if ((board.charAt(k) == '1' || board.charAt(k) == '2') && board.charAt(k) == board.charAt(k+2) 
   && board.charAt(k+2) == board.charAt(k+4) && board.charAt(k+4) == board.charAt(k+6)){
     winner = true;
  }
    }
}
}
private void checkDiagonalWin(){
  for (int j = 0; j <= 28; j+=14){
    for (int k = j; k < (j+8); k+=2){

    if ((board.charAt(k) == '1' || board.charAt(k) == '2') && board.charAt(k) == board.charAt(k+16) 
    && board.charAt(k+16)  == board.charAt(k+32) && board.charAt(k+32) == board.charAt(k+48)){
        winner = true;
      }
  }
}
  for (int j = 12; j <= 40; j+=14){
    for (int k = j; k > (j-8); k-=2){

    if ((board.charAt(k) == '1' || board.charAt(k) == '2') 
    && board.charAt(k) == board.charAt(k+12) && board.charAt(k+12)  == board.charAt(k+24) 
    && board.charAt(k+24) == board.charAt(k+36)){
        winner = true;
      }  
    }
  }
}
private void checkTieCondition(){
  int numOfChars = 0;
  for (int i = 0; i < 83; i+=2){
    if (board.charAt(i) == '1' || board.charAt(i) == '2'){
      numOfChars++;
    }
  }
  if (numOfChars == 42){
    tie = true;
  }
}
}