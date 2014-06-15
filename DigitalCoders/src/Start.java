
public class Start {

	public static void main(String[] args) {
		System.out.println("hello world we are Digital Coders :))))");
		System.out.println("test 1 for github###");
		System.out.println("test 1 for github by chana");
		
		Deck d1=new Deck();
		//d1.showDeck();
		
		Hand hand1=new Hand(d1.getCard(0),d1.getCard(1));		
		Hand hand2=new Hand(d1.getCard(2),d1.getCard(3));
		Hand hand3=new Hand(d1.getCard(4),d1.getCard(5));
		Hand hand4=new Hand(d1.getCard(6),d1.getCard(7));
		Hand hand5=new Hand(d1.getCard(8),d1.getCard(9));
		Hand hand6=new Hand(d1.getCard(10),d1.getCard(11));
		
		hand1.showHand();
		hand2.showHand();
		hand3.showHand();
		hand4.showHand();
		hand5.showHand();
		hand6.showHand();
	}

}
