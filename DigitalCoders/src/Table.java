import java.util.ArrayList;
import java.util.List;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	List<Card> crdwthplayrs;	// for cards with table and players cards also
	
	public void SetDeck(Card crd){
		crdOnTbl.add(crd);
	}
	public void showTablCrd(){
		for (Card crd : crdOnTbl) {
			crd.showCard();
		}
	}
	public Table() {
		crdOnTbl=new ArrayList<Card>();
		crdwthplayrs=new ArrayList<Card>();
	}
}
