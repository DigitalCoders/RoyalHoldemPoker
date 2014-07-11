import java.util.ArrayList;
import java.util.List;


public class Table {
	List<Card> crdOnTbl;		//for table cards 5
	double highsBet;
	boolean putBet=false;
	boolean check=false;
	int pntOfRaise=0;
	
	
	public int getPntOfRaise() {
		System.out.println("============================= pont of player="+pntOfRaise);
		return pntOfRaise;
	}
	public void setPntOfRaise(int pntOfRaise) {
		
		this.pntOfRaise = pntOfRaise;
		System.out.println("============================= pont of player="+pntOfRaise);
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
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
		pntOfRaise=0;
		putBet=false;
		check=false;
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
