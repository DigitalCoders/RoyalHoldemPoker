


public class Player {
	Card crd1;
	Card crd2;
	private boolean smlBlnd=false;
	private boolean bgBlnd=false;
	private boolean fold=false;
	private boolean allIn=false;
	private double bet=0;
	private double cash=250;
	private int rankOfHand;
	private String name;
	
	public boolean isAllIn() {
		return allIn;
	}
	public void setAllIn(boolean allIn) {
		this.allIn = allIn;
	}
	public boolean isSmlBlnd() {
		return smlBlnd;
	}
	public void setBet(double bet) {
		this.bet = bet;
	}
	public double getBet() {
		return bet;
	}
	public boolean isFold() {
		return fold;
	}
	public void setFold(boolean fold) {
		this.fold = fold;
	}	
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void set1StCard(Card crd){
		crd1=crd;		
	}
	public void set2NdCard(Card crd){
		crd2=crd;		
	}
	public Card getCrd1() {
		return crd1;
	}
	public void setCrd1(Card crd1) {
		this.crd1 = crd1;
	}
	public Card getCrd2() {
		return crd2;
	}
	public void setCrd2(Card crd2) {
		this.crd2 = crd2;
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
	public boolean isBgBlnd() {
		return bgBlnd;
	}
	public int getRankOfHand() {
		return rankOfHand;
	}
	public void setRankOfHand(int rankOfHand) {
		this.rankOfHand = rankOfHand;
	}
	public void actionOfPlayer(Dealer dlr,Table tbl,int index){
		System.out.println('\n'+"player  "+name);
		if(tbl.getHighsBet()>cash){
			System.out.println("you have only "+cash);
			System.out.println("4 for all in-put the all mony in hand to table");
			System.out.println("3 for fold -exit the curnnt round");
		}else{
			System.out.println("1 for call-put higher than bet");
			System.out.println("2 for raise-put higr than bet");
			System.out.println("3 for fold -exit the curnnt round");
		}
		String choice=InputHelper.getInput("what is your choice "+name);
			switch(Integer.parseInt(choice)) {		//select the operations
				case 1:
					call(dlr,tbl);
					break;
				case 2:
					raise(dlr,tbl,index);
					break;
				case 3:
					fold(dlr);
					break;
				case 4:
					allIN(dlr);
					break;
				default:
					System.out.println("wrong input please reenter");
					break;
				}
	}
	public void actionOfPlayertwo(Dealer dlr,Table tbl,int index){
		System.out.println('\n'+"player  "+name);
		if(tbl.isCheck()){
			if(tbl.getHighsBet()>cash){
				System.out.println("you have only "+cash);
				System.out.println("4 for all in-put the all mony in hand to table");
				System.out.println("3 for fold -exit the curnnt round");
			}else{
				System.out.println("1 for call-put higher than bet");
				System.out.println("2 for raise-put higr than bet");
				System.out.println("3 for fold -exit the curnnt round");
			}
			String choice=InputHelper.getInput("what is your choice "+name);
				switch(Integer.parseInt(choice)) {
					case 1:
						if(cash==0){
							System.out.println("sorry you dont have money to play the game");
							fold(dlr);
						}else{
							call(dlr,tbl);
						}
						break;
					case 2:
						if(cash==0){
							System.out.println("sorry you dont have money to play the game");
							fold(dlr);
						}else{
						raise(dlr,tbl,index);
						}
						break;
					case 3:
						fold(dlr);
						break;
					case 4:
						allIN(dlr);
						break;
			
					default:
						System.out.println("wrong input please reenter");
						break;
					}
			}
		else{
			System.out.println("1 for check pass the chance");
			if(tbl.getHighsBet()>cash){
				System.out.println("4 for all in-put the all mony in hand to table");
				System.out.println("3 for fold -exit the curnnt round");
			}else{
				System.out.println("2 for bid");
				System.out.println("3 for fold -exit the curnnt round");
			}
			String choice=InputHelper.getInput("what is your choice "+name);
				switch(Integer.parseInt(choice)) {
					case 1:
						break;
					case 2:
						if(cash==0){
							System.out.println("sorry you dont have money to play the game");
							fold(dlr);
						}else{
							bid(dlr,tbl);
							tbl.setCheck(true);
							tbl.setPntOfRaise(index);
						}
						break;
					case 3:
						fold(dlr);
						break;
					case 4:
						allIN(dlr);
						break;
			
					default:
						System.out.println("wrong input please reenter");
						break;
					}
			}
		}
	private void allIN(Dealer dlr){
		allIn=true;
		System.out.println("come to player and put the all money to deler"+cash);
		dlr.addTobetCollctn(cash);
		cash=0;
	}
	
	private void fold(Dealer dlr) {
		this.fold=true;
		System.out.println(name+" fold the cards");
	}
	private void call(Dealer dlr,Table tbl){
		
		double balnce=tbl.getHighsBet()-bet;
		cash-=balnce;
		bet=tbl.getHighsBet();
		dlr.addTobetCollctn(balnce);
		System.out.println(name+"put the big blinds coins as his coins"+balnce);
		System.out.println(name+" cash in hand now "+cash);		
	}
	private void raise(Dealer dlr,Table tbl,int index){
		tbl.setPntOfRaise(index);
		double bgblnd=dlr.getBgBlind();
		double input=0;
		while(true){
			String inpt=InputHelper.getInput("enter the bet highr than "+bgblnd);
			if(Double.parseDouble(inpt)>bgblnd){
				input=Double.parseDouble(inpt);
				break;
			}
			else
				System.out.println("please enter higher amount than big blind");
		}
		cash-=(input-bet);
		bet=input;
		tbl.setHighsBet(input);
		dlr.setBgBlind(input);
		dlr.addTobetCollctn(input);
		System.out.println(name+"raise the bet");
		System.out.println(name+" cash in hand now "+cash);		
	}
	
	public void postSmlblnd(Dealer dlr){
		double smlBlndBet=10;
		cash-=smlBlndBet;
		bet=smlBlndBet;
		dlr.addTobetCollctn(smlBlndBet);
		System.out.println(name+"put the small blind");
		System.out.println("cash in hand now "+cash+'\n');
		
	}
	public void postBglblnd(Dealer dlr,Table tbl){
		double bgBlndBet=20;
		cash-=bgBlndBet;
		bet=bgBlndBet;
		tbl.highsBet=bgBlndBet;
		dlr.addTobetCollctn(bgBlndBet);
		dlr.setBgBlind(bgBlndBet);
		System.out.println(name+"put the big blind");
		System.out.println(name+" cash in hand now "+cash+'\n');		
	}
	private void bid(Dealer dlr,Table tbl){
		double input=0;
		
			String inpt=InputHelper.getInput("enter the bet  ");
				input=Double.parseDouble(inpt);
				cash-=input;
		bet=input;
		tbl.setHighsBet(input);
		dlr.setBgBlind(input);
		dlr.addTobetCollctn(input);
		System.out.println(name+"start the bet bet");
		System.out.println(name+" cash in hand now "+cash);		
	}
	

}
