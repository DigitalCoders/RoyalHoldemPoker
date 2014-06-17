
public class Card {
	private String suit = ""; // Suit of the card
	private String rank = ""; // Rank of the card
	private int suitID;
	private int rankID;

	private static String[] suits = { "hearts ", "spades", "diamonds", "clubs" }; // all suits
																					
	private static String[] ranks = { "10 ", "Jack", "Queen", "King" , "Ace"}; // all ranks

	Card(){
		this.rank="";
		this.suit="";
	}
	
	Card(int mySuit,int myRank) {
		this.rank = ranks[myRank];
		this.suit = suits[mySuit];
		this.suitID=mySuit;
		this.rankID=myRank+10;
	}
	
	public void showCard(){
		System.out.println("--------------------------");
		System.out.println(this.rank+" of "+this.suit);
		System.out.println("suit id "+suitID +"   rankid "+rankID+'\n');
		
	}
}
