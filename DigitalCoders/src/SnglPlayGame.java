import java.util.ArrayList;
import java.util.List;


public class SnglPlayGame {

	List<Player> players;
	Dealer delr;
	
	public void startGame(){
		players=new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());	
		Player p1=players.get(0);
		p1.setSmlBlnd(true);
		Player p2=players.get(1);
		p2.setBgBlnd(true);
		
		Dealer dlr=new Dealer();
		dlr.shuffleDeck();
		
		for (Player plr : players) {
			plr.set1StCard(dlr.getNextCard());
			
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			
		}
		// want to implement bet
		Table tbl=new Table();
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
