package br.com.game.model;

public class Board {
	private int rows;
	private int columns;
	private Cell[][] cells;

	public Board(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		cells = new Cell[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public void addCell(Cell cell){		
		this.cells[cell.getRow()][cell.getColumn()] = cell;
	}

	public void addCell(int x, int y, boolean alive){		
		this.cells[x][y] = new Cell(x , y, alive);		
	}

	public void addCell(int x, int y, Cell cell){		
		this.cells[x][y] = cell;		
	}

	public void putAlive(int x, int y, boolean alive){
		if (isCellValid(x, y))
			this.cells[x][y].setAlive(alive); 	
	}

	public Cell get(int x, int y){
		if (isCellValid(x, y)){
			return cells[x][y];
		}
		return null;
	}

	public boolean isCellAlive(int x, int y){
		if (isCellValid(x, y)){
			Cell cell = get(x, y);
			return cell != null && cell.isAlive();
		}else{
			return false;
		}
	}

	public boolean isCellValid(int x, int y){
		boolean conditionSatisfied = (x >= 0 && y >= 0 && x <= rows-1 && y <= columns-1);

		if (conditionSatisfied)
			return cells[x][y] != null;
		else
			return false;		
	}
}