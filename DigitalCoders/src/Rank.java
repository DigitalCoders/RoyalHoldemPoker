import java.util.ArrayList;
import java.util.List;


public class Rank {

	public int chkRank(List<Card> tblcrds,Card crd1,Card crd2){
		int rank=0;
		ArrayList<Card> cardSet=(ArrayList<Card>) tblcrds;	// add all the cards (table cards and players card) to list
		cardSet.add(crd1);
		cardSet.add(crd2);
		
		for (Card card : cardSet) {		//to print outh the cards
			card.showCard();
			
		}
		return rank;
	}
	
}
