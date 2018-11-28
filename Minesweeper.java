package minesweeper;

import java.awt.*;

public class Minesweeper extends EasyApp {

	Button back;
	Button reset;
	Button[][] tiles,tiles2;
	Label line,line2,line3;
	
	Label score1, score2, round;
	int scoreP1, scoreP2, roundnum;
	
	public Minesweeper(int rows, int columns, int scorep1, int scorep2, int roundnum) {
		this.roundnum=roundnum;
		scoreP1=scorep1;
		scoreP2=scorep2;
		
		setTitle("Minesweeper");
		
		int width =2 * 40 * rows + 15;
		int height = 40 * columns + 200;
		
		
		setBounds(0, 0, width + 5, height );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//exit button
		back = addButton("exit", 5, 40 * columns + 135, 100, 50, this);
		back.setBackground(new Color(0, 153, 204));
		back.setForeground(Color.BLACK);
		
		
		//lines
		line = addLabel("", 0, 40 * columns + 120, width, 5, this);
		line.setBackground(Color.BLACK);
		
		line2 = addLabel("", width/2,100, 5 , height, this);
		line2.setBackground(Color.BLACK);
		
		line3 = addLabel("", 0,  100, width, 5, this);
		line3.setBackground(Color.BLACK);
		
		//labels
		round = addLabel("Round "+roundnum+"/7", width/2-60, 50, 120, 50, this);
		round.setFont(new Font("Lucida",Font.PLAIN,24)); 
		round.setAlignment(Label.CENTER);
		
		score1 = addLabel("P1 : "+scorep1, 5, 0, width/2, 100, this);
		score1.setFont(new Font("Lucida",Font.PLAIN,24)); 
		
		score2 = addLabel(scorep2 +" : P2", width/2, 0, width/2, 100, this);
		score2.setFont(new Font("Lucida",Font.PLAIN,24)); 
		score2.setAlignment(Label.RIGHT);
		
		
		
		
		
		//player 1 tiles
		tiles = new Button[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tiles[i][j] = addButton("", 40 * i + 5, 40 * j + 115, 35, 35, this);
				tiles[i][j].setBackground(new Color(0, 153, 204));
				tiles[i][j].setForeground(Color.BLACK);

				if (Math.random() < 0.2) {
					tiles[i][j].setName("Bomb");
				}
			}
		}
		assign(tiles);
		
