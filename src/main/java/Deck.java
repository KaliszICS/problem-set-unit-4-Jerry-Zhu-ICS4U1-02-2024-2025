import java.util.Random;

import javax.smartcardio.Card;
public class Deck {   
private Card[] deck; 
    public Deck(Card[] originalDeck){  
    this.deck = originalDeck;
    }

    public Deck(){
this.deck = new Card[52];
String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
String[] suits = {"Hearts", "CLubs", "Diamonds", "Spades"};
int[] values = {13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

for(int i = 0; i < suits.length; i++){
    for(int j = 0; j < names.length; j++){
        Card c = new Card(names[j], suits[i], values[j]);
        this.deck[(i)*j+j] = c;
    }
}
    }

public int size(){
    return this.deck.length;
}

public Card draw(){
    if(this.deck.length > 0){
        Card[] cards = new Card[this.deck.length-1];
        for(int i = 0; i < cards.length; i++){
            cards[i] = deck[i];
        }
        Card drawn = deck[deck.length-1];
        this.deck = cards;
        return drawn;
    }
    return null;
}

public void shuffle(){
    Random r = new Random();

    Card[] top = new Card[this.deck.length/2];
    Card[] bottom = new Card[this.deck.length-top.length];
    for(int j = 0; j < 2; j++){

        int topIndex = 0;
        int bottomIndex = 0;
        int ogIndex = 0;
        
        for(int i = 0; i < top.length; i++){
            top[i] = this.deck[i];
        }
        for(int i = 0; i < bottom.length; i++){
            bottom[i] = this.deck[i+top.length];
        }
        
        while(topIndex < top.length && bottomIndex < bottom.length){
            for(int i = 0; i < r.nextInt(3)+1; i++){
                if(topIndex + i >= top.length){
                    i = 5;
                }
                else{       
                    this.deck[ogIndex] = top[topIndex];
                    topIndex++;     
                    ogIndex++;
                }
            }
            for(int i = 0; i < r.nextInt(3)+1; i++){
                if(bottomIndex + i >= bottom.length){
                    i = 5;
                }
                else{       
                    this.deck[ogIndex] = bottom[bottomIndex];
                    bottomIndex++;     
                    ogIndex++;
                }
                
                
                while(topIndex < top.length){
                    this.deck[ogIndex] = top[topIndex];
                    topIndex++;
                    ogIndex++;
                }
                
                while(bottomIndex < bottom.length){
                    this.deck[ogIndex] = bottom[bottomIndex];
                    bottomIndex++;
                    ogIndex++;
                }
            }
} 
}


for(int i = 0; i < top.length; i++){
    top[i] = this.deck[i];
}
for(int i = 0; i < bottom.length; i++){
    bottom[i] = this.deck[i+top.length];
}
    for(int i = 0; i < bottom.length; i++){
        this.deck[i] = bottom[i];
    }
    for(int i = 0; i < top.length; i++){
        this.deck[i+bottom.length] = top[i];
    
}

}
}
