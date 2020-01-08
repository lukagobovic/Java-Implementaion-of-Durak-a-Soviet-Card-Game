package logic;

import java.util.*;
import java.io.*;
import logic.Card.Rank;
import logic.Card.Suit;

public class ComputerHand {

	private ArrayList<Card> computerHand;
	
	
	public ComputerHand() {
		computerHand = new ArrayList<Card>(6);
	}
	
	public void add(Card c) {
		computerHand.add(c);
	}
	
	public void clear() {
		computerHand.clear();
	}
	public void removeCard(Card c) {
		computerHand.remove(c);
	}
	
	public int getCardCount() {
		return computerHand.size();
	}
	public void printArray() {
		for (int i = 0; i < 6; i++) {
			System.out.println(computerHand.get(i));
		}
	}

}
