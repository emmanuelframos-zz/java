package br.com.game.builder;

import br.com.game.model.Board;
import br.com.game.util.BoardUtil;

public class FilledBoardBuilder implements BoardBuilder {
	private Board board;
	
	public FilledBoardBuilder(int rows, int columns){
		this.board = new Board(rows, columns);
	}

	@Override
	public Board build() {	
		BoardUtil.initializeBoard(this.board);
		return this.board;
	}
}