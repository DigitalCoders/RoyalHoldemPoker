
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck {
	private ArrayList<Card> allCards;	//ArrayList that holds all 20 cards for Royal Hold'em
	
	Deck(){
		allCards = new ArrayList<Card>();
		
		for (short suit=0; suit<=3; suit++)		//go through 4 suits
		{
			for (short rank=0; rank<=4; rank++)		//go through 5 ranks
			 {
			   allCards.add( new Card(suit,rank) );		//add new card to allCard Array
			 }
		}
		
		Collections.shuffle(allCards);	//Shuffling the card deck
	}
	public void shuffleDeck(){
		Collections.shuffle(allCards);	//Shuffling the card deck
	}
	
	public void showDeck(){
		Iterator<Card> iterator = allCards.iterator();
		while (iterator.hasNext()) {
			iterator.next().showCard();
		}
	}
	
	public Card getCard(int cardNo){
		
		return allCards.get(cardNo);
	}
}
