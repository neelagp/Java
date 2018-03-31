package cracking;

/**
 * Created by NeelaGouda on 5/17/16.
 */
public class ZeroMatrix {

    private int[][] board;
    private int row;
    private int col;

    public ZeroMatrix(int m, int n) {
        this.board = new int[m][n];
        this.row = m;
        this.col = n;
        initializeBoard();
    }

    public void initializeBoard(){
        for(int i=0; i<row; ++i ){
            for(int j=0; j<col; ++j){
                board[i][j]= 1;
            }
        }
    }

    public void printBoard(){

        System.out.println("---------------------");
        for(int i=0; i<row; i++ ){
            System.out.print("| ");
            for(int j=0; j<col; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }

    }

    public void set( int x , int y){
        for(int i=0; i< col; i++){
            board[x][i] = 0;
        }

        for (int j =0; j< row; j++){
            board[j][y] = 0;
        }
    }

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix(5,5);
        zeroMatrix.printBoard();
        zeroMatrix.set(2,3);
        zeroMatrix.printBoard();
    }
}
