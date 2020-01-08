package graphical;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.*;

import logic.*;
import java.util.*;

public class MainFrame extends JFrame {
	
	final int WIDTH = 1920;
	final int HEIGHT = 1080;
	Color backgroundColor = new Color(39,119,20);
	Color buttonColor = new Color(204,204,0);
	Color grid = new Color(39,119,20);
	static Font buttonFont = new Font("Serif Bold", Font.PLAIN,50);
	JFrame main = new JFrame();
	JButton bShuffle = new JButton();
	JButton bOver = new JButton();
	JButton bExit = new JButton();
	
	
	//card grid
	int gridX = 50;
	int gridY = 50;
	int gridW = 1250;
	int gridH = 168;
	
	//card dimensions
	int cardSpace = 10;
	int cardW = gridW/12;
	int cardH = gridH;
	int cardActualWidth = cardW-2*cardSpace;
	int cardActualHeight = cardH-2*cardSpace;

		
	
	public MainFrame() {
		Board board = new Board();

		this.setSize(WIDTH,HEIGHT);
		this.setTitle("DURAK");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		board.add(bShuffle);
		board.add(bOver);
		board.add(bExit);
		


		ActShuffle aShuffle = new ActShuffle();
		ActShuffle aOver = new ActShuffle();
		ActShuffle aExit = new ActShuffle();


		this.setContentPane(board);
		this.setLayout(null);
		bShuffle.setBackground(buttonColor);
		bShuffle.setBounds(1600,400 , 200, 120);
		bShuffle.setText("Shuffle");
		bShuffle.setFont(buttonFont);
		bShuffle.addActionListener(aShuffle);
		
		bOver.setBackground(buttonColor);
		bOver.setBounds(1600,200 , 200, 120);
		bOver.setText("Over");
		bOver.setFont(buttonFont);
		bOver.addActionListener(aOver);
		
		bExit.setBackground(buttonColor);
		bExit.setBounds(1600,600 , 200, 120);
		bExit.setText("Exit");
		bExit.setFont(buttonFont);
		bExit.addActionListener(aExit);
		
	}
	
	public class Board extends JPanel{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, WIDTH, HEIGHT);

			//computer hand
			g.setColor(Color.BLACK);
			g.drawRect(gridX, gridY, gridW, gridH);
			
			//Piste
			g.drawRect(gridX, gridY+gridH+100, gridW, gridH*2);
			
			//trump
			g.drawRect(gridX+1400, gridY, 110, gridH);
			
			//player hand
			g.drawRect(gridX, 1080-268, gridW, gridH);
			
			//deck
			g.drawRect(gridX+1400, gridY+700, 110, gridH);
			
			
			for( int i = 0; i <12; i++) {
				g.drawRect(gridX+i*cardW+cardSpace, gridY+ cardSpace, cardActualWidth, cardActualHeight);
				g.drawRect(gridX+i*cardW+cardSpace, gridY+ cardSpace+762, cardActualWidth, cardActualHeight);
				
				
			}

		}
	}
	
	public class ActShuffle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public class ActExit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public class ActOver  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public Card returnCard(Card card) {
		return card;
	}
}
