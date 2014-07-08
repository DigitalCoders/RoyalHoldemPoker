import java.util.ArrayList;
import java.util.List;


public class SnglPlayGame {

	List<Player> players;
	Dealer delr;
	boolean allSameBet=false;	
	int blncMnyPlyrs=0;
	int plyrInGame=0;
	int foldPlyrs=0;
	static int pntOfSmlbl; 		//reference to the small blind to the player on arraylist
	
	public void startGame(){
		setPlayers();		//create players and set small blind and big blind on first 2
		
		Dealer dlr=new Dealer();	//create a dealer and generate cards
		dlr.shuffleDeck();			//shuffle the cards
		Table tbl=new Table();		//create a table
		setCards(tbl, dlr, players);  	//initialaise first 3 cards to table
		
		putBlinds(dlr, tbl);		//put small blinds and big blinds and start betting 1st round
		betting(tbl, dlr);			
//		tbl.SetDeck(dlr.getNextCard());		//deler put another card to table now 4 cards on table
		System.out.println("dealer put the next car also now start betting again");
//		tbl.showTablCrd();	
		System.out.println("currentlu players in the game "+plyrInGame);
		System.out.println("players folden"+foldPlyrs);
		tbl.setHighsBet(0);
		
//		crclRound(players);	
		
		setSmlNBgblCrcl(players);
		
		for (Player py : players) {
			System.out.println("test");
			py.toString();
		}
//		dlr.showDeck();
//		for (Player plr : players) {
//			System.out.println("Players hand in card===================");
//			plr.shwCardPlyr();			
//		}
//		System.out.println("Cards on table+++++++++++++++++++++++++++");
//		tbl.showTablCrd();
		
		
	}
	private void crclRound(List<Player> plyr){
		boolean found=false;
		boolean round=false;
		for (int i = 0; i < plyr.size(); i++) {
			
			if(plyr.get(i).isSmlblnd()){
				found=true;
				if(round){
					break;
				}
				round=true;
				System.out.println("game begine ------------");
				System.out.println(found);
			}
			if(found==true){
				plyr.get(i).toString();
				System.out.println(i);
			}
			if(i==plyr.size()-1){
				i=-1 ;
			}
		}
	}
	private void putBlinds(Dealer dlr, Table tbl) {
		for (Player plr : players) {
				if (plr.isSmlblnd()) {
					plr.postSmlblnd(dlr);
				}else if (plr.isBgBlnd()) {
					plr.postBglblnd(dlr,tbl);
				}else{
					plr.actionOfPlayer(dlr,tbl);
				}
			
			}
	}
	private void setPlayers() {
		players=new ArrayList<Player>();
		players.add(new Player("player 1"));
		players.add(new Player("player 2"));
		players.add(new Player("player 3"));
		players.add(new Player("player 4"));
		players.add(new Player("player 5"));	
		Player p1=players.get(0);
		pntOfSmlbl=0;
		p1.setSmlBlnd(true);
		Player p2=players.get(1);
		p2.setBgBlnd(true);		
		plyrInGame=players.size();
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
	
	private static void setSmlNBgblCrcl(List<Player> plyr) {
		for (Player player : plyr) {
			int size=plyr.size();
			if (plyr.indexOf(player)==pntOfSmlbl%size) {
				System.out.println("the index of the smalllbbbb=="+pntOfSmlbl%size);
				player.setSmlBlnd(false);
				player=plyr.get((pntOfSmlbl+1)%size);
				player.setBgBlnd(false);
				player.setSmlBlnd(true);
				player=plyr.get((pntOfSmlbl+2)%size);
				System.out.println("the index of the bibBline=="+(pntOfSmlbl+2)%size);
				player.setBgBlnd(true);
				
			}			
		}
		pntOfSmlbl++;
	}
	
}
