
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
}
