import java.util.Scanner;

public class TicTacToe {
    private static String[][] gameBoard;
    private static String currentPlayer;
    public static void main(String[] args)
    {
        gameBoard = new String[3][3];
        currentPlayer = "X";
        initializeGameBoard();
        do{
            displayGameBoard();
            makeMove();
        }while(!gameWon());

        displayGameBoard();
    }

    /**
     * Method to display the game board on the console
     * using the multidimensional-array gameBoard
     */
    public static void displayGameBoard(){
        for(int row=0; row<=gameBoard.length-1; row++){
                if(row >0)
                    System.out.println("-------------------");
            for(int col=0; col<=gameBoard[row].length-1; col++){
                if(col <2)
                    System.out.printf("  %s | ", gameBoard[row][col]);
                else
                    System.out.printf("  %s %n ", gameBoard[row][col]);
            }
        }
    }

    /**
     * Method to initialize gameBoard.
     * -Make the null values to empty
     */
    public static void initializeGameBoard(){
        for(int row=0; row<=gameBoard.length-1; row++){

            for(int col=0; col<=gameBoard[row].length-1; col++){

                gameBoard[row][col] = " ";
            }
        }
    }

    /**
     * Method for players to make move
     * - check if the user makes valid move
     * - Change player turns
     */
    public static void makeMove(){
        int row, col;
        do{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the row number[1-3]");
            row = input.nextInt();
            System.out.print("Enter the col number[1-3]");
            col = input.nextInt();
        }while (invalidMove(--row, --col));

        gameBoard[row][col] = currentPlayer;

        if(currentPlayer.equals("X"))
            currentPlayer = "O";
        else
            currentPlayer = "X";
    }

    /**
     * Method to check if the move player makes is valid
     * - check if row and col values is greater than 0 and less than 2
     * - check if the position already has a value
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean invalidMove(int row, int col){
        if(row < 0 || row > 2 || col < 0 || col > 2){
            System.out.println("Please enter a value between 1 and 3");
            return true;
        }
        if (!gameBoard[row][col].equals(" ")) //The position is not a space and therefore not free
        {
            System.out.println("The position is already filled");
            return true;
        }
        else
            return false;
    }

    /**
     * Method to check if the game is won
     * - check each row
     * - check each col
     * - check diagonally
     * @return
     */
    public static boolean gameWon(){
        // check each row
        for (int row=0; row <= gameBoard.length-1; row++){
            if(gameBoard[row][0].equals(gameBoard[row][1]) && gameBoard[row][1].equals(gameBoard[row][2])
                    && !gameBoard[row][0].equals(" ")){
                System.out.printf("The winner is %s %n", gameBoard[row][0]);
                return true;
            }
        }

        // check each col
        for (int col=0; col <= gameBoard.length-1; col++){
            if(gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[2][col].equals(gameBoard[0][col])
                    && !gameBoard[0][col].equals(" ")){
                System.out.printf("The winner is %s %n", gameBoard[0][col]);
                return true;
            }
        }
        // check from upper-left to lower-right
        if(gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])
                && !gameBoard[0][0].equals(" ")){
            System.out.printf("The winner is %s %n", gameBoard[0][0]);
            return true;
        }
        // check from upper-right to lower-left
        if(gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])
                && !gameBoard[0][2].equals(" ")){
            System.out.printf("The winner is %s %n", gameBoard[0][2]);
            return true;
        }
        else
            return false;
    }
}
