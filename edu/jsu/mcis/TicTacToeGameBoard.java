package edu.jsu.mcis;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author robertwarren
 */
public class TicTacToeGameBoard extends JFrame{
   
   private JButton[][] buttons = new JButton[3][3];
   TicTacToe Board = new TicTacToe();
   
   public TicTacToeGameBoard(){
      guiBoard();
     
     
     
   }
   
   private void guiBoard(){
      JFrame mainBoard = new JFrame("TIC-TAC-TOE");
      mainBoard.setSize(475,475);
      mainBoard.setLayout(new GridLayout(3,3));
      mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(int i = 0; i < 3; i++){
         for(int j =0; j < 3; j++){
            buttons[i][j] = new JButton("----");
            buttons[i][j].setName("Location" + i + j);
            buttons[i][j].addActionListener(new ButtonListener(i,j));
            buttons[i][j].setFont(new Font("", Font.PLAIN, 55));
            buttons[i][j].setBorderPainted(false);
            mainBoard.add(buttons[i][j]);
            
            
         }
      }
      mainBoard.setVisible(true);
      
   }
   
   private class ButtonListener implements ActionListener{
      private int row;
      private int col;
      
      public ButtonListener(int i, int j){
         row = i;
         col = j;
         
      }
      
      public void actionPerformed(ActionEvent e){
         buttonPress(row, col);
         
      }
   }
   
   private void buttonPress(int row, int col){
      gameBoard.setMark(row, col);
      
   }
   

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
   
      TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard();
      
      
   }
   
   
}
