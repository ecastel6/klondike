package models;

import java.util.ArrayList;
import java.util.Hashtable;

public class Game {
	private StackDeck deck;
	private ArrayList<StackLadder> ladders;
	private Hashtable<CardSuit, StackCard> foundations;
	private StackCard waste;
	private static final int LADDERS_COUNT = 7;
	
	public Game() {
		deck = new StackDeck();
		deck.shuffle();
		ladders = new ArrayList<StackLadder>();
		foundations = new Hashtable<CardSuit, StackCard>();
		waste = new StackCard();
		init();
	}
	
	public void init() {
		for (int i = 0; i < CardSuit.values().length; i++) {
			StackCard suit = new StackCard();
			foundations.put(CardSuit.values()[i], suit);
		}
		for (int i = 1; i <= LADDERS_COUNT; i++) {
			StackLadder stackLadder = new StackLadder();
			stackLadder.addCards(i, deck);
			ladders.add(stackLadder);
		}
	}

	public StackDeck getDeck() {
		return deck;
	}

	public void setDeck(StackDeck deck) {
		this.deck = deck;
	}

	public ArrayList<StackLadder> getLadders() {
		return ladders;
	}

	public void setLadders(ArrayList<StackLadder> ladders) {
		this.ladders = ladders;
	}

	public Hashtable<CardSuit, StackCard> getFoundations() {
		return foundations;
	}

	public void setFoundations(Hashtable<CardSuit, StackCard> foundations) {
		this.foundations= foundations;
	}

	public StackCard getWaste() {
		return waste;
	}

	public void setWaste(StackCard waste) {
		this.waste = waste;
	}
}
