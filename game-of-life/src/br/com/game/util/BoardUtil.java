package br.com.game.util;

import br.com.game.model.Board;
import br.com.game.model.Cell;

public class BoardUtil {
	
	public static void initializeBoard(Board board){
		for (int row = 0; row < board.getRows(); row++){
			for (int column = 0; column < board.getColumns(); column++){	
				board.addCell(new Cell(row, column, false));
			}
		}			
	}
}