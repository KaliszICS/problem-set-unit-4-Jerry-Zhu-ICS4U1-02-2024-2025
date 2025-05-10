/**
	* The card class allows for the creation of a deck(an array of Cards) from a Card array you provide or it will give you a default set of 52 cards. You can get the array's size and the array itself, draw from the deck, add a card or shuffle in a set of cards into the deck, and shuffle the deck
	* @author Jerry Zhu
	* @version 1.0.1
	*/


import java.util.Random;
import java.util.ArrayList;
public class Deck {   
private Card[] deck; 

    /**
	 * This constructor initializes an object Deck from a card array.
	 * @param deck A Card[] that will be used as the deck. 
	 */
    public Deck(Card[] deck){  
    this.deck = deck;
}

    /**
	 * This constructor initializes an object Deck with a default array of cards. The cards are in order from Ace to king and then by suits(Hearts, Clubs, Diamonds, and Spades in that order). The value of the cards is as follows (2-Ace in ascending order and suits do not matter)
	 */

public Deck(){
    this.deck = new Card[52];
    String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    int[] values = {13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    for(int i = 0; i < suits.length; i++){ //outside loop for suits
        for(int j = 0; j < names.length; j++){//inside loops for each card name and gives their value as well
            Card c = new Card(names[j], suits[i], values[j]);
            this.deck[(i)*13+j] = c; //13 per suit + the place of the current name
        }
    }
}

    /**
	 * This method gets the deck as a Card array
	 * @return Returns the deck as a Card array
	 */
public Card[] getDeck(){
    return this.deck;
}


    /**
	 * This method gets the size of the deck
	 * @return Returns the length of the deck as an integer
	 */
public int size(){
    return this.deck.length;
}


    /**
	 * This method takes the card from the end of the deck, so long as it has at least a length of 1, removing it from the deck and returning it.
	 * @return Returns the last card in the deck if the deck has a length greater than zero. if the deck is empty, returns null.
	 */
public Card draw(){
    if(deck.length > 0){
        Card[] cards = new Card[this.deck.length-1];
        //copying all cards but last to new array
        for(int i = 0; i < cards.length; i++){
            cards[i] = deck[i];
        }
        Card drawn = deck[deck.length-1];
        this.deck = cards;
        return drawn;
    }
    return null;
}

    /**
	 * This method randomizes the order of the cards in the current deck. It makes a copy of the deck, removing 1 element randomly and assigning it to an index.
	 */
public void shuffle(){
    if(this.deck.length <= 1){
        return;
    }

    //initialization of random, array list, and index
        ArrayList<Card> og = new ArrayList<Card>();
        Random r = new Random();
        int index;

    //copying the array as an arraylist
    for(int i = 0; i < this.deck.length; i++){
        og.add(this.deck[i]);
    }

    //removes a random element in the arraylist and places it in a set index.
    for(int iterations = 0; iterations < this.deck.length; iterations++){
        index = r.nextInt(og.size());
        this.deck[iterations] = og.get(index);
        og.remove(index);
    }
}

    /**
	 * This method adds a card to the top of the deck(End of the array) so long as it is not null.
	 * @param card A Card that will be put into the deck if it's not null
	 */
public void addCard(Card card){
    //checking for null
    if(card == null){
        return;
    }
    //new deck with 1 extra element
    Card[] d = new Card[this.deck.length + 1];

    //transferring the values from the original deck
    for(int i = 0; i < this.deck.length; i++){
        d[i] = this.deck[i];
    }

    //adding the card
    d[this.deck.length] = card;
    this.deck = d;

}

    /**
	 * This method adds a set of cards to the top of the deck(End of the array) so long as it is not null. The deck then will be shuffled
	 * @param cards A Card[] that will be put into the deck if it's not null
	 */
public void reshuffle(Card[] cards){
    //checks
    if(cards == null|| cards.length == 0){
        return;
    }

    //new array with length of the deck and the cards to be added 
    Card[] d = new Card[this.deck.length + cards.length];

    //transferring the cards of the deck    
    for(int i = 0; i < this.deck.length; i++){
        d[i] = this.deck[i];
    }

    //adding the cards in the array
    for(int i = 0; i < cards.length; i++){
        d[i+this.deck.length] = cards[i];
    }
    this.deck = d;
    shuffle();
}

}
