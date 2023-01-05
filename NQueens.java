/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MCA;

/**
 *
 * @author HP
 */
public class NQueens {
    public static boolean isSafeToPlace(char board[][],int row,int col){
        //for vertical
        for(int i=row-1;i>=0;i--)
                if(board[i][col]=='Q')
                    return false;
        //left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')
                    return false;
        }
        //for right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<=board.length-1;i--,j++){
            if(board[i][j]=='Q')
                    return false;
        }
        
        
        return true;
    }
    public static void placeQueens(char board[][],int row){
        if(row==board.length){
            System.out.println("---------chess board---------");
            printBoard(board);
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafeToPlace(board,row,j)){
                board[row][j]='Q';
                placeQueens(board,row+1);
                board[row][j]='X';
            }
        }
    }
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String args[]){
        int n=5;
        char board[][]=new char[n][n];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++)
            board[i][j]='X';
        }
        placeQueens(board,0);
    }
}
