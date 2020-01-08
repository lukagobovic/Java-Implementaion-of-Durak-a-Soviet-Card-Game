package logic;

import java.util.*;
import java.io.*;
import logic.Card.Rank;
import logic.Card.Suit;

public class Hand {

	private ArrayList<Card> cards;
	
	
	public Hand() {
		cards = new ArrayList<Card>(6);
	}
	
	public void add(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		cards.clear();
	}
	public void removeCard(Card c) {
		cards.remove(c);
	}
	
	public int getCardCount() {
		return cards.size();
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public Card getCardByIndex(int i) {
		return cards.get(i);
	}
	
	public Card useByIndex(int i) {
		return cards.get(i);
	}
	public void printArray() {
		for (int i = 0; i < 6; i++) {
			System.out.println(cards.get(i));
		}
	}
}
