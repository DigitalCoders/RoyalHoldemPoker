import java.util.ArrayList;
import java.util.List;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	double highsBet;
	boolean putBet=false;
	
	
	public boolean isPutBet() {
		return putBet;
	}
	public void setPutBet(boolean putBet) {
		this.putBet = putBet;
	}
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
		putBet=false;
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
