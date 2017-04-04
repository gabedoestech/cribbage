import java.io.*;
import java.util.*;
import java.lang.*;

class Card
{
	String name;
	String card;
	String type;
	int value;

	Card(String name, String card, String type, int value)
	{
		// Actual name of card: "sA" (ace of spades)
		this.name = name;
		// Type of card: "A"
		this.card = card;
		// Suit of card: "s" (spades)
		this.type = type;
		// Value of card: "1"
		this.value = value;
	}
}

public class Cribbage 
{
	// Check to see if the cards in play add up to 15 or 31 (does not work for counting points at end of round)
	public static int total15or31(ArrayList<Card> played)
	{
		int total = 0;
		
		for(int i = 0; i < played.size(); i++)
			total += played.get(i).value;
		
		if (total == 15)
		{	
			System.out.println("15");
			return 2;
		}	
		else if (total == 31)
		{	
			System.out.println("31");
			return 2;
		}	
		else
			return 0;
	}
	
	// Checks to see if there are any pairs (does not work for when actually playing cards)
	public static int pairs(ArrayList<Card> played)
	{		
		HashSet<String> alreadyCounted = new HashSet<String>();
		int total = 0, score = 0;
		
		for (int i = 0; i < played.size(); i++)
		{
			if (total == 1)
			{	
				score += 2;
				System.out.println("Pair");
			}	
			else if (total == 2)
			{	
				score += 6;
				System.out.println("Pair royal");
			}	
			else if (total == 3)
			{	
				score += 12;
				System.out.println("Double Pair Royal");
			}
			
			total = 0;
			
			// Skip if we've already found all the pairs for this card
			if (alreadyCounted.contains(played.get(i).card))
				continue;
			
			// Find all pairs
			for (int j = 0; j < played.size(); j++)
			{	
				if (played.get(i).card.equals(played.get(j).card) && j > i)
				{
					total++;
					alreadyCounted.add(played.get(i).card);
				}
				
			}
		}
		
		return score;
	}
	
	// Not implemented
	public static int run(ArrayList<Card> played)
	{
		return 0;
	}
	
	// Score for playing the last card
	public static int go()
	{
		System.out.println("Go");
		return 1;
	}
	
