package cracking;

/**
 * Created by NeelaGouda on 5/16/16.
 */
public class TicTacToe {

    private char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {

        board =new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j]='-';
            }
        }
    }
    

    private void printBoard(){
        System.out.println("-------------");

        for(int i=0; i<3; i++){
            System.out.print("| ");
            for(int j=0; j<3;j++){
                System.out.print(board[i][j] +" | ");

            }

            System.out.println();
            System.out.println("-------------");
        }
    }

    public void changePlayer(){
        if(currentPlayerMark == 'X'){
            currentPlayerMark = 'O';
        }
        else{
            currentPlayerMark = 'X';
        }
    }

    public boolean isBoardFull(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();

        ttt.printBoard();
    }


}
