package br.com.game.model;

public class Cell {
	private int row;
	private int column;
	private boolean alive;
	
	public Cell(){}
	
	public Cell(int row, int column, boolean alive){
		this.row = row;
		this.column = column;
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "[Row = " + row + " Column = " + column + " Alive = " + alive + "]";
	}	
}