package br.com.game;
import org.junit.Assert;
import org.junit.Test;

import br.com.game.builder.FilledBoardBuilder;
import br.com.game.builder.NextBoardBuilder;
import br.com.game.model.Board;


public class TheGameOfLifeTest {
	private final int rows = 4;
	private final int columns = 5;
	
	@Test
	public void testIsCellValid(){
		Board board = new FilledBoardBuilder(rows, columns).build();
		
		Assert.assertFalse(board.isCellValid(-1, 0));
		Assert.assertFalse(board.isCellValid(0, -1));
		Assert.assertFalse(board.isCellValid(5, 0));
		Assert.assertFalse(board.isCellValid(0, 6));
		
		board.addCell(0, 0, null);
		Assert.assertFalse(board.isCellValid(0, 0));	
	}

	@Test
	public void testGameOfLife(){
		Board board = new FilledBoardBuilder(rows, columns).build();
		board.putAlive(1, 2, true);
		board.putAlive(1, 3, true);
		board.putAlive(2, 1, true);
		board.putAlive(2, 2, true);
		board.putAlive(2, 3, true);
		
		Board newBoard = new NextBoardBuilder(board).build();
		
		Assert.assertTrue(board.getRows() == newBoard.getRows());
		Assert.assertTrue(board.getColumns() == newBoard.getColumns());
		
		Assert.assertTrue(newBoard.get(1, 1).isAlive());
		Assert.assertTrue(newBoard.get(1, 3).isAlive());
		Assert.assertTrue(newBoard.get(2, 1).isAlive());
		Assert.assertTrue(newBoard.get(2, 3).isAlive());
		Assert.assertTrue(newBoard.get(3, 2).isAlive());	

		newBoard = new NextBoardBuilder(board).build();
		Assert.assertTrue(newBoard.get(2, 1).isAlive());
		Assert.assertTrue(newBoard.get(2, 3).isAlive());
		Assert.assertTrue(newBoard.get(3, 2).isAlive());
		
		newBoard = new NextBoardBuilder(board).build();
		Assert.assertTrue(newBoard.get(2, 2).isAlive());
		Assert.assertTrue(newBoard.get(3, 2).isAlive());			
	}
}