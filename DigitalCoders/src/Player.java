
public class Player {
	Card crd1;
	Card crd2;
	double cash;
	
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
}
