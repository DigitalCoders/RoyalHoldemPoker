import java.util.ArrayList;
import java.util.List;


public class SnglPlayGame {

	List<Player> players;
	Dealer dlr;
	boolean allSameBet=false;	
	int blncMnyPlyrs=0;
	int plyrInGame=0;
	int foldPlyrs=0;
	
	static int pntOfSmlbl; 		//reference to the small blind to the player on arraylist
	
	public void startGame(){
		setPlayers();		//create players and set small blind and big blind on first 2
		players.get(2).setCash(100);
		InputHelper.getInput("players set");
		dlr=new Dealer();	//create a dealer and generate cards
		dlr.shuffleDeck();			//shuffle the cards
		Table tbl=new Table();		//create a table
		setCards( dlr, players);  	//initialaise 2 crds by to players
		
		System.out.println("===================== PreFlop Round =====================");			
		putBlinds(dlr, tbl); 			//1st time small and big blinds put cash to table 
		InputHelper.getInput("player 1 and 2 put the blinds");
		betting(players, tbl, dlr);	//after put all players are start betting or fold		
		
		showDetail(tbl, dlr, players);
		System.out.println("===================== Flop Round =====================");
		InputHelper.getInput("start thr flop round");
		tbl.SetDeck(dlr.getNextCard());
		tbl.SetDeck(dlr.getNextCard());
		tbl.SetDeck(dlr.getNextCard());
		tbl.showTablCrd();
		InputHelper.getInput("start betting");
		resetfrNewRnd(dlr, tbl, players);
		betting(players, tbl, dlr);		
		InputHelper.getInput("betting finish");
		tbl.SetDeck(dlr.getNextCard());    		//4th card
		showDetail(tbl, dlr, players);
		
		System.out.println("===================== Turn Round =====================");
		InputHelper.getInput("start turn round");
		resetfrNewRnd(dlr, tbl, players);
		betting(players, tbl, dlr);		
		tbl.SetDeck(dlr.getNextCard());			//5th card
		showDetail(tbl, dlr, players);
		InputHelper.getInput("turn round finish and the cards on table");
		tbl.showTablCrd();
		InputHelper.getInput("start the river round");
		System.out.println("===================== River Round =====================");
		resetfrNewRnd(dlr, tbl, players);
		betting(players, tbl, dlr);		
		InputHelper.getInput("river round finish ");
		showDetail(tbl, dlr, players);
	}
	private void resetfrNewRnd(Dealer dlr, Table tbl,List<Player> plyr){
		dlr.setBgBlind(0);
		tbl.setHighsBet(0);
		for (Player player : plyr) {
			System.out.println(player.getBet());
			player.setBet(0);
			System.out.println(player.getBet());

		}
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
					plr.postSmlblnd(dlr);		//players put the small and big blinds to table
				}else if (plr.isBgBlnd()) {
					plr.postBglblnd(dlr,tbl);
					tbl.setPntOfRaise(players.indexOf(plr));
					tbl.setCheck(true);
				}			
			}
	}
	private void firstRound(List<Player> plyr,Table tbl,Dealer dlr){
		boolean start=false;
		boolean round=false;
		int MnyBlncPlyr=0;
		double hghstBet=0;
		for (int i = 0; i < plyr.size(); i++) {
			if(plyr.get(i).isBgBlnd()){			//start betting after bigblind
				if(!start){
					i++;	
				}
				if(start && round ){
					break;
				}
				start=true;
			}
			if(start){						//if find the bigblind and start the game 
				System.out.println("come to betting time "+tbl.getHighsBet()+'\n');
				if(plyr.get(i).getBet()==tbl.getHighsBet()||plyr.get(i).isFold()){
					hghstBet=tbl.getHighsBet();
					if(plyr.get(i).isFold()){
						System.out.println('\n'+plyr.get(i).getName()+" has fold");
						System.out.println("================================");
					}else{
						System.out.println('\n'+plyr.get(i).getName()+" has put the highst bet");
					}
					MnyBlncPlyr++;			//increment if player put highst or fold withowt in low
					System.out.println('\n'+"mony balenced players are "+MnyBlncPlyr+'\n');
				}else{						//if  not they have to perform action what to do
					System.out.println(plyr.get(i).getName()+" has not @@put the highst bet");
					plyr.get(i).shwCardPlyr();
					plyr.get(i).actionOfPlayer(dlr,tbl,i);		//take action from the player
					if(tbl.getHighsBet()!=hghstBet){
						MnyBlncPlyr=0;
					}
				}
			}	
			
			
			if(i==plyr.size()-1){		// go circl over arraylist
				i=-1 ;
			}
			if(MnyBlncPlyr==plyr.size()){
				round=true;
			}
		}
		tbl.setCheck(false);
	}
	private void setPlayers() {
		players=new ArrayList<Player>();
		players.add(new Player("player 0"));
		players.add(new Player("player 1"));
		players.add(new Player("player 2"));
		players.add(new Player("player 3"));
		players.add(new Player("player 4"));
			
		Player p1=players.get(0);
		pntOfSmlbl=0;
		p1.setSmlBlnd(true);			//set small and bigblinds to first players 
		Player p2=players.get(1);
		p2.setBgBlnd(true);		
		plyrInGame=players.size();
	}
	private void setCards(Dealer dlr,List<Player> players){
		for (Player plr : players) {				//dealer give 2 cards to each player
			plr.set1StCard(dlr.getNextCard());			
		}
		
		for (Player plr : players) {
			plr.set2NdCard(dlr.getNextCard());
			}
	}
	private void bettingtttttttttttttttttttttttttttttttt(Table tbl,Dealer dlr){
		while(!allSameBet){					//iterate untill all players in same state or fold
			blncMnyPlyrs=0;					//keep track how many players in balance
			for (Player plr : players) {				
				if(plr.getBet()==tbl.getHighsBet()||plr.isFold()){  //player has fold or put the highest bet 
					if(plr.isFold()){
						System.out.println('\n'+plr.getName()+" has fold");
						System.out.println("================================");
					}else{
						System.out.println('\n'+plr.getName()+" has put the highst bet");
						System.out.println("players hightst bet"+plr.getBet());
						System.out.println("tables highest bet"+tbl.getHighsBet());
						System.out.println("players hightst bet"+plr.getCash());
					}
					blncMnyPlyrs++;			//increment if player put highst or fold withowt in low
				}else{						//if  not they have to perform action what to do
					System.out.println(plr.getName()+" has not @@put the highst bet");
					plr.actionOfPlayer(dlr,tbl,players.indexOf(plr));		//take action from the player
				}
			}if(blncMnyPlyrs==players.size()){
				allSameBet=true;
				System.out.println("++++++++++++++++++++++++++++ all players have put highest bet");
			}			
		}
		blncMnyPlyrs=0;		
	}
	private void showDetail(Table tbl,Dealer dlr,List<Player> players){
		System.out.println('\n'+"      -----------details of cards on table--------------- "+'\n');
		tbl.showTablCrd();
		System.out.println("Tables highst bet  "+tbl.getHighsBet());
		System.out.println('\n'+"      -----------details of players--------------- "+'\n');
		for (Player player : players) {
			System.out.println("player name ="+player.getName()+"-----------------------");
			if(player.isFold()){
				System.out.println("player has fold");
			}else{
				System.out.println("player bet ="+player.getBet());
				System.out.println("player cash in hand ="+player.getCash());
			}
		}
		System.out.println("-------------deler details--------------");
		System.out.println("delers cash in hand "+dlr.getBetCollection());
		System.out.println("delers highst bet "+dlr.getBgBlind());
		
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
	private void betting(List<Player> plyr,Table tbl,Dealer dlr){
		boolean start=false;
		boolean round=false;
		int MnyBlncPlyr=0;
		double hghstBet=0;
		for (int i = tbl.getPntOfRaise(); i < plyr.size(); i++) {
				if(round ){
					break;
				}
				start=true;
			
			if(true){						
				System.out.println("come to betting time in 22222   "+MnyBlncPlyr +'\n');
				if((plyr.get(i).getBet()==tbl.getHighsBet() && plyr.get(i).getBet()!=0)||plyr.get(i).isFold()||plyr.get(i).isAllIn()){
					hghstBet=tbl.getHighsBet();
					if(plyr.get(i).isFold()){
						System.out.println('\n'+plyr.get(i).getName()+" has fold");
						System.out.println("================================");
					}else if (plyr.get(i).isAllIn()) {
						System.out.println('\n'+plyr.get(i).getName()+" has put all in");
						System.out.println("================================");
					}
					else{
						System.out.println('\n'+plyr.get(i).getName()+" has put the highst bet");
					}
					MnyBlncPlyr++;			//increment if player put highst or fold withowt in low
					System.out.println('\n'+"mony balenced players are "+MnyBlncPlyr+'\n');
				}else{						//if  not they have to perform action what to do
					System.out.println(plyr.get(i).getName()+" has not @@put the highst bet");
					plyr.get(i).actionOfPlayertwo(dlr, tbl,i);		//take action from the player
					if(tbl.getHighsBet()!=hghstBet||!tbl.isCheck()){
						MnyBlncPlyr=0;
					}
				}
			}	
			
			
			if(i==plyr.size()-1){		// go circl over arraylist
				i=-1 ;
			}
			if(MnyBlncPlyr==plyr.size()){
				round=true;
			}
		}
		tbl.setCheck(false);
	}
}
