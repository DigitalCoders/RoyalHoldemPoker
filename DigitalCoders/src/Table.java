import java.util.ArrayList;
import java.util.List;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	double highsBet;
	
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
		highsBet=0;
	}
	public List<Card> getCrdOnTbl() {
		return crdOnTbl;
	}
	public double getHighsBet() {
		return highsBet;
	}
	public void setHighsBet(double highsBet) {
		this.highsBet = highsBet;
	}
	
}
