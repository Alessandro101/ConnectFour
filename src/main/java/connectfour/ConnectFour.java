package connectfour;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

/**
*This class will call methods from the Board class to check for wins and load/save games.
*It will also call TextUI to output messages and display the board to the user.
*
*@author Alessandro Arezza
*
*/
public class ConnectFour {
  private char symbol;
  private int turns;
  private TextUI ui;
  private Board board;
  private int loadedStatus; 
  private int position;
  private BufferedReader reader;
  private FileReader fr;
  private FileWriter writer;
  private String verifiedInput;
  private int savedStatus;

  /**
  Constructor creates initial value of turns, initial symbol for the player 
  and creates new instances of the Board and TextUI
  */
  public ConnectFour(){
    symbol = '1';
    turns = 0;
    ui = new TextUI();
    board = new Board();
  }

  /**
  The main method that runs the game
  */
  public static void main(String[] args){
    ConnectFour connectFour = new ConnectFour();
    int load = 0;
    int game = 0;
    int save = 0;

    while (game == 0){ 
      while (load == 0){
          connectFour.loadNewGame();
          
          load = connectFour.getLoadedStatus();
      }
      
    connectFour.verifyUserInput();

    if(connectFour.winningStatus()){
      game = 1;
    } 
      
    if (connectFour.getSavedStatus() == 0){
      connectFour.setPlayerSymbol();
    }
  }
  }

  /**
  Returns the name of the game
  @return The name 
  */
  @Override
  public String toString(){
    return "Connect Four Game";
  }

  /**
  Checks whether or not a win has occured and prints a message if there is a win or tie
  @return the status of a win in the game
  */
  public boolean winningStatus(){
    if(board.checkWin()){
      ui.displayBoard(board.toString());  
      ui.winningMessage(getPlayerSymbol());
      return true;
    }else if (board.checkTie()){
      ui.displayBoard(board.toString());
      ui.tieMessage();
      return true;
    }else{
      return false;
    }
  }

  /**
  Checks whether or not the user wants to input a position or save the
  current game.
  */
  public void verifyUserInput(){
    int exception = 1;
    ui.displayBoard(board.toString());
    ui.currentPlayerMessage(symbol);
    while (exception == 1){
    try{
      verifiedInput = ui.getInput();
      exception = 0;
    }catch(Exception e){
      ui.printExceptionMessage(e);
    }
    }
    if (verifiedInput.equals("save") || verifiedInput.equals("SAVE")){
      saveCurrentGame();
      savedStatus = 1;
    }else{
      position = Integer.parseInt(verifiedInput);
      board.changeBoard(position,getPlayerSymbol());  
      if (board.getError() == 1){
        turns = turns;
      }else{
        turns = turns + 1;
      }
      savedStatus = 0;
    }
    
  }

  /**
  Checks whether or not the user wants to load a new game at the beginning
  of a session.
  */
  public void loadNewGame(){
    String loadFileName;
    int exception = 1; 
    while (exception == 1){
    try{
      ui.loadGame();
      exception = 0;
    }catch(Exception e){
      ui.printExceptionMessage(e);
      exception = 1;
      }
    }
    loadFileName = ui.getLoadFile();
    if (loadFileName.equals("")){ 
          loadedStatus = loadedStatus + 1;
    }else{
      try{
        loadBoard("assets/" + loadFileName);
        board.checkLoadedBoard();
      }catch(Exception e){
          ui.printExceptionMessage(e);
        }
        loadedStatus = loadedStatus + 1;
        if(board.checkWin()){
          ui.displayBoard(board.toString());  
          ui.winningMessage(getPlayerSymbol());
          return;
        }  
  }
  }

  public int getLoadedStatus(){
    return loadedStatus;
  }

  public int getSavedStatus(){
    return savedStatus;
  }

  /**
  Asks the user for a filename to which all of the contents of the board will be saved
  */
  public void saveCurrentGame(){
    String saveFileName;
    try{
    ui.saveGame();
    }catch(Exception e){
      ui.printExceptionMessage(e);
    }
    saveFileName = ui.getSaveFile();  
    try{
    saveBoard("assets/" + saveFileName);     
    }catch (Exception e){
      ui.printExceptionMessage(e);
    }
  }

  /**
  Reads the contents of a file and adds it to a new string builder 
  @param fileName Name of file to be read
  */
  public void loadBoard(String fileName) throws IOException{

    String oneLine;
    StringBuilder fileContents = new StringBuilder("");
    fr = new FileReader(fileName);
    
    reader = new BufferedReader(fr);
      
    for (int i = 0; i < 6; i++){
    oneLine = reader.readLine();
    for (int j = 0; j < oneLine.length(); j++){
      if (oneLine.charAt(j) == '1' || oneLine.charAt(j) == '2'){
        turns++;
      }
    }

    if (i == 5){
      fileContents.append(oneLine);

    }else{

      fileContents.append(oneLine); 
      fileContents.append("\n");

    }
    }
    board.setLoadedBoard(fileContents);
    reader.close(); 

  }

  /**
  Writes the contents of the current board to a new file
  @param fileName Name of file to be written 
  */
  public void saveBoard(String fileName) throws IOException{
    writer = new FileWriter(fileName);
    writer.write(board.toString());
    writer.close();
  }

  public char getPlayerSymbol(){
    return symbol;
  }

  public int getTurns(){
    return turns;
  }
  
  /**
  Sets the player symbol depending on turn number 
  */
  public void setPlayerSymbol(){
    if (turns % 2 == 0){
      symbol = '1';
    }else{
      symbol = '2';
    }

  }
}