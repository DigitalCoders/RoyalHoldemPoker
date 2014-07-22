
public class AIplayer extends Player{

	private  int bidrnd=0;
	private  int chkrnd=0;
	public AIplayer(String name) {
		super(name);
	}

	@Override
	public void actionOfPlayertwo(Dealer dlr, Table tbl, int index) {
		
	}
	private void bidAI(Dealer dlr, Table tbl,int index) {
		tbl.setPntOfRaise(index);
		double input=tbl.getHighsBet()+5;
		
//			cash-=input;
//	bet=input;
	tbl.setHighsBet(input);
	dlr.setBgBlind(input);
	dlr.addTobetCollctn(input);
	}
	private  int chkMycrds(){
		int myrnk=0;
		if(crd1!=null&&crd2!=null){
			myrnk+=crd1.getRankID();
			myrnk+=crd2.getRankID();
			if(crd1.getRankID()==crd2.getRankID()){
				myrnk+=40;
			}else if(crd1.getRankID()-1==crd2.getRankID()||crd1.getRankID()+1==crd2.getRankID()){
				myrnk+=20;
			}
			if(crd1.getSuitID()==crd2.getSuitID()){
				myrnk+=20;
			}if(crd1.getRankID()==14||crd2.getRankID()==14){
				myrnk+=30;
			}
			
		}
//		window.getLblBlind().setText("value "+myrnk);
		return myrnk;
	}
}
