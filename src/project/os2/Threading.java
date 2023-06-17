package project.os2;

import javax.swing.JPanel;

public class Threading extends RunnableQueen{
    int n;
    JPanel Jboard[];
    Threading(int n,JPanel board[]) throws InterruptedException{
        super(n,0,board);
        Thread r[ ]= new Thread[n];
        this.Jboard=board;
        this.n=n;
        

        for (int i = 0; i < n; i++){
            r[i]=new Thread(new RunnableQueen(n,i,board));
            r[i].start();
        }
    }
}
