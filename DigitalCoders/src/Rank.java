import java.util.ArrayList;
import java.util.List;


public class Rank {

	public int chkRank(List<Card> tblcrds,Card crd1,Card crd2){
		int rank=0;
		ArrayList<Card> cardSet=(ArrayList<Card>) tblcrds;	// add all the cards (table cards and players card) to list
		cardSet.add(crd1);
		cardSet.add(crd2);
		
		for (Card card : cardSet) {		//to print outh the cards
			card.showCard();
			
		}
		return rank;
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
				return true;
			}
			return false;
			}
	
	private void prnt(List<Card> crds){
		System.out.println('\n'+"==================cards on ranker==================");
		for (Card card : crds) {
			card.showCard();
		}
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
