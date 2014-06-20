RoyalHoldemPoker
================
The program starts with the “Start “class. 

Then create “sp” object from “SnglPlayGame” class. 

Through that the object calls the method “startGame()”

In “SnglPlayGame”  class has a arraylist of players’ names  and a one dealer.

When call the “SnglPlayGame” method,  it will initialize the players array and add players to array set. 
1st player as a small blind and 2nd player as and big blind.

initialized a dealer to deal with players and cards.

In the Dealer’s constructor inside the “Dealer” class, he’ll create 20 cards and add to arraylist named “allCards” and then “shuffle” deck.

For each player dealer give one card from his “allCard” list and keep track what is the next card by using static.

int variable named “crdpostn”  increments  in order to get the next card. And after giving 1st card to each player it will give the 2nd card as well.
