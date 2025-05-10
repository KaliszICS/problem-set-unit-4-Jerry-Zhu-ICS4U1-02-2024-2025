/**
	* The card class allows for the creation of Cards with a suit, name and numerical value. It contains getter methods for all three variables, a toString method and an equals method.
	* @author Jerry Zhu
	* @version 1.0.1
	*/
public class Card {
    //instance variables
        private String name;
        private String suit;
        private int value;
 
    /**
	 * This constructor initializes an object Card with parameters name, suit, and valjue.
	 * @param name a String referencing to the name of the card
	 * @param suit a String referencing to the suit of the card
     * @param value refers to the relaive value of the card 
	 */
        public Card(String name, String suit, int value){
            this.name = name;
            this.suit = suit;
            this.value = value;
        }
        
    /**
	 * This method returns the name of the current card
	 * @return returns the name of the card as a String 
	 */
        public String getName(){
            return this.name;
        }
       
    /**
	 * This method returns the suit of the current card
	 * @return returns the suit of the card as a String 
	 */
        public String getSuit(){
            return this.suit;
        }
    /**
	 * This method returns the numerical value of the current card
	 * @return returns the suit of the card as an integer 
	 */ 
        public int getValue(){
            return this.value;
        }
        
    /**
	 * This method returns the full name of the current card
	 * @return returns the suit of the card as a String in the form "name of suit" 
	 */
        @Override
        public String toString(){
            return this.name + " of " + this.suit;
        }

     /**
	 * This method checks if two cards are the same card.
     * @param obj An object to be typecasted into a card for comparason
	 * @return Returns true if the cards are the same, false if otherwise. Cards are the same if their name, suit and value are the same.
	 */ 
        @Override
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }
            if(obj.getClass() == this.getClass()){
                Card card = (Card)obj;
                if (card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue() == (this.value)){
                    return true;
                }
            }
            return false;
        }
        
}
