import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
    private static String[][] gameBoard;
    private static String[][] ships;

    public static void main(String[] args){
        gameBoard = new String[5][5];
        ships = new String[5][5];
        int count = 1;
        initializeGame();
        displayGameBoard();
        deployShips();
        do{
            makeMove();
            displayGameBoard();
            count++;
        }while(!gameWon() && !gameLost(count));
    }

    /**
     * Method to display game board
     * - print rows and columns
     */
    public static void displayGameBoard(){
        for(int row=0; row<=gameBoard.length-1; row++){
            if(row >0) {
//                System.out.println();
                System.out.println("----------------------");
            }

            for(int col=0; col<=gameBoard[row].length-1; col++){
//                if(row >0)//display row

                if(col < 4) {//display col
                    System.out.printf(" %s | ", gameBoard[row][col]);
                }
                else {
                    System.out.printf(" %s %n ", gameBoard[row][col]);
                }
            }
        }
    }

    /**
     * Method to initialize game board and ships multi-dimensional array
     */
    public static void initializeGame(){
        for(int row=0; row<=gameBoard.length-1; row++){

            for(int col=0; col<=gameBoard[row].length-1; col++){
                gameBoard[row][col] = " ";
                ships[row][col] = " ";
            }
        }
    }

    /**
     * Method to deploy ships
     * - generate random rows and column number
     * - add values to the ships array
     */
    public static void deployShips(){
        int row, col;
        SecureRandom rng = new SecureRandom();
        for(int count=5; count >0; count--){
            do{
            row = rng.nextInt(3)+1;
            col = rng.nextInt(3)+1;
            ships[row][col] = "S";
            } while(ships[row][col].equals(" "));
        }
    }

    /**
     * Method for players to make move
     * - get rows and columns from user
     */
    public static void makeMove(){
        int row, col;
        do{
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the row[1-5]: ");
        row = input.nextInt();
        System.out.print("Please enter the col[1-5]: ");
        col = input.nextInt();
        }while(invalidMove(--row, --col));

        if(ships[row][col].equals("S")) {
            gameBoard[row][col] = "S";
            System.out.println("You found a ship!!!");
        }
        else{
            gameBoard[row][col] = "X";
            System.out.println("Its a wrong tile");
        }
    }

    public static boolean invalidMove(int row, int col){
        if(row < 0 || row > 4 || col < 0 || col > 4 ){
            System.out.println("Please enter a value between 1 and 5");
            return true;
        }
        if(gameBoard[row][col].equals("S") || gameBoard[row][col].equals("X")){
            System.out.println("You have already hit this target.");
            return true;
        }
        else
            return false;
    }

    /**
     * Method to check if player has won game
     * - returns true if the player has won
     * - returns false if the player has lost
     * @return
     */
    public static boolean gameWon(){
        int numberOfShips = 0;
        for(int row=0; row<=ships.length-1; row++) {
            for (int col = 0; col <= ships[row].length - 1; col++) {
                if (ships[row][col] == gameBoard[row][col])
                    numberOfShips += 1;
            }
        }
            if (numberOfShips == 5)
                return true;
            else
                return false;
    }

    /**
     * Method to check if the player has lost game
     * - return true if count exceeded 10
     * - return false if count is below 10
     * @return
     */
    public static boolean gameLost(int count){
        if(count >10) {
            System.out.println("You have wasted more ammos. You lose!!!");
            return true;
        }
        else {
            return false;
        }
    }
}
