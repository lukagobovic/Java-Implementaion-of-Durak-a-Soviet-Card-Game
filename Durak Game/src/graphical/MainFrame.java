package graphical;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import logic.*;
import main.*;

import java.util.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	DurakMain game = new DurakMain();
	final int WIDTH = 1920;
	final int HEIGHT = 1080;
	Color backgroundColor = new Color(39, 119, 20);
	Color buttonColor = new Color(255, 255, 255);
	Color grid = new Color(39, 119, 20);
	static Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 35);
	JFrame main = new JFrame();
	JButton bShuffle = new JButton();
	JButton bOver = new JButton();
	JButton bExit = new JButton();
	Board board;
	Image img = Toolkit.getDefaultToolkit().createImage("baccround.jpg");
	// card grid
	int gridX = 50;
	int gridY = 50;
	int gridW = 1250;
	int gridH = 168;

	// card dimensions
	int cardSpace = 10;
	int cardW = gridW / 12;
	int cardH = gridH;
	int cardActualWidth = cardW - 2 * cardSpace;
	int cardActualHeight = cardH - 2 * cardSpace;
	JLabel trump = new JLabel();
	

	public MainFrame() {
		
		try {
			buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("KREMLIN BOLSHEVIK.ttf")).deriveFont(30f);
		}
		catch (Exception e) {
			
		}
		
		board = new Board();
		game.playerHand.printArray();
		game.computerHand.printArray();

		
		
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("DURAK");
		this.setVisible(true);
		this.setBackground(Color.RED);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		board.add(bShuffle);
		board.add(bOver);
		board.add(bExit);

		ActShuffle aShuffle = new ActShuffle();
		ActOver aOver = new ActOver();
		ActExit aExit = new ActExit();

		this.setContentPane(board);
		this.setLayout(null);
		bShuffle.setBackground(buttonColor);
		bShuffle.setBounds(1600, 400, 200, 120);
		bShuffle.setText("Shuffle");
		bShuffle.setFont(buttonFont);
		bShuffle.addActionListener(aShuffle);

		bOver.setBackground(buttonColor);
		bOver.setBounds(1600, 200, 200, 120);
		bOver.setText("Over");
		bOver.setFont(buttonFont);
		bOver.addActionListener(aOver);

		bExit.setBackground(buttonColor);
		bExit.setBounds(1600, 600, 200, 120);
		bExit.setText("Exit");
		bExit.setFont(buttonFont);
		bExit.addActionListener(aExit);
		
	}

	public class Board extends JPanel {

		public void paintComponent(Graphics g) {

			g.drawImage(img, 0, 0, null);
			// computer hand
			g.setColor(Color.BLACK);
			//g.drawRect(gridX, gridY, gridW, gridH);

			// Piste
			//g.drawRect(gridX, gridY + gridH + 100, gridW, gridH * 2);

			// trump
			//g.drawRect(gridX + 1400, gridY, 110, gridH);
		//	g.drawImage(game.deck.trump.getImage(), gridX + 1400, gridY, 110, gridH, this);
            trump.setBounds(gridX + 1400, gridY, cardActualWidth, gridH);
            trump.setIcon(game.deck.trump.getImage());
            board.add(trump);
			// player hand
			//g.drawRect(gridX, 1080 - 268, gridW, gridH);

			// deck
			//g.drawRect(gridX + 1400, gridY + 700, 110, gridH);

//			for (int i = 0; i < 6; i++) {
//				g.drawImage(game.playerHand.getCardByIndex(i).getImage(), gridX + i * cardW + cardSpace,
//						gridY + cardSpace, cardActualWidth, cardActualHeight, this);
//				g.drawImage(game.computerHand.getCardByIndex(i).getImage(), gridY + i * cardW + cardSpace,
//						gridY + cardSpace + 762, cardActualWidth, cardActualHeight, this);
//			}

		}
	}

	public class ActShuffle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.computerHand.clear();
			game.playerHand.clear();
			game.setup();
			board.repaint();
		}
	}

	public class ActExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}

	public class ActOver implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public Card returnCard(Card card) {
		return card;
	}
}
