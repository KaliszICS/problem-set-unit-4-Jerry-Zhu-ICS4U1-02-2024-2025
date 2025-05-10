/**
	* The Player class allows for the creation of a player with an name age and a hand(Card array) you provide or it will give you an empty array by default for the hand. You can get the age, name and hand of the player(as a Card array), draw a card from the deck or add one to it, send a card to the discard pile from your hand, and express the player's hand as a String.
	* @author Jerry Zhu
	* @version 1.0.1
	*/

public class Player {
private String name;
private int age;
private Card[] hand;

    /**
     * This constructor creates an object Player with parameters name age and hand(their cards).
     * @param name A String representing the name of the player
     * @param age The age of the player in years
     * @param hand A Card[] representing the cards that the player has 
     */
    public Player(String name, int age, Card[] hand){
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * This constructor creates an object Player with parameters name age and a default emtpy hand.
     * @param name A String representing the name of the player
     * @param age The age of the player in years
     * @param hand A Card[] representing the cards that the player has with zero elements
     */
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.hand = new Card[] {};
    }

    /**
	 * This method gets the age of the player
	 * @return Returns the age of the player as an integer
	 */
    public int getAge(){
        return this.age;
    }

    /**
	 * This method gets the name of the player
	 * @return Returns the name of the player as a String
	 */
    public String getName(){
        return this.name;
    }

    /**
	 * This method gets the discard pile as a Card array
	 * @return Returns the discard pile as a Card array
	 */
    public Card[] getHand(){
        return this.hand;
    }

    /**
	 * This method gets the size of the player's hand
	 * @return Returns the length of the discard pile as an integer
	 */
    public int size(){
        return this.hand.length;
    }

     /**
	 * This method takes the card from the top of the deck provided. So long as the card is not null, it gets added to your hand;
	 * @param deck A Deck that the Card will be drawn from.
	 */
    public void draw(Deck deck){
        Card c = deck.draw();
        if (c == null){
            return;
        }

        Card[] newHand = new Card[this.hand.length+1];
        
        //copying the old values from the original hand and adding the new card
        for(int i = 0; i < this.hand.length; i++){
            newHand[i] = this.hand[i];
        }
        newHand[this.hand.length] = c;
        this.hand = newHand;
    }

    /**
     * This method discards the last instance of a chosen card from the hand if it is in the hand, adding it to the discard pile and returning true. Otherwise, if the card chosen is null or is not present in the hand, nothing occurs and the method returns false. 
     * @param card A Card representing the Card that we want to search and discard 
     * @param discardPile A DiscardPile that represents the current discardPile to send the card to
     * @return Returns false if the card to be discarded is null or if the card is not in the hand. Returns true otherwise
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        boolean isInHand = false;
        if(card == null){
            return isInHand;
        }
        
        //searching for the card
        int index = -1;
        for(int i = 0; i < this.hand.length; i++){
            if(card.equals(this.hand[i])){
                index = i;
            }
        }
        if(index == -1){
            isInHand = false;
        }
        else{
            isInHand = true;
            //discarding the card and updating the hand
            discardPile.addCard(card);
            Card[] d = new Card[this.hand.length-1];
         //copy until you reach the card to be removed
        for(int i = 0; i < index; i++){
            d[i] = this.hand[i];
        }

        //copy the rest of the array after the removed card
        for(int i = index; i < d.length; i++){
            d[i] = this.hand[i+1];
        }
        this.hand = d;
        }
        return isInHand;
    }

        /**
         * This method returns the last instance of a chosen card from the hand if it is in the hand, adding it to the deck and returning true. Otherwise, if the card chosen is null or is not present in the hand, nothing occurs and the method returns false. 
         * @param card A Card representing the Card that we want to search and return 
         * @param deck A Deck that represents the current Deck to send the card to
         * @return Returns false if the card to be returned is null or if the card is not in the hand. Returns true otherwise
         */
        public boolean returnCard(Card card, Deck deck){
        if(card == null){
            return false;
        }
        boolean isInHand;

        //searches for the Card to be replaced
        int index = -1;
        for(int i = 0; i < this.hand.length; i++){
            if(card.equals(this.hand[i])){
                index = i;
            }
        }
        if(index == -1){
            isInHand = false;
        }
        else{
            isInHand = true;
            deck.addCard(card);
            
            //updating the hand
            Card[] d = new Card[this.hand.length-1];
            
        //copies the elements before the returned Card
        for(int i = 0; i < index; i++){
            d[i] = this.hand[i];
        }

        //copies the elements after the returned Card
        for(int i = index; i < d.length; i++){
            d[i] = this.hand[i+1];
        }
        this.hand = d;
        }

        return isInHand;
    }


    
    /**
	 * This method represents the player's hand as a String of its elements
	 * @return Returns the player's hand as a String of its elements in the format "playerName, playerAge, name1 of suit1, name1 of suit2... etc"
     * @throws NullPointerException if an element in the array is null
	 */
 @Override
    public String toString(){
        String h = this.name + ", " + this.age;
        //only puts the ", " after the age if there is anything following (elements in the hand)
        if(this.hand.length > 0){
            h += ", ";
        }

        //concatenates the elements and putting ", " if there is any remaining elements in the hand
        for(int i = 0; i < this.hand.length; i++){
            h += this.hand[i].toString();
            if(i < this.hand.length - 1){
                h += ", ";
            }
        }
        return h + ".";
    }


}
