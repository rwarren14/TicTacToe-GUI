package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
   @Test
   public void testInitialBoardIsEmpty() {
      TicTacToe t = new TicTacToe();
      Boolean isEmpty = true;
      for (int row = 0; row < 3; row++){
         for(int col = 0; col < 3; col++){
            if(t.board[row][col] != TicTacToe.Mark.EMPTY){
               isEmpty = false;
            }
            
           
         }
      }
      assertTrue(isEmpty);
   }
	
   @Test
   public void testMarkXInUpperRightCorner() {
   
      TicTacToe game = new TicTacToe();
      game.setMark(0,2);
       assertEquals(TicTacToe.Mark.X, game.getMark(0,2));
   }
	
   @Test
   public void testMarkOInBottomLeftCorner() {
       TicTacToe game = new TicTacToe();
      game.setMark(2,0);
       assertEquals(TicTacToe.Mark.X, game.getMark(2,0));
   }
	
   @Test
   public void testUnableToMarkOverExistingMark() {
      TicTacToe game = new TicTacToe();
      game.setMark(0,0);
      assertEquals(false, game.checkAvailbility(0,0));
   }
	
   @Test
   public void testGameIsNotOverAfterTheFirstMark() {
      TicTacToe game = new TicTacToe();
      game.setMark(0,0);
      assertEquals(TicTacToe.Mark.EMPTY, game.winConditions());
      assertFalse(game.checkTie());
   }
	
   @Test
   public void testGameIsWonByXHorizontallyAcrossTopRow() {
      TicTacToe game = new TicTacToe();
      game.board[0][0] = TicTacToe.Mark.X;
      game.board[0][1] = TicTacToe.Mark.X;
      game.board[0][2] = TicTacToe.Mark.X;
      assertEquals(TicTacToe.Mark.X, game.winConditions());
      game.resetBoard();
   }
	
   @Test
   public void testGameIsOverByTieIfAllLocationsAreFilled() {
      TicTacToe game = new TicTacToe();
      game.board[0][0] = TicTacToe.Mark.X;
      game.board[0][1] = TicTacToe.Mark.X; 
      game.board[0][2] = TicTacToe.Mark.O;
      game.board[1][0] = TicTacToe.Mark.O;
      game.board[1][1] = TicTacToe.Mark.O;
      game.board[1][2] = TicTacToe.Mark.X;
      game.board[2][0] = TicTacToe.Mark.X;
      game.board[2][1] = TicTacToe.Mark.X;
      game.board[2][2] = TicTacToe.Mark.O;
      game.board[1][0] = TicTacToe.Mark.O;
      assertEquals(true, game.checkTie());
      game.board[0][2] = TicTacToe.Mark.X;
      assertEquals(false, game.checkTie());
      
   }	
}
