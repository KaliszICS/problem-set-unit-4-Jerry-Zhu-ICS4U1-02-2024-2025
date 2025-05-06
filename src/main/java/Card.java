public class Card{
private String name;
private String suit;
private int value;

/**
 *@param
 */
public Card(String name, String suit, int value){
this.name = name;
this.suit = suit;
this.value = value;
}

public String getName(){
    return this.name;
}

public String getSuit(){
    return this.suit;
}

public int getValue(){
    return this.value;
}

@Override
public String toString(){
    return this.name + " of " + this.suit;
}

@Override
public boolean equals(Object obj){
    Card card = (Card)obj;
    if (card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue() == (this.value)){
        return true;
    }
    return false;
}

}