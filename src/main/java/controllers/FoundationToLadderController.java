package controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import models.Card;
import models.StackCard;
import models.StackLadder;
import models.CardSuit;
import tools.IO;

public class FoundationToLadderController {

	private ArrayList<StackLadder> ladders;
	private Hashtable<CardSuit,StackCard> foundations;

	public FoundationToLadderController(ArrayList<StackLadder> ladders,Hashtable<CardSuit,StackCard> foundations){
		
		this.ladders=ladders;
		this.foundations = foundations;
	}

	public void execute(){
		int fromFoundation = IO.getInstance().readInt("¿ desde que Palo ? (1-4):",1,4);
		int toLadder = IO.getInstance().readInt("¿ a que escalera ? (1-7):",1,7);
		CardSuit foundation = CardSuit.values()[fromFoundation - 1];
		StackCard suit = foundations.get(foundation);
		if(suit.getStackCard().isEmpty()){
			IO.getInstance().writeln("Palo vacio");
		}else{			
			Card card = suit.getStackCard().pop();
			ladders.get(toLadder - 1).getStackCard().push(card);			
		}
	}
}