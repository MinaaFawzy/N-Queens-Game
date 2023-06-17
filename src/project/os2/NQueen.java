package project.os2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NQueen extends javax.swing.JFrame {

    HomePage h = new HomePage();

    NQueen(int e) throws InterruptedException {

        JPanel[] board = new JPanel[e];
        System.out.println(e);
        JLabel Imagelabel = new JLabel();
        Imagelabel.setIcon(new ImageIcon("Queen.png"));
        int height, weight;
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        height = 600;
        weight = 1000;
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, e / 2, 10, 10));

        JPanel[][] pane = new JPanel[e][e];

        for (int h = 0; h < e; h++) {
            board[h] = new JPanel();
            board[h].setLayout(new GridLayout(e, e));
            for (int i = 0; i < e; i++) {
                for (int j = 0; j < e; j++) {
                    pane[i][j] = new JPanel();
                    pane[i][j].setSize(50, 50);
                    if ((i + j) % 2 == 0) {
                        pane[i][j].setBackground(Color.black);
                    } else {
                        pane[i][j].setBackground(Color.LIGHT_GRAY);
                    }
                    board[h].add(pane[i][j]);
                }
            }
            contentPane.add(board[h]);
        }
        setContentPane(contentPane);
        setSize(weight, height);
        Threading t=new Threading(e,board);
    }

    public static void repaint(JPanel board[], boolean board2[][], int e, int numBoard) {
        JPanel[][] pane = new JPanel[e][e];        
        board[numBoard].removeAll();
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < e; j++) {
                pane[i][j] = new JPanel();
                pane[i][j].setSize(50, 50);
                if (board2[i][j]) {
                   board[numBoard].remove(pane[i][j]);
                   pane[i][j].setBackground(Color.blue);
                   board[numBoard].revalidate();

                } else {
                    if ((i + j) % 2 == 0) {
                        pane[i][j].setBackground(Color.black);
                    } else {
                        pane[i][j].setBackground(Color.white);
                    }
                }
                board[numBoard].add(pane[i][j]);
                
            }
        }
    }

    NQueen() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Board");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(1650, 1080));
        setSize(getPreferredSize());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1650, 1080));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NQueen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NQueen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NQueen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NQueen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NQueen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
