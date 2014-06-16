
public class Player {
	Card crd1;
	Card crd2;
	boolean smlBlnd=false;
	boolean bgBlnd=false;
	double cash=250;
	
	public void set1StCard(Card crd){
		crd1=crd;		
	}
	public void set2NdCard(Card crd){
		crd2=crd;		
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

}
