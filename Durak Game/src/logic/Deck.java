package logic;

import java.io.IOException;
import java.util.*;

import logic.Card.Rank;
import logic.Card.Suit;

public class Deck  {

	public Card trump;
	public  Card[] deckOfCards;
	public ArrayList<Card> playedCards;
	private static final int NCARDS = 36;
	private Suit trumpCardSuit;
	private Rank trumpCardRank;
	public int tSuit, tRank;
	private int top = 35;
	public Hand hand = new Hand();

	
	public Deck()  {
		deckOfCards = new Card[NCARDS];
		this.playedCards = new ArrayList<Card>(0);
		int i = 0;
		for(int rank = 6; rank <= 14; rank++) {
			for(int suit = 1; suit <= 4; suit++) {
				deckOfCards[i] = new Card(suit, rank);
				i++;
			}
		}
		
	}

	public  Card[] shuffle() {
		for ( int i = deckOfCards.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[rand];
            deckOfCards[rand] = temp;
        }
		return deckOfCards;
	}

	public Card setTrump() {
		Random random = new Random();
		Suit tempSuit = (Suit) (Suit.values()[random.nextInt(Suit.values().length)]);
		Rank tempRank = (Rank) (Rank.values()[random.nextInt(Rank.values().length)]);
		trumpCardSuit = tempSuit;
	    trumpCardRank = tempRank;
	    if(trumpCardSuit == Suit.CLUBS) {
			this.tSuit = 1;
		}
		else if(trumpCardSuit == Suit.DIAMONDS) {
			this.tSuit = 2;
		}
		else if(trumpCardSuit == Suit.HEARTS) {
			this.tSuit = 3;
		}
		else if(trumpCardSuit == Suit.SPADES) {
			this.tSuit = 4;
		}
	    tRank = trumpCardRank.getCardValue();
	    trump = new Card(trumpCardSuit, trumpCardRank);
	    trump = new Card(tSuit, tRank);
	    return trump;
	}
	
	public Card[] reinsertTrump(){
		for(int i = 0; i < deckOfCards.length; i ++) {
			if(trump.equals(deckOfCards[i])) {
				Card temp = deckOfCards[0];
			    deckOfCards[0] = deckOfCards[i];
			    deckOfCards[i] = temp;
			}
		}
		return deckOfCards;
	}

	public Card deal() {
		Card card;
		card = deckOfCards[top];
		hand.add(deckOfCards[top]);
		top--;
		return card;
		}
		
    public boolean isEmpty() {
    	return deckOfCards.length == 0;
    }
    
    public int size() {
    	return deckOfCards.length;
    }
	
	public void printArray() {
		for (int i = 0; i < NCARDS; i++) {
			System.out.println(deckOfCards[i]);
		}
	}
	
	public Card cardAt(int c) {
		return deckOfCards[c];
	}
	
	public int getNumCardsLeft() {
		return deckOfCards.length - top;
	}
	
}


