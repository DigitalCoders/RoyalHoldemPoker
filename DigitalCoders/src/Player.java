
public class Player {
	Card crd1;
	Card crd2;
	boolean smlBlnd=false;
	boolean bgBlnd=false;
	double cash=250;
	int rankOfHand;
	
	public void set1StCard(Card crd){
		crd1=crd;		
	}
	public void set2NdCard(Card crd){
		crd2=crd;		
	}
	
	public Card getCrd1() {
		return crd1;
	}
	public void setCrd1(Card crd1) {
		this.crd1 = crd1;
	}
	public Card getCrd2() {
		return crd2;
	}
	public void setCrd2(Card crd2) {
		this.crd2 = crd2;
	}
	public void shwCardPlyr(){
		crd1.showCard();
		crd2.showCard();
	}
	public boolean isSmlblnd(){
		return smlBlnd;
	}
	public boolean bgBlbnd(){
		return bgBlbnd();
	}
	public void setSmlBlnd(boolean smlBlnd) {
		this.smlBlnd = smlBlnd;
	}
	public void setBgBlnd(boolean bgBlnd) {
		this.bgBlnd = bgBlnd;
	}
	public int getRankOfHand() {
		return rankOfHand;
	}
	public void setRankOfHand(int rankOfHand) {
		this.rankOfHand = rankOfHand;
	}

}
