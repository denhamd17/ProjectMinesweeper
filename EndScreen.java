package minesweeper;

import java.awt.*;

public class EndScreen extends EasyApp {
	
	Label message = addLabel("", 25, 25, 150, 50, this);
	Button back = addButton("Back", 75, 100, 50, 50, this);
	
	public EndScreen(boolean check) {
		setTitle("Minesweeper");
		setBounds(0, 0, 200, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		back.setBackground(new Color(0, 153, 204));
		back.setForeground(Color.BLACK);
		message.setFont(new Font("Arial", 0, 24));
		message.setForeground(Color.BLACK);
		
		if(!check) {
			message.setText("You Lost!");
		} else {
			message.setText("You Won!");
		}
	}
	
	public void actions (Object source, String command) {
		if (source == back) {
			new Start();
			dispose();
		}
	}
}
