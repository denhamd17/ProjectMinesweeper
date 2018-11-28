package minesweeper;

import java.awt.*;

public class Start extends EasyApp {

	public static void main(String[] args) {
		new Start();
	}

	Button times10 = addButton("Host", 100, 50, 100, 50, this);
	Button times15 = addButton("Client", 100, 200, 100, 50, this);
	//Button times20 = addButton("20x20", 100, 350, 100, 50, this);

	public Start() {
		setTitle("Minesweeper");
		setBounds(0, 0, 300, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		times10.setBackground(new Color(0, 153, 204));
		times15.setBackground(new Color(0, 153, 204));
		//times20.setBackground(new Color(0, 153, 204));
		times10.setForeground(Color.BLACK);
		times15.setForeground(Color.BLACK);
		//times20.setForeground(Color.BLACK);

	}

	public void actions(Object source, String command) {
		
		if (source == times10) {
			//host
			
			System.out.println("yeet");
			new Minesweeper(10, 10,0,0,1,false,new Server());
			dispose();
		}
		if (source == times15) {
			
			System.out.println("yeet");
			new Minesweeper(10, 10,0,0,1,false,new Client());
			dispose();
		}
//		if (source == times20) {
//			new Minesweeper(20, 20,0,0,1);
//			dispose();
//		}
	}

}
