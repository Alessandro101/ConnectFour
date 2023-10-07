# Connect Four

Connect Four game that can be played by two people using one keyboard. Allows the user to save and load games.

## Description

Connect Four game created using three classes: a board class, a TextUI class, and a ConnectFour class. The board class will maintain the string representation of the board, check if a loaded string is valid, and check the win conditions for the game. The TextUI class is responsible for displaying all the necessary information to the user on the console. The ConnectFour class will handle player turns and symbols, and call methods from the other two classes to create a working game.

## Getting Started

### Dependencies

* Gradle is a prerequisite needed to build the program


### Executing program

* Building and running the program
1.
```
oer-A2$ gradle build
```
2.
```
oer-A2$ gradle run
```
3.
```
oer-A2$ java -cp build/classes/java/main connectfour.ConnectFour
```
* Expected Output
```
Would you like to load a game? (y/n)

```
## Limitations

Cannot load a file after player enters invalid file  

## Author Information

* Name: Alessandro Arezza
* Email: aarezza@uoguelph.ca

## Development History
* 1.3
    * changed spacing
* 1.2
    * reworked horizontal and diagonal win conditions
* 1.1
    * added javadoc comments tie methods
* 1.0
    * added javadoc comments for constructor and main
* 0.9
    * added method to check for tie conditon,added javadocs to other classes, added new test case to check for tie
* 0.8
    * added test cases for loading exceptions, changed where loading and saving takes place
* 0.7
    * added new test cases for changing board, changed ways in which the player symbol is determined
* 0.6
    * reworked ability to save file
* 0.5
    * added javadoc class comments to TextUI and ConnectFour, added new test cases for Board
* 0.4
    * added Javadoc comments to Board, changed vertical win method, and created test cases for win conditions in Board
* 0.3
    * performed error checking and improved exception handling in connectfour methods
* 0.2
    * fixed checkstyle errors, added methods to ConnectFour to implement TextUI and Board classes
* 0.1
    * added methods to all major classes, removed starter test

## Acknowledgments

Inspiration, code snippets, etc.
* [tutorialspoint](https://www.tutorialspoint.com/java/java_exceptions)
* [vogella](https://www.vogella.com/tutorials/JUnit/article.html)