		//player 2 tiles
		tiles2 = new Button[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tiles2[i][j] = addButton("", 40 * i + 10 +width/2, 40 * j + 115, 35, 35, this);
				tiles2[i][j].setBackground(new Color(0, 153, 204));
				tiles2[i][j].setForeground(Color.BLACK);

				if (Math.random() < 0.2) {
					tiles2[i][j].setName("Bomb");
				}
			}
		}
		assign(tiles2);
	}

	public void assign(Button[][] tiles) {
		int bombCount = 0;

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (!(tiles[i][j].getName().equals("Bomb"))) {
					if (i - 1 >= 0 && j - 1 >= 0) {
						if (tiles[i - 1][j - 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (i - 1 >= 0) {
						if (tiles[i - 1][j].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (i - 1 >= 0 && j + 1 < tiles[0].length) {
						if (tiles[i - 1][j + 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (j - 1 >= 0) {
						if (tiles[i][j - 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (j + 1 < tiles[0].length) {
						if (tiles[i][j + 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (i + 1 < tiles.length && j - 1 >= 0) {
						if (tiles[i + 1][j - 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (i + 1 < tiles.length) {
						if (tiles[i + 1][j].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					if (i + 1 < tiles.length && j + 1 < tiles[0].length) {
						if (tiles[i + 1][j + 1].getName().equals("Bomb")) {
							bombCount++;
						}
					}

					tiles[i][j].setName("" + bombCount);
					bombCount = 0;
				}
			}
		}
	}

	public boolean check(Button[][] tiles) {
		boolean check = true;

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (!(tiles[i][j].getName().equals("Bomb")) && tiles[i][j].isEnabled()) {
					check = false;
					return check;
				}
			}
		}

		return check;
	}

	public void clearSurrounding(Button[][] tiles, int row, int column) {

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (!(tiles[row][column].getName().equals("Bomb"))) {
					if (row - 1 >= 0 && column - 1 >= 0) {
						if (!(tiles[row - 1][column - 1].getName().equals("Bomb")) && tiles[row-1][column-1].isEnabled()) {

							tiles[row - 1][column - 1].setLabel(tiles[row - 1][column - 1].getName());
							tiles[row - 1][column - 1].setBackground(Color.WHITE);
							tiles[row - 1][column - 1].setEnabled(false);

							if (tiles[row - 1][column - 1].getName().equals("0")) {
								clearSurrounding(tiles, row - 1, column - 1);
							}
						}
					}

					if (row - 1 >= 0) {
						if (!(tiles[row - 1][column].getName().equals("Bomb")) && tiles[row-1][column].isEnabled()) {

							tiles[row - 1][column].setLabel(tiles[row - 1][column].getName());
							tiles[row - 1][column].setBackground(Color.WHITE);
							tiles[row - 1][column].setEnabled(false);

							if (tiles[row - 1][column].getName().equals("0")) {
								clearSurrounding(tiles, row - 1, column);
							}
						}
					}

					if (row - 1 >= 0 && column + 1 < tiles[0].length) {
						if (!(tiles[row - 1][column + 1].getName().equals("Bomb")) && tiles[row-1][column+1].isEnabled()) {

							tiles[row - 1][column + 1].setLabel(tiles[row - 1][column + 1].getName());
							tiles[row - 1][column + 1].setBackground(Color.WHITE);
							tiles[row - 1][column + 1].setEnabled(false);

							if (tiles[row - 1][column + 1].getName().equals("0")) {
								clearSurrounding(tiles, row - 1, column + 1);
							}
						}
					}

					if (column - 1 >= 0) {
						if (!(tiles[row][column - 1].getName().equals("Bomb")) && tiles[row][column-1].isEnabled()) {

							tiles[row][column - 1].setLabel(tiles[row][column - 1].getName());
							tiles[row][column - 1].setBackground(Color.WHITE);
							tiles[row][column - 1].setEnabled(false);

							if (tiles[row][column - 1].getName().equals("0")) {
								clearSurrounding(tiles, row, column - 1);
							}
						}
					}

					if (column + 1 < tiles[0].length) {
						if (!(tiles[row][column + 1].getName().equals("Bomb")) && tiles[row][column+1].isEnabled()) {

							tiles[row][column + 1].setLabel(tiles[row][column + 1].getName());
							tiles[row][column + 1].setBackground(Color.WHITE);
							tiles[row][column + 1].setEnabled(false);

							if (tiles[row][column + 1].getName().equals("0")) {
								clearSurrounding(tiles, row, column + 1);
							}
						}
					}

					if (row + 1 < tiles.length && column - 1 >= 0) {
						if (!(tiles[row + 1][column - 1].getName().equals("Bomb")) && tiles[row+1][column-1].isEnabled()) {

							tiles[row + 1][column - 1].setLabel(tiles[row + 1][column - 1].getName());
							tiles[row + 1][column - 1].setBackground(Color.WHITE);
							tiles[row + 1][column - 1].setEnabled(false);

							if (tiles[row + 1][column - 1].getName().equals("0")) {
								clearSurrounding(tiles, row + 1, column - 1);
							}
						}
					}

					if (row + 1 < tiles.length) {
						if (!(tiles[row + 1][column].getName().equals("Bomb")) && tiles[row+1][column].isEnabled()) {

							tiles[row + 1][column].setLabel(tiles[row + 1][column].getName());
							tiles[row + 1][column].setBackground(Color.WHITE);
							tiles[row + 1][column].setEnabled(false);

							if (tiles[row + 1][column].getName().equals("0")) {
								clearSurrounding(tiles, row + 1, column);
							}
						}
					}

					if (row + 1 < tiles.length && column + 1 < tiles[0].length) {
						if (!(tiles[row + 1][column + 1].getName().equals("Bomb")) && tiles[row+1][column+1].isEnabled()) {

							tiles[row + 1][column + 1].setLabel(tiles[row + 1][column + 1].getName());
							tiles[row + 1][column + 1].setBackground(Color.WHITE);
							tiles[row + 1][column + 1].setEnabled(false);

							if (tiles[row + 1][column + 1].getName().equals("0")) {
								clearSurrounding(tiles, row + 1, column - 1);
							}
						}
					}
				}

			}
		}
	}

	public void actions(Object source, String command) {

		if (source == back) {
			new Start();
			dispose();
		}


		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (source == tiles[i][j]) {
					if (tiles[i][j].getName().equals("Bomb")) {
						if(roundnum == 7) {
							new EndScreen(false);
						}else {
							new Minesweeper(tiles.length,tiles.length,scoreP1+1,scoreP2,roundnum+1);
						}
						dispose();
					} else {
						tiles[i][j].setLabel(tiles[i][j].getName());
						tiles[i][j].setBackground(Color.WHITE);
						tiles[i][j].setEnabled(false);
						clearSurrounding(tiles, i, j);

						if (check(tiles)) {
							
							
							if(roundnum == 7) {
								new EndScreen(true);
							}else {
								new Minesweeper(tiles.length,tiles.length,scoreP1+1,scoreP2,roundnum+1);
							}
							
							
							dispose();
						}
					}
				}
			}
		}
	}
}
