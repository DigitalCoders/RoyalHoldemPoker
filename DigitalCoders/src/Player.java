


public class Player {
	Card crd1;
	Card crd2;
	boolean smlBlnd=false;
	boolean bgBlnd=false;
	boolean fold=false;
	double bet=0;
	double cash=250;
	int rankOfHand;
	String name;
	
	public double getBet() {
		return bet;
	}
	public boolean isFold() {
		return fold;
	}
	public void setFold(boolean fold) {
		this.fold = fold;
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
	public void actionOfPlayer(Dealer dlr,Table tbl){
		System.out.println('\n'+"player  "+name);
		System.out.println("1 for call-put bigblind");
		System.out.println("2 for raise-put higr than bigblnd");
		System.out.println("3 for fold -exit the curnnt round");
		String choice=InputHelper.getInput("what is your choice "+name);
		switch(Integer.parseInt(choice)) {
		case 1:
				call(dlr,tbl);
			break;
		case 2:
			raise(dlr,tbl);
			break;
		case 3:
			fold(dlr);
			break;
			
		default:
			System.out.println("wrong input please reenter");
			break;
		}
	}
	private void fold(Dealer dlr) {
		this.fold=true;
		System.out.println(name+" fold the cards");
	}
	private void call(Dealer dlr,Table tbl){
		
		double balnce=tbl.getHighsBet()-bet;
		cash-=balnce;
		bet=balnce;
		dlr.addTobetCollctn(balnce);
		System.out.println(name+"put the big blinds coins as his coins"+balnce);
		System.out.println(name+" cash in hand now "+cash);		
	}
	private void raise(Dealer dlr,Table tbl){
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
		cash-=input;
		bet=input;
		tbl.setHighsBet(input);
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
		System.out.println("cash in hand now "+cash);
		
	}
	public void postBglblnd(Dealer dlr,Table tbl){
		double bgBlndBet=20;
		cash-=bgBlndBet;
		bet=bgBlndBet;
		tbl.highsBet=bgBlndBet;
		dlr.addTobetCollctn(bgBlndBet);
		dlr.setBgBlind(bgBlndBet);
		System.out.println(name+"put the big blind");
		System.out.println(name+" cash in hand now "+cash);		
	}
	
	

}