	// Check to see if a hand has a jack that matches the suit of the card on top of the deck (checks at the end of a round)
	public static int nobs(ArrayList<Card> played)
	{
		for(int i = 0; i < played.size() - 1; i++)
		{
			if(played.get(i).card.equals("J") && played.get(i).type.equals(played.get(played.size() - 1).type))
			{	
				System.out.println("Nobs");
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void main(String [] args)
	{
		// Holds the deck of cards
		ArrayList<Card> deck = new ArrayList<Card>();
		// Holds player 1's hand and adjusts as player 1 chooses cards to discard or play
		ArrayList<Card> p1hand = new ArrayList<Card>();
		// Holds player 2's hand and adjusts as player 2 chooses cards to discard or play
		ArrayList<Card> p2hand = new ArrayList<Card>();
		// Holds player 1's hand after discarding 2 cards and the card on top of the deck (used for scoring)
		ArrayList<Card> p1endHand = new ArrayList<Card>();
		// Holds player 2's hand after discarding 2 cards and the card on top of the deck (used for scoring)
		ArrayList<Card> p2endHand = new ArrayList<Card>();
		// Holds the four cards that were discarded and will hold the card on top of the deck (used for scoring)
		ArrayList<Card> crib = new ArrayList<Card>();
		// Holds the cards that are in play and will be counted for score
		ArrayList<Card> played = new ArrayList<Card>();
		// Holds the card that was flipped over on top of the deck
		ArrayList<Card> topOfDeck = new ArrayList<Card>();
		Scanner sc = new Scanner(System.in);
		int index, p1score = 0, p2score = 0, cardTotal = 0;
		String confirm;
	
		// Create all 52 cards
		Card dA = new Card("dA","A","d",1);
		Card sA = new Card("sA","A","s",1);
		Card cA = new Card("cA","A","c",1);
		Card hA = new Card("hA","A","h",1);
		Card d2 = new Card("d2","2","d",2);
		Card s2 = new Card("s2","2","s",2);
		Card c2 = new Card("c2","2","c",2);
		Card h2 = new Card("h2","2","h",2);
		Card d3 = new Card("d3","3","d",3);
		Card s3 = new Card("s3","3","s",3);
		Card c3 = new Card("c3","3","c",3);
		Card h3 = new Card("h3","3","h",3);
		Card d4 = new Card("d4","4","d",4);
		Card s4 = new Card("s4","4","s",4);
		Card c4 = new Card("c4","4","c",4);
		Card h4 = new Card("h4","4","h",4);
		Card d5 = new Card("d5","5","d",5);
		Card s5 = new Card("s5","5","s",5);
		Card c5 = new Card("c5","5","c",5);
		Card h5 = new Card("h5","5","h",5);
		Card d6 = new Card("d6","6","d",6);
		Card s6 = new Card("s6","6","s",6);
		Card c6 = new Card("c6","6","c",6);
		Card h6 = new Card("h6","6","h",6);
		Card d7 = new Card("d7","7","d",7);
		Card s7 = new Card("s7","7","s",7);
		Card c7 = new Card("c7","7","c",7);
		Card h7 = new Card("h7","7","h",7);
		Card d8 = new Card("d8","8","d",8);
		Card s8 = new Card("s8","8","s",8);
		Card c8 = new Card("c8","8","c",8);
		Card h8 = new Card("h8","8","h",8);
		Card d9 = new Card("d9","9","d",9);
		Card s9 = new Card("s9","9","s",9);
		Card c9 = new Card("c9","9","c",9);
		Card h9 = new Card("h9","9","h",9);
		Card d10 = new Card("d10","10","d",10);
		Card s10 = new Card("s10","10","s",10);
		Card c10 = new Card("c10","10","c",10);
		Card h10 = new Card("h10","10","h",10);
		Card dJ = new Card("dJ","J","d",10);
		Card sJ = new Card("sJ","J","s",10);
		Card cJ = new Card("cJ","J","c",10);
		Card hJ = new Card("hJ","J","h",10);
		Card dQ = new Card("dQ","Q","d",10);
		Card sQ = new Card("sQ","Q","s",10);
		Card cQ = new Card("cQ","Q","c",10);
		Card hQ = new Card("hQ","Q","h",10);
		Card dK = new Card("dK","K","d",10);
		Card sK = new Card("sK","K","s",10);
		Card cK = new Card("cK","K","c",10);
		Card hK = new Card("hK","K","h",10);
	
		// Add all 52 cards to the deck
		deck.add(dA);
		deck.add(sA);
		deck.add(cA);
		deck.add(hA);
		deck.add(d2);
		deck.add(s2);
		deck.add(c2);
		deck.add(h2);
		deck.add(d3);
		deck.add(s3);
		deck.add(c3);
		deck.add(h3);
		deck.add(d4);
		deck.add(s4);
		deck.add(c4);
		deck.add(h4);
		deck.add(d5);
		deck.add(s5);
		deck.add(c5);
		deck.add(h5);
		deck.add(d6);
		deck.add(s6);
		deck.add(c6);
		deck.add(h6);
		deck.add(d7);
		deck.add(s7);
		deck.add(c7);
		deck.add(h7);
		deck.add(d8);
		deck.add(s8);
		deck.add(c8);
		deck.add(h8);
		deck.add(d9);
		deck.add(s9);
		deck.add(c9);
		deck.add(h9);
		deck.add(d10);
		deck.add(s10);
		deck.add(c10);
		deck.add(h10);
		deck.add(dJ);
		deck.add(sJ);
		deck.add(cJ);
		deck.add(hJ);
		deck.add(dQ);
		deck.add(sQ);
		deck.add(cQ);
		deck.add(hQ);
		deck.add(dK);
		deck.add(sK);
		deck.add(cK);
		deck.add(hK);
		
		// Randomly give player 1 six cards, removing them from the deck and adding to player 1's
		// hand and end hand
		for (int i = 0; i < 6; i++)
		{
			index = (int)(Math.random() * (deck.size()));
			p1hand.add(deck.get(index));
			p1endHand.add(deck.get(index));
			deck.remove(deck.get(index));
		}
		
		// Randomly give player 2 six cards, removing them from the deck and adding to player 2's
		// hand and end hand
		for (int i = 0; i < 6; i++)
		{
			index = (int)(Math.random() * (deck.size()));
			p2hand.add(deck.get(index));
			p2endHand.add(deck.get(index));
			deck.remove(deck.get(index));
		}
		
		// Randomly picks one of the remaining cards in the deck to use as the card on top of the deck
		topOfDeck.add(deck.get((int)(Math.random() * (deck.size()))));
		
		System.out.println("Player 1's Hand: ");
		
		for(Card card : p1hand)
			System.out.print(card.name + " ");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Choose a card to discard: ");
		String discardACard = sc.next();
		
		// Discard card from player 1's hand and end hand and adds it to the crib
		for(int i = 0; i < p1hand.size(); i++)
		{
			if (p1hand.get(i).name.equals(discardACard))
			{
				crib.add(p1hand.get(i));
				p1hand.remove(p1hand.get(i));
				p1endHand.remove(p1endHand.get(i));
			}	
		}
		
		System.out.println();
		System.out.println("Player 1's Hand: ");
		
		for(Card card : p1hand)
			System.out.print(card.name + " ");
		
		System.out.println();
		System.out.println();
		
		// Discard second card from player 1's hand and end hand and adds it to the crib
		System.out.println("Choose another card to discard: ");
		discardACard = sc.next();
		
		for(int i = 0; i < p1hand.size(); i++)
		{
			if (p1hand.get(i).name.equals(discardACard))
			{
				crib.add(p1hand.get(i));
				p1hand.remove(p1hand.get(i));
				p1endHand.remove(p1endHand.get(i));
			}	
		}
		
		// Confirmation of ending turn
		System.out.println();
		System.out.println("End turn?");
		confirm = sc.next();
		System.out.println();
		
		System.out.println("Player 2's Hand: ");
		
		for(Card card : p2hand)
			System.out.print(card.name + " ");
		
		System.out.println();
		System.out.println();
		
		// Discard card from player 2's hand and end hand and adds it to the crib
		System.out.println("Choose a card to discard: ");
		discardACard = sc.next();
		
		for(int i = 0; i < p2hand.size(); i++)
		{
			if (p2hand.get(i).name.equals(discardACard))
			{
				crib.add(p2hand.get(i));
				p2hand.remove(p2hand.get(i));
				p2endHand.remove(p2endHand.get(i));
			}	
		}
		
		System.out.println();
		System.out.println("Player 2's Hand: ");
		
		for(Card card : p2hand)
			System.out.print(card.name + " ");
		
		System.out.println();
		System.out.println();
		
		// Discard second card from player 2's hand and end hand and adds it to the crib
		System.out.println("Choose another card to discard: ");
		discardACard = sc.next();
		
		for(int i = 0; i < p2hand.size(); i++)
		{
			if (p2hand.get(i).name.equals(discardACard))
			{
				crib.add(p2hand.get(i));
				p2hand.remove(p2hand.get(i));
				p2endHand.remove(p2endHand.get(i));
			}	
		}
		
		// Confirmation of ending turn
		System.out.println();
		System.out.println("End turn?");
		confirm = sc.next();
		System.out.println();
		
		// Adds card on top of deck to crib, player 1's end hand, and player 2's end hand (can happen
		// after the round has ended instead)
		crib.add(topOfDeck.get(0));
		p1endHand.add(topOfDeck.get(0));
		p2endHand.add(topOfDeck.get(0));

		// Go back and forth between players playing cards
		for (int j = 0; j < 4; j++)
		{
			System.out.println("Player 1's Turn");
			System.out.println("---------------");
			System.out.println("Player 1's Hand: ");
		
			for(Card card : p1hand)
				System.out.print(card.name + " ");
		
				System.out.println();
				System.out.println();
		
				System.out.println("Cards in play: ");
		
			for(Card card : played)
				System.out.print(card.name + " ");
		
			System.out.println();
			System.out.println();
		
			System.out.println("Choose a card to play: ");
			discardACard = sc.next();
		
			// Add chosen card to played and remove it from player 1's hand. If that card would 
			// make the total value of all cards in play exceed 31, remove all cards from played
			//  and start again from total value of 0.
			for(int i = 0; i < p1hand.size(); i++)
			{
				if (p1hand.get(i).name.equals(discardACard))
				{
					cardTotal += p1hand.get(i).value;
					
					if(cardTotal > 31)
					{
						played.clear();
						cardTotal = p1hand.get(i).value; 
					}
					
					played.add(p1hand.get(i));
					p1hand.remove(p1hand.get(i));
				}	
			}
		
			// Check to see if the all cards in play add up to 15 or 31. Give points to player 1 
			// if they do
			p1score = p1score + total15or31(played);
		
			System.out.println("Player 1's Score: " + p1score);
			System.out.println("End turn?");
			confirm = sc.next();
			System.out.println();
		
			System.out.println("Player 2's Turn: ");
			System.out.println("---------------");
			System.out.println("Player 2's Hand: ");
		
			for(Card card : p2hand)
				System.out.print(card.name + " ");
		
			System.out.println();
			System.out.println();
			
			System.out.println("Cards in play: ");
		
			for(Card card : played)
				System.out.print(card.name + " ");
		
			System.out.println();
			System.out.println();
		
			System.out.println("Choose a card to play: ");
			discardACard = sc.next();
		
			// Add chosen card to played and remove it from player 2's hand. If that card would 
			// make the total value of all cards in play exceed 31, remove all cards from played
			//  and start again from total value of 0.
			for(int i = 0; i < p2hand.size(); i++)
			{
				if (p2hand.get(i).name.equals(discardACard))
				{
					cardTotal += p2hand.get(i).value;
					
					if(cardTotal > 31)
					{
						played.clear();
						cardTotal = p2hand.get(i).value; 
					}
					
					played.add(p2hand.get(i));
					p2hand.remove(p2hand.get(i));
				}	
			}
		
			// Check to see if the all cards in play add up to 15 or 31. Give points to player 1 
			// if they do
			p2score = p2score + total15or31(played);
		
			System.out.println("Player 2's Score: " + p2score);
		
			System.out.println("End turn?");
			confirm = sc.next();
			System.out.println();
		}
		
		System.out.println("Player 1's Final Hand: ");
		
		for(Card card : p1endHand)
			System.out.print(card.name + " ");
		
		System.out.println();
		
		// Find if there are pairs or a nobs in player 1's end hand and add the points to their
		// score
		p1score = p1score + nobs(p1endHand) + pairs(p1endHand);
		
		System.out.println("Player 1's Score: " + p1score);
		System.out.println();
		
		System.out.println("Player 2's Final Hand: ");
		
		for(Card card : p2endHand)
			System.out.print(card.name + " ");

		System.out.println();
		
		// Find if there are pairs or a nobs in player 2's end hand and add the points to their
		// score. Player 2 gets a point for playing the last card of the round.
		p2score = p2score + nobs(p2endHand) + pairs(p2endHand) + go();
		
		System.out.println("Player 2's Score: " + p2score);
		System.out.println();
		
		System.out.println("Crib Hand: ");
		
		for(Card card : crib)
			System.out.print(card.name + " ");

		System.out.println();
		
		// Find if there are pairs or a nobs in the crib and add the points to player 2's
		// score. Player 2 gets to use the crib because player 1 was dealer.
		p2score = p2score + nobs(crib)+ pairs(crib);
		
		System.out.println("Player 2's Score: " + p2score);
		
		System.out.println();
		
		System.out.println("Player 1's Final Score: " + p1score);
		System.out.println("Player 2's Final Score: " + p2score);
		
		if(p1score > p2score)
			System.out.println("Player 1 wins with a score of " + p1score + "!");
		else if (p1score < p2score)
			System.out.println("Player 2 wins with a score of " + p2score + "!");
		else
			System.out.println("Player 1 and 2 tie with scores of " + p1score + " and " + p2score + "!");
	}
}
