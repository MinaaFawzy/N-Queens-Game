package project.os2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static project.os2.NQueen.repaint;

    public class RunnableQueen implements Runnable {

        
        int n;
        boolean flag;
        int row;
        JPanel Jboard[];
        RunnableQueen(int n,int row,JPanel Jboard[]) {
            this.n = n;
            this.row=row;
            this.Jboard=Jboard;
        }

        @Override
        public void run() {
            solve(row);
            
        }
        public void solve(int row) {

            boolean board[][] = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = false;
                }
            }

            BacktrackSolve(board, 0,row);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();System.out.println();
        }
        
        boolean BacktrackSolve(boolean board[][], int col,int row) {
            int tmp = 0;
            if (col >= n ) {
                return true;
            }
            if (col == 0) {
                tmp = row;
            }
            for (int i = tmp; i < n; i++) {

                if (isSafe(board, i, col)) {
                    board[i][col] = true;
                    repaint(Jboard, board, n, row);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NQueen.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (BacktrackSolve(board, col + 1,row) == true) {
                        return true;
                    }else{
                        if(col==0){
                            break;
                        }
                    }
                    board[i][col] = false; // BACKTRACK
                    repaint(Jboard, board, n, row);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NQueen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            return false;
        }

        public boolean isSafe(boolean board[][], int row, int col) {
            int i, j;
            for (i = 0; i < col; i++) {
                if (board[row][i]) {
                    return false;
                }
            }

            for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j]) {
                    return false;
                }
            }

            for (i = row, j = col; j >= 0 && i < n; i++, j--) {
                if (board[i][j]) {
                    return false;
                }
            }

            return true;
        }
    }
    
