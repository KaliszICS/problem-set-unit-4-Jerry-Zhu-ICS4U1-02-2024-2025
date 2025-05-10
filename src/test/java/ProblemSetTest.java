//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Arrays;

public class ProblemSetTest {

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */

    @Test
   public void cardGetNameTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      assertEquals("Ace", card.getName());
   }

   @Test
   public void cardGetNameTest2()
   {
      Card card = new Card("2", "Diamonds", 1);
      assertEquals("2", card.getName());
   }

    @Test
   public void cardGetSuitTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      assertEquals("Spades", card.getSuit());
   }

   @Test
   public void cardGetSuitTest2()
   {
      Card card = new Card("2", "Diamonds", 1);
      assertEquals("Diamonds", card.getSuit());
   }

   @Test
   public void cardGetValueTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      assertEquals(13, card.getValue());
   }

   @Test
   public void cardGetValueTest2()
   {
      Card card = new Card("2", "Diamonds", 1);
      assertEquals(1, card.getValue());
   }

   @Test
   public void cardToStringTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      assertEquals("Ace of Spades", card.toString());
   }

   @Test
   public void cardToStringTest2()
   {
      Card card = new Card("2", "Diamonds", 1);
      assertEquals("2 of Diamonds", card.toString());
   }

   @Test
   public void cardEqualsTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = null;
      assertEquals(false, card.equals(card2));
   }


   
   @Test
   public void cardEqualsTest2()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("Ace", "Spades", 13);
      assertEquals(true, card.equals(card2));
   }
   
   @Test
   public void cardEqualsTest3()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      assertEquals(false, card.equals(card2));
   }

