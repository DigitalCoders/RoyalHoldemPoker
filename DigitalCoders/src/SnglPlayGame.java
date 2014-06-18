import java.util.ArrayList;
import java.util.List;


public class SnglPlayGame {

	List<Player> players;
	Dealer delr;
	boolean allSameBet=false;
	
	public void startGame(){
		players=new ArrayList<Player>();
		players.add(new Player("player 1"));
		players.add(new Player("player 2"));
		players.add(new Player("player 3"));
		players.add(new Player("player 4"));
		players.add(new Player("player 5"));	
		Player p1=players.get(0);
		p1.setSmlBlnd(true);
		Player p2=players.get(1);
		p2.setBgBlnd(true);
		
		Dealer dlr=new Dealer();
		dlr.shuffleDeck();
		Table tbl=new Table();
		for (Player plr : players) {
			plr.set1StCard(dlr.getNextCard());
			
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			
		}
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			
		}	
			for (Player plr : players) {
				if (plr.isSmlblnd()) {
					plr.postSmlblnd(dlr);
				}else if (plr.isBgBlnd()) {
					plr.postBglblnd(dlr,tbl);
				}else{
					plr.actionOfPlayer(dlr,tbl);
				}
			
			}
		while(!allSameBet){
			for (Player plr : players) {
				if(plr.getBet()==tbl.getHighsBet()){
					System.out.println(plr.getName()+" has put the highst bet");
					System.out.println("players hightst bet"+plr.getBet());
					System.out.println("tables highest bet"+tbl.getHighsBet());
				}else{
					System.out.println(plr.getName()+" has not @@put the highst bet");
					plr.actionOfPlayer(dlr,tbl);
				}
			}	allSameBet=true;
		}
		// want to implement bet
		
		for (int i = 0; i < 3; i++) {
			tbl.SetDeck(dlr.getNextCard());
		}
//		System.out.println("deler done the job");
//		dlr.showDeck();
//		for (Player plr : players) {
//			System.out.println("Players hand in card===================");
//			plr.shwCardPlyr();			
//		}
//		System.out.println("Cards on table+++++++++++++++++++++++++++");
//		tbl.showTablCrd();
		Rank r= new Rank();
		r.chkRank(tbl.getCrdOnTbl(), players.get(0).getCrd1(),  players.get(0).getCrd2());
		
		
	}
	
	
}
