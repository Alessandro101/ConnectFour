package connectfour;

import java.util.Scanner;

/**
*This class will display all the relevent information of the game to the user. It will
*display the board, game messages, and allow the user to enter input choices. 
*
*@author Alessandro Arezza
*
*/
public class TextUI{
  private Scanner stringInput;
  private String userInput;
  private String saveFile;
  private String loadFile;
  private String choice;

  /**
  This constructor initializes the scanner and userInput string
  */
  public TextUI(){
    stringInput = new Scanner(System.in);
    userInput = "";
  }

  /**
  Prints a message that informs the user of the current player 
  */
  public String getInput() throws Exception{
    System.out.println("Please enter a column number (1-7) or enter (save) to save the game: ");
    userInput = stringInput.next();
    if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3") 
    ||  userInput.equals("4") || userInput.equals("5") || userInput.equals("6") || userInput.equals("7")
    ||  userInput.equals("save") || userInput.equals("SAVE")){
      return userInput;
    }else{
      throw new Exception("The item entered is not a number between 1 and 7 or the save option");
    }
  }

  /**
  Return a string that describes the class
  @return a message that informs the user of the class purpose
  */
  @Override
  public String toString(){
    return "The TextUI class displays relevant messages to the screen";
  }

  /**
  Outputs the string representation of the board
  @param b string to be printed
  */
  public void displayBoard(String b){
    System.out.println(b);
  }

  /**
  Prints a message that informs the user of the current player 
  */
  public void currentPlayerMessage(char c){
    System.out.println("\nCurrent player: " + c);
  }
  
  public String getSaveFile(){
    return saveFile;
  }
  
  /**
  Asks user to input a file name to be saved
  */
  public void saveGame(){
       System.out.println("Enter a filename: ");
       saveFile = stringInput.next();

  }
  
  public String getLoadFile(){
    return loadFile;
  } 
  
  /**
  Asks the user if they would like to load a game. Different outcomes
  occur depending on whether the user says yes(y) or no(n).
  */
  public void loadGame() throws Exception{
    System.out.println("Would you like to load a game? (y/n)");
    choice = stringInput.next();
    
    if (choice.equals("y") || choice.equals("Y")){
       System.out.println("Enter a filename: ");
       loadFile = stringInput.next();

    }else if (choice.equals("n") || choice.equals("N")){
      loadFile = "";
      System.out.println("Starting new game");
      
    }else {
      throw new Exception("Please enter y or n");
    }
  }

  public void winningMessage(char c){
    System.out.println("Winner: Player " + c);
  }
  public void tieMessage(){
    System.out.println("The game is a tie!");
  }
  public void printExceptionMessage(Exception e){
    System.out.println(e.getMessage());
  }
}