@Test
   public void cardEqualsTest4()
   {
      Card card = new Card("Ace", "Spades", 13);
      String word = "EHHEHE";
      assertEquals(false, card.equals(word));
   }

   @Test
   public void getDeckTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] deck = new Card[] {card, card2};
      Deck d = new Deck(deck);
      assertTrue(Arrays.equals(deck, d.getDeck()));
   }
   
    @Test
   public void getDeckTest2()
   {
      Card[] deck = new Card[] {};
      Deck d = new Deck();
      assertFalse(Arrays.equals(deck, d.getDeck()));
   }
   
    @Test
   public void deckSizeTest()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] deck = new Card[] {card, card2};
      Deck d = new Deck(deck);
      assertEquals(2, d.size());
   }
   
    @Test
   public void deckDrawTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] deck = new Card[] {card, card2};
      Deck d = new Deck(deck);
      assertEquals(card2, d.draw());
   }

    @Test
   public void deckDrawTest2()
   {
      Card[] deck = new Card[] {};
      Deck d = new Deck(deck);
      assertEquals(null, d.draw());
   }

   @Test
   public void deckDrawTest3()
   {
      Card[] deck = new Card[] {null};
      Deck d = new Deck(deck);
      assertEquals(null, d.draw());
   }

   @Test
   public void deckAddCardTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] deckTest = new Card[] {card, card2};
      Card[] deck = new Card[] {card};
      Deck d = new Deck(deck);
      d.addCard(card2);
      assertTrue(Arrays.equals(deckTest, d.getDeck()));
   }

   @Test
   public void deckAddCardTest2()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = null;
      Card[] deckTest = new Card[] {card};
      Card[] deck = new Card[] {card};
      Deck d = new Deck(deck);
      d.addCard(card2);
      assertTrue(Arrays.equals(deckTest, d.getDeck()));
   }
   

   @Test
   public void deckReshuffleTest2()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] deck2 = new Card[] {card, card2, card2};
      Card[] deck = new Card[] {card};
      Deck d = new Deck(deck);
      d.reshuffle(deck2);
      assertEquals(4, d.size());
   }

   @Test
   public void getDiscardPileTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] discardPile = new Card[] {card, card2};
      DiscardPile d = new DiscardPile(discardPile);
      assertTrue(Arrays.equals(discardPile, d.getDiscardPile()));
   }
   
    @Test
   public void getDiscardPileTest2()
   {
      Card[] deck = new Card[] {};
      DiscardPile d = new DiscardPile();
      assertTrue(Arrays.equals(deck, d.getDiscardPile()));
   }

   @Test
   public void discardPileSizeTest()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] discardPile = new Card[] {card, card2};
      DiscardPile d = new DiscardPile(discardPile);
      assertEquals(2, d.size());
   }

   @Test
   public void discardPileAddCardTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] discardPileTest = new Card[] {card, card2};
      Card[] discardPile = new Card[] {card};
      DiscardPile d = new DiscardPile(discardPile);
      d.addCard(card2);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
   }

   @Test
   public void discardPileAddCardTest2()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = null;
      Card[] discardPileTest = new Card[] {card};
      Card[] discardPile = new Card[] {card};
      DiscardPile d = new DiscardPile(discardPile);
      d.addCard(card2);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
   }

   @Test
   public void discardPileRemoveCardTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card[] discardPileTest = new Card[] {card, card2};
      Card[] discardPile = new Card[] {card, card2, card3};
      DiscardPile d = new DiscardPile(discardPile);
      d.removeCard(card3);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
      assertEquals(card3, d.removeCard(card3));
   }

 @Test
   public void discardPileRemoveCardTest2()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card[] discardPileTest = new Card[] {card, card2, card3};
      Card[] discardPile = new Card[] {card, card2, card3, card};
      DiscardPile d = new DiscardPile(discardPile);
      d.removeCard(card);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
      assertEquals(card, d.removeCard(card));
   }

   @Test
   public void discardPileRemoveCardTest3()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card card4 = null;
      Card[] discardPileTest = new Card[] {card, card2, card3};
      Card[] discardPile = new Card[] {card, card2, card3};
      DiscardPile d = new DiscardPile(discardPile);
      d.removeCard(card4);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
      assertEquals(null, d.removeCard(card4));
   }

   @Test
   public void discardPileRemoveCardTest4()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card[] discardPileTest = new Card[] {card, card2};
      Card[] discardPile = new Card[] {card, card2};
      DiscardPile d = new DiscardPile(discardPile);
      d.removeCard(card3);
      assertTrue(Arrays.equals(discardPileTest, d.getDiscardPile()));
      assertEquals(null, d.removeCard(card3));
   }

   @Test
   public void discardPileRemoveAllTest3()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card[] discardPileTest = new Card[] {card, card2, card3};
      Card[] discardPileTest2 = new Card[] {};
      Card[] discardPile = new Card[] {card, card2, card3};
      DiscardPile d = new DiscardPile(discardPile);
      assertTrue(Arrays.equals(discardPileTest, d.removeAll()));
      d.removeAll();
      assertTrue(Arrays.equals(discardPileTest2, d.getDiscardPile()));
   }

   @Test
   public void discardPileToStringTest()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card card3 = new Card("2", "Spades", 1);
      Card[] discardPile = new Card[] {card, card2, card3};
      DiscardPile d = new DiscardPile(discardPile);
      assertEquals("Ace of Spades, 2 of Diamonds, 2 of Spades.", d.toString());
   }

   @Test
   public void playerConstructorTest1()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] hand = new Card[] {card, card2};
      Player p = new Player("Jerry", 18, hand);
      assertEquals("Jerry", p.getName());
      assertEquals(18, p.getAge());
      assertArrayEquals(hand, p.getHand());
   }

   @Test
   public void playerConstructorTest2()
   {
      Card[] hand = new Card[] {};
      Player p = new Player("Jerry", 18);
      assertEquals("Jerry", p.getName());
      assertEquals(18, p.getAge());
      assertArrayEquals(hand, p.getHand());
   }
   
   @Test
   public void playerSizeTest()
   {
      Card card = new Card("Ace", "Spades", 13);
      Card card2 = new Card("2", "Diamonds", 1);
      Card[] hand = new Card[] {card, card2};
      Player p = new Player("Jerry", 18, hand);
      assertEquals(2, p.size());
      
   }

   
}



