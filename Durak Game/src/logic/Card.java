package logic;

import javax.swing.ImageIcon;



public class Card {

	
	public Suit trumpCardSuit;
    public Rank trumpCardRank;
    public Suit suit;
    public Rank rank;
    public boolean visible;
    public static ImageIcon image;
	public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};
	public enum Rank {SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

	    private int cardValue;

	    private Rank(final int cardValue) {
	        this.cardValue = cardValue;
	    }

	    public int getCardValue() {
	        return cardValue;
	    }
	}
	
	public Card(int suits, int ranks) {
		if(suits == 1) {
			this.suit = Suit.CLUBS;
		}
		else if(suits == 2) {
			this.suit = Suit.DIAMONDS;
		}
		else if(suits == 3) {
			this.suit = Suit.HEARTS;
		}
		else if(suits == 4) {
			this.suit = Suit.SPADES;
		}
		for (Rank r : Rank.values()) {
            if (r.getCardValue() == ranks) {
                this.rank = r;
            }
        }
    	String imageFileName = "" + ranks + "CDHS".charAt(suits-1)  +".png";
		imageFileName = "cardPictures\\" + imageFileName;		
		image = new ImageIcon(imageFileName);
	}
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
	    this.rank = rank;
		this.trumpCardRank = rank;
		this.trumpCardSuit = suit;

	}
	public  String toString(){
	    return (suit + " of " + rank);
	}
	
	public static ImageIcon getImage() {
		return image;
	}
	
//	public void draw(Graphics g) {
//	    g.drawImage(image, 220, 336, null);
//	}
	
	public boolean equals(Object obj) {
		Card other = (Card) obj;
		return other.rank == this.rank && other.suit == this.suit;
	} 
	
	
}
