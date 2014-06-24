import java.util.ArrayList;
import java.util.List;


public class SnglPlayGame {

	List<Player> players;
	Dealer delr;
	boolean allSameBet=false;
	int blncMnyPlyrs=0;
	int plyrInGame=0;
	int foldPlyrs=0;
	
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
		
		plyrInGame=players.size();
		
		Dealer dlr=new Dealer();
		dlr.shuffleDeck();
		Table tbl=new Table();
		setCards(tbl, dlr, players);
		for (Player plr : players) {
				if (plr.isSmlblnd()) {
					plr.postSmlblnd(dlr);
				}else if (plr.isBgBlnd()) {
					plr.postBglblnd(dlr,tbl);
				}else{
					plr.actionOfPlayer(dlr,tbl);
				}
			
			}
		betting(tbl, dlr);
		
		System.out.println('\n'+'\n'+'\n'+" highest bet"+tbl.getHighsBet());
		System.out.println('\n'+'\n'+'\n'+" bigblind bet"+dlr.getBgBlind());;
		
		for (int i = 0; i < 3; i++) {
			tbl.SetDeck(dlr.getNextCard());
		}
		System.out.println("deler done the job put 3 cards to table");
		tbl.showTablCrd();
		tbl.SetDeck(dlr.getNextCard());
		System.out.println("dealer put the next car also now start betting again");
		tbl.showTablCrd();	
		System.out.println("currentlu players in the game "+plyrInGame);
		System.out.println("players folden"+foldPlyrs);
		
		
//		dlr.showDeck();
//		for (Player plr : players) {
//			System.out.println("Players hand in card===================");
//			plr.shwCardPlyr();			
//		}
//		System.out.println("Cards on table+++++++++++++++++++++++++++");
//		tbl.showTablCrd();
		
		
	}
	private void setCards(Table tbl,Dealer dlr,List<Player> players){
		for (Player plr : players) {
			plr.set1StCard(dlr.getNextCard());			
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			}
	}
	private void betting(Table tbl,Dealer dlr){
		while(!allSameBet){
			blncMnyPlyrs=0;
			for (Player plr : players) {				
				if(plr.getBet()==tbl.getHighsBet()||plr.isFold()){
					if(plr.isFold()){
						System.out.println('\n'+plr.getName()+" has fold");
						System.out.println("================================");
					}else{
						System.out.println('\n'+plr.getName()+" has put the highst bet");
						System.out.println("players hightst bet"+plr.getBet());
						System.out.println("tables highest bet"+tbl.getHighsBet());
						System.out.println("players hightst bet"+plr.getCash());
					}
					blncMnyPlyrs++;
				}else{
					System.out.println(plr.getName()+" has not @@put the highst bet");
					plr.actionOfPlayer(dlr,tbl);
				}
			}if(blncMnyPlyrs==players.size()){
				allSameBet=true;
				System.out.println("++++++++++++++++++++++++++++ all players have put highest bet");
			}			
		}
		blncMnyPlyrs=0;		
	}
	
	
}
