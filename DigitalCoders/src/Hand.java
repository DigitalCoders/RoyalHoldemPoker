
public class Hand {
	Card c1=new Card();
	Card c2=new Card();
	
	int cash=100;
	
	Hand(Card card1,Card card2){
		c1=card1; c2=card2;
	}
	
	public void showHand(){
		System.out.println("------------");
		this.c1.showCard();
		this.c2.showCard();
		System.out.println("------------");
	}
}
