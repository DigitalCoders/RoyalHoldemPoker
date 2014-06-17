import java.util.ArrayList;
import java.util.List;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	
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
	}
	public List<Card> getCrdOnTbl() {
		return crdOnTbl;
	}
	
}
