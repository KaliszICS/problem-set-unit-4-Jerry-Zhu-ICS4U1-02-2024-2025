/**
	* The DiscardPile class allows for the creation of a discard pile(an array of Cards) from a Card array you provide or it will give you an empty array by default. You can get the array's size and the array itself, remove a card from the discard pile or even the whole pile, add a card to the discard pile, and get its contents as a String.
	* @author Jerry Zhu
	* @version 1.0.1
	*/

public class DiscardPile {

private Card[] discardPile;

    /**
	 * This constructor initializes an object DiscardPile from a card array.
	 * @param discardPile A Card[] that will be used as the discard pile. 
	 */
    public DiscardPile(Card[] discardPile){
        this.discardPile = discardPile;
    }

    /**
	 * This constructor initializes an object DiscardPile with a default empty array of cards.
	 */
    public DiscardPile(){
        this.discardPile = new Card[] {};
    }

    /**
	 * This method gets the discard pile
	 * @return Returns the discard pile as a Card array
	 */
    public Card[] getDiscardPile(){
        return this.discardPile;
    }

    /**
	 * This method gets the size of the discard pile
	 * @return Returns the length of the discard pile as an integer
	 */
    public int size(){
        return this.discardPile.length;
    }

    /**
     * This method adds a card to the discard pile if the card is not null
     * @param card A Card that will be put into the discard pile if it is not null
     */
    public void addCard(Card card){
        if(card == null){
            return;
        }

        Card[] d = new Card[this.discardPile.length + 1];

        //copying values from the original discard pile
        for(int i = 0; i < this.discardPile.length; i++){
            d[i] = this.discardPile[i];
        }
        
        //adds the card to the top(end) and sets as discard pile
        d[this.discardPile.length] = card;
        this.discardPile = d;

    }

    /**
     * This method checks if a provided card is in the discard pile, removing the last instance of that card and returning it so long as it is not null
     * @param card A Card that is to be removed from the discard pile if it is not null and is found in the discard pile
     * @return Returns null if the card does not exist in the discard pile or is null, otherwise, returns the card that is removed
     */
    public Card removeCard(Card card){
        if(card == null){
            return null;
        }

        int index = -1;
        
        for(int i = 0; i < this.discardPile.length; i++){
            if(card.equals(this.discardPile[i])){
                index = i;
            }
        }
        
        if(index == -1){
            return null;
        }

        Card[] d = new Card[this.discardPile.length-1];

        //copies values from the original until it reaches the removed card's index
        for(int i = 0; i < index; i++){
            d[i] = this.discardPile[i];
        }
        //copies any value following the removed card's index
        for(int i = index; i < d.length; i++){
            d[i] = this.discardPile[i+1];
        }

        //sets the discard pile to the new array and returns the card removed
        Card taken = this.discardPile[index];
        this.discardPile = d; 
        return taken;
    }

    /**
     * This method takes out all the elements from the discard pile and returning them as a Card array
     * @return Returns the discard pile as a Card array
     */
    public Card[] removeAll(){
        Card[] d = new Card[this.discardPile.length];

        //copying over the values of the discard pile
        for(int i = 0; i < this.discardPile.length; i++){
            d[i] = this.discardPile[i];
        }
        
        //sets the discard pile as an empty Card array
        this.discardPile = new Card[] {};
        return d;
    }

    /**
	 * This method represents the discard pile as a String of its elements
	 * @return Returns the discard pile as a String of its elements in the format "name1 of suit1, name1 of suit2... etc"
	 */
    @Override
    public String toString(){
        String d = "";

        //concatenates the toString() values of the individual cards 
        for(int i = 0; i < this.discardPile.length; i++){
            d += this.discardPile[i].toString();
           
            //adds ", " except on last iteration
            if(i < this.discardPile.length-1){
                d += ", ";
            }
        }
        return d + ".";
    }


}
