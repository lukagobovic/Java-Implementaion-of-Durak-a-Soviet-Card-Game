package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import graphical.*;

import graphical.MainFrame;
import graphical.MainFrame.ActShuffle;
import graphical.MainFrame.Board;
import logic.*;

public class DurakMain {

	public Hand playerHand;
	public Hand computerHand;
	public  Deck deck;
	private boolean playersTurn = true;
    private boolean playerHasDefended = false;
    private boolean endGame = false;
    private boolean quitGame = false;
	
	public DurakMain() {
		 playerHand = new Hand();
		 computerHand = new Hand();
		 deck = new Deck();
		boolean running = true;
		while(running) {
			setup();
			mainGame();
			running = false;

		}
	}
	
	public void setup() {
		deck.shuffle();
		System.out.println("Trump is: " + deck.setTrump());
		deck.reinsertTrump();
		for(int i = 0; i < 6; i ++) {
			playerHand.add(deck.deal());
			computerHand.add(deck.deal());
		}
		
	}
	public void initFrame() {
		
	}
	
	
	public void mainGame() {
		
	}
    
	
	public boolean isAllowedToHit(Card card) {
        for (int c = 0; c < deck.size(); c++) {
            Card temp = (Card) deck.cardAt(c);
            if (card.rank.getCardValue() == temp.rank.getCardValue()) {
                return true;
            }
        }
        return false;
    }
	
//	public boolean playersTurn() {
//        clickedCard = playerSelectedCardToHit();
//        if (clickedCard != null) {
//            table.add(clickedCard);
//            playersTurn = computerDefend(table);
//        }
//        return checkWinningConditions();
//    }
	
	 protected boolean checkWinningConditions() {
	        if (playerHand.getCardCount() == 0 && deck.getNumCardsLeft() == 0) {
	            return true;
	        }
	        if (computerHand.getCardCount() == 0 && deck.getNumCardsLeft() == 0) {
	            return true;
	        }
	        return false;
	    }
//	
//	 public Card playerSelectedCardToHit() {	
//	        if (deck.size() == 0) {
//	            playerHand.remove(clickedCard);
//	            return clickedCard;
//	        } else if (isAllowedToHit(clickedCard)) {
//	            playerHand.remove(clickedCard);
//	            return clickedCard;
//	        }
//	        return null;
//	    }
//	
	 
}
