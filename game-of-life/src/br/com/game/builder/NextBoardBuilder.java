package br.com.game.builder;

import br.com.game.model.Board;
import br.com.game.util.BoardUtil;

public class NextBoardBuilder implements BoardBuilder {
	private Board oldBoard;

	public NextBoardBuilder(Board board){
		this.oldBoard = board;
	}

	@Override
	public Board build() {	
		Board newBoard = new Board(oldBoard.getRows(), oldBoard.getColumns());
		
		BoardUtil.initializeBoard(newBoard);

		for (int i = 0; i < oldBoard.getRows(); i++){
			for (int j = 0; j < oldBoard.getColumns(); j++){
				int neighborsAlive = 0;				

				if (oldBoard.isCellAlive(i-1, j-1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i-1, j))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i-1, j+1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i, j-1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i, j+1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i+1, j-1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i+1, j))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i+1, j+1))
					++neighborsAlive;

				if (oldBoard.isCellAlive(i, j)){
					if (neighborsAlive < 2)
						newBoard.addCell(i, j, false);

					if (neighborsAlive > 3)
						newBoard.addCell(i, j, false);				

					newBoard.addCell(i, j, true);
				}else{
					if (neighborsAlive == 3)
						newBoard.addCell(i, j, true);
				}
			}
		}
		return newBoard;
	}
}