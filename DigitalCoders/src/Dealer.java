import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class Dealer {
	Deck cardDeck;	// d=reference to card deck
	double betCollection;	// total money for bet 	
	double bgBlind;
	public static int crdpostn=0;
	private ArrayList<Card> allCards;


	public Dealer() {
		allCards = new ArrayList<Card>();

		for (short suit=0; suit<=3; suit++)		//go through 4 suits
		{
			for (short rank=0; rank<=4; rank++)		//go through 5 ranks
			{
				allCards.add( new Card(suit,rank) );		//add new card to allCard Array
			}
		}

		Collections.shuffle(allCards);	//Shuffling the card deck

		betCollection=0;
		crdpostn=0;
		bgBlind=0;
	}
	public double getBgBlind() {
		return bgBlind;
	}
	public void setBgBlind(double bgBlind) {
		this.bgBlind = bgBlind;
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
	public Card getNextCard(){
		Card nxtcrd= allCards.get(crdpostn);
		crdpostn++;
		return nxtcrd;
	}
	public double getBetCollection() {
		return betCollection;
	}
	public void addTobetCollctn(double bet){
		betCollection+=bet;
		System.out.println("	current money in hand of dealer"+betCollection);
	}

}
