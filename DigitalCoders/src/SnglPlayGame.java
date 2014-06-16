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
		
		Dealer dlr=new Dealer();
		dlr.shuffleDeck();
		
		Table tbl=new Table();
		for (int i = 0; i < 3; i++) {
			tbl.SetDeck(dlr.getNextCard());
		}
		for (Player plr : players) {
			plr.set1StCard(dlr.getNextCard());
			
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			
		}
		System.out.println("deler done the job");
		dlr.showDeck();
		for (Player plr : players) {
			System.out.println("Players hand in card===================");
			plr.shwCardPlyr();			
		}
		System.out.println("Cards on table+++++++++++++++++++++++++++");
		tbl.showTablCrd();
	}
	
}
