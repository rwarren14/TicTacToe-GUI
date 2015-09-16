package edu.jsu.mcis;
import java.io.*;
import java.util.*;

public class TicTacToe {
   
   public enum Mark {
      X,O,TIE,EMPTY;
      
   }
   
   Mark[][] board = new Mark[3][3];
   int turnCounter = 0;
   Mark selectedMark;
   
   public TicTacToe(){
      for(int row = 0; row < 3; row++){
         for(int col = 0; col < 3; col++){
            board[row][col] = Mark.EMPTY;
         }
      
      }
   
   }
   
   public Mark getMark(int row, int col){
      return board[row][col];
   }
   
   public void setMark(int row, int col){
      if(checkAvailbility(row,col)){
         if(turnCounter == 0){
            selectedMark = Mark.X;
            turnCounter++;
         
         }
         else if(turnCounter == 1){
            selectedMark = Mark.O;
            turnCounter--;
            
         }
         
         board[row][col] = selectedMark;
      }
      
      else{
         System.out.println("Incorrect move, Try again!");
      
      }
   
   }
   
   public boolean checkAvailbility(int row, int col){
      if(board[row][col] == Mark.EMPTY) {
         return true;
      }
      return false;
   }
      
      
	   
   
   
   public Mark winConditions(){
      if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != Mark.EMPTY){
         return board[0][0];
      
      }
      
      else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != Mark.EMPTY){
         return board[1][0];
         
      }
      
      else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != Mark.EMPTY){
         return board[2][0];
      
      }
      
      else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != Mark.EMPTY){
         return board[0][0];
      
      }
      
      else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != Mark.EMPTY){
         return board[0][1];
         
      }
      
      else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != Mark.EMPTY){
         return board[0][2];
         
      }
      
      else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Mark.EMPTY){
         return board[0][0];
      }
      
      else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Mark.EMPTY){
         return board[0][2];
      }
      
      else{
         return Mark.EMPTY;
      }
   
   }
   
   
   public boolean Full(){
      for(int row = 0; row < 3; row++){
         for(int col = 0; col < 3; col++){
            if (board[row][col] == TicTacToe.Mark.EMPTY){
               return false;
               
            }
         }
      }
      return true;
   }
   
   public boolean checkTie(){
      if(winConditions() == Mark.EMPTY && Full()){
         return true;
      }
      return false;
   }
   
   public void printBoardToScreen(){
      for(int row = 0; row < 3; row++){
         for(int col = 0; col < 3; col++){
            if(checkAvailbility(row, col)){
               System.out.print("=");
            }
            else{
               System.out.print(board[row][col]);
               
            }
            if(col < 2){
               System.out.print("|");
            }
         }
         if(row < 2){
            System.out.println();
            System.out.println("========");
         }
      }
   }
   
   public void getCoordinates(){
      Scanner userInput = new Scanner(System.in);
      System.out.println();
      System.out.println("Enter a grid (0-2) ex: 1 2");
      int rowCoordinateInput = Integer.valueOf(userInput.next());
      int colCoordinateInput = Integer.valueOf(userInput.next());
      setMark(rowCoordinateInput, colCoordinateInput);
   
   }
   
   public void resetBoard(){
      for(int row = 0; row < 3; row++){
         for(int col = 0; col < 3; col ++){
            board[row][col] = Mark.EMPTY;
         }
      }
   }
   
   public void gLoop(){
      int contCheck = 0;
      while(contCheck == 0){
         printBoardToScreen();
         getCoordinates(); 
         if(winConditions() == Mark.X){
            System.out.println("Player X wins.");
            contCheck = 1;
         }
         else if(winConditions() == Mark.O){
            System.out.println("Player O wins.");
            contCheck = 1;
         } 
      }
      checkTie();
   }
   public static void main(String[] args) {
      TicTacToe game = new TicTacToe();
      game.gLoop(); 
   }   
   
   
}
