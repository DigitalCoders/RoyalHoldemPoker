import java.util.ArrayList;
import java.util.List;


public class Rank {
	List<Card> crds;
	int cmnSID=24;
	public int chkRank(List<Card> tblcrds,Player plr){
		crds=new ArrayList<Card>();
		for (Card card : tblcrds) {
			crds.add(card);
		}
		crds.add(plr.getCrd1());
		crds.add(plr.getCrd2());
		sort(crds);
		sort(crds);
		prnt(crds);
		
		if(isRoyalFlush()){	
			crds.clear();
			return 100;
		}else if (isFourOfKnd()) {
			crds.clear();
			return 80;
		}else if (isFullHouse()) {
			crds.clear();
			return 60;
		}else if (isStraight()) {
			crds.clear();
			return 40;
		}else if (isThreeOfkind()) {
			crds.clear();
			return 20;
		}else if (isTwoPair()) {
			crds.clear();
			return 10;
		}else
			crds.clear();
		return 0;
	}
	private boolean isFlush(){
		int sameSuit=0;
		
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getSuitID()==crds.get(i+1).getSuitID()||cmnSID==crds.get(i+1).getSuitID()){
				sameSuit++;
				cmnSID=crds.get(i).getSuitID();
				System.out.println("same cardset--------------------++++++++++++");
				crds.get(i).showCard();
				crds.get(i+1).showCard();
			}
		}
		if(sameSuit>=4){
			return true;
		}
		return false;
	}
	private boolean isRoyalFlush(){
		List<Card> rylSet=new ArrayList<Card>();
		if(isFlush()){
			System.out.println("come to royal flush check###########");
			for (Card card : crds) {
				if(card.getSuitID()==cmnSID){
					rylSet.add(card);
					if(card.getRankID()==14){
						System.out.println("Royal Flush matched*********************************");
						return true;
					}
				}
			}
			
		}		
		return false;
		
	}
	private boolean isFourOfKnd(){
		int cnt=0,rID=0,sID=0;
		boolean first=true;
		for (int i = 0; i < crds.size()-1; i++) {
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				System.out.println("matched "+crds.get(i+1).getRankID() );
				if(sID!=crds.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crds.get(i).getRankID()&&sID==crds.get(i).getRankID())){
					cnt++;
					sID=crds.get(i).getRankID();
					System.out.println("cnt ="+cnt);
					first=false;
				}
				if(cnt==3){
					System.out.println("Four of kind matched*********************************");
					return true;
				}
				
			}
		}
		return false;
	}
	private boolean isOnePair(){
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				System.out.println("matched "+crds.get(i+1).getRankID());
				
					return true;				
				
				}
		
		}
		return false;
	}
	private boolean isTwoPair(){
		int rID=0;
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				System.out.println("matched "+crds.get(i+1).getRankID());
				if(rID!=crds.get(i).getRankID()&& i>1){
					System.out.println("two pair matched*********************************");
					return true;				
				}
				rID=crds.get(i).getRankID();
				}
		
		}
		return false;
	}
	private boolean isThreeOfkind(){
		int cnt=0,rID=0,sID=0;
		boolean first=true;
		for (int i = 0; i < crds.size()-1; i++) {			
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				System.out.println("matched "+crds.get(i+1).getRankID() );
				if(sID!=crds.get(i).getRankID()){
					first=true;
					cnt=0;
				}
				if(first||(rID==crds.get(i).getRankID()&&sID==crds.get(i).getRankID())){
					cnt++;					
					System.out.println("cnt ="+cnt);
					sID=crds.get(i).getRankID();
				}
				if(cnt==2){
					System.out.println("three of kind matched*********************************");
					return true;
				}
				
			}
		}
		return false;
	}
	private boolean isStraight(){
		int cnt=0;
		for (int i = 0; i < crds.size()-1; i++) {
			if(crds.get(i).getRankID()<crds.get(i+1).getRankID()){
				cnt++;
				if(cnt==4){
					System.out.println("straigth matched*********************************");
					return true;
				}
			}
		}
		return false;
	}
	private boolean isFullHouse(){
		int cnt=0,rID=0,thrrnkID=0;
		boolean thrOfKnd=false;
		boolean onePair=false;
		for (int i = 0; i < crds.size()-1; i++) {
			rID=crds.get(i).getRankID();
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()){
				System.out.println("matched "+crds.get(i+1).getRankID() );
				if(i==0||rID==crds.get(i).getRankID()){
					cnt++;
					thrrnkID=crds.get(i).getRankID();
					System.out.println("cnt ="+cnt);
				}
				if(cnt==2){
					thrOfKnd=true;
				}
			}
		}
		for (int i = 0; i <  crds.size()-1; i++) {
			if(crds.get(i).getRankID()==crds.get(i+1).getRankID()&& thrrnkID!=crds.get(i).getRankID()){
				onePair=true;
			}
		}
			if(thrOfKnd&&onePair){
				System.out.println("Full house matched*********************************");
				return true;
			}
			return false;
			}
	
	private void prnt(List<Card> crds){
		System.out.println('\n'+"==================cards on ranker==================");
		for (Card card : crds) {
			card.showCard();
		}
		System.out.println('\n'+"==================cards on ranker==================");
	}
	private void sort(List<Card> crds){
		Card temp;
		for (int i = crds.size()-1; i >0 ; i--) {
			for (int j = 0; j<i; j++) {
				if(crds.get(j).getRankID()>crds.get(j+1).getRankID()){
					temp=crds.get(i);
					crds.remove(i);
					crds.add(i, crds.get(j));
					crds.remove(j);
					crds.add(j, temp);
					temp=null;
				}
			}
		}

	}

	
}
