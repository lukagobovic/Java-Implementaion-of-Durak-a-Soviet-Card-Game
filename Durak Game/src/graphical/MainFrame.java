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

import javafx.scene.layout.Border;
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
	ActShuffle aShuffle = new ActShuffle();
	ActOver aOver = new ActOver();
	ActExit aExit = new ActExit();
	
	Board board;
	Image img = Toolkit.getDefaultToolkit().createImage("baccround.jpg");
	ImageIcon cardBack = new ImageIcon("back.png");
	// card grid
	int gridX = 50;
	int gridY = 50;
	int gridW = 1250;
	int gridH = 168;

	// card dimensions
	int cardSpace = 10;
	int cardW = gridW / 12;
	int cardH = gridH;
	int cardActualWidth = 110;
	int cardActualHeight = 148;
	
	JButton trump = new JButton();
	JButton deck = new JButton();
	
	ArrayList<JButton> playerCards = new ArrayList<JButton>();
	ArrayList<JButton> computerCards = new ArrayList<JButton>();
	javax.swing.border.Border emptyBorder = BorderFactory.createEmptyBorder();

	public MainFrame() {
		
		try {
			buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("KREMLIN BOLSHEVIK.ttf")).deriveFont(30f);
		}
		catch (Exception e) {
			
		}
		
		board = new Board();
		game.playerHand.printArray();
		game.computerHand.printArray();

		for(int x = 0; x < 12; x ++) {
			JButton button = new JButton();
			button.setContentAreaFilled(false);
			button.setBorder(emptyBorder);
			playerCards.add(button);
		}
		for(int x = 0; x < 12; x ++) {
			JButton button = new JButton();
			button.setContentAreaFilled(false);
			button.setBorder(emptyBorder);
			computerCards.add(button);
		}
		
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("DURAK");
		this.setVisible(true);
		this.setBackground(Color.RED);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		board.add(bShuffle);
		board.add(bOver);
		board.add(bExit);

		

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
			// Piste
			//g.drawRect(gridX, gridY + gridH + 100, gridW, gridH * 2);
            trump.setBounds(gridX + 1400, gridY, cardActualWidth, gridH);
            trump.setIcon(game.deck.trump.getImage());
            trump.setBorder(emptyBorder);
            trump.setContentAreaFilled(false);
            board.add(trump);
			//deck
            deck.setBounds(gridX + 1400, gridY + 762 , 110, gridH);
            deck.setIcon(cardBack);
            deck.setBorder(emptyBorder);
            deck.setContentAreaFilled(false);
            board.add(deck);
            

			for (int i = 0; i < 6; i++) {
				playerCards.get(i).setBounds(gridX + i * cardW + cardSpace, gridY + 10, cardActualWidth, cardActualHeight);
				playerCards.get(i).setIcon(game.playerHand.getCardByIndex(i).getImage());
				//playerCards.get(i).addActionListener();
				board.add(playerCards.get(i));
				
				computerCards.get(i).setBounds(gridX + i * cardW + cardSpace, gridY + 10 + 762, cardActualWidth, cardActualHeight);
				computerCards.get(i).setIcon(cardBack);
				board.add(computerCards.get(i));
				
			}

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
