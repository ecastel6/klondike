package controllers;

import java.util.ArrayList;

import models.Card;
import models.StackCard;
import models.StackLadder;
import tools.IO;

public class WasteToLadderController {
	
	private StackCard waste;
	private ArrayList<StackLadder> ladders;
	
	public WasteToLadderController(StackCard waste,ArrayList<StackLadder> ladders){
		this.waste=waste;
		this.ladders=ladders;
	}

	public void execute(){
		if (waste.getStackCard().isEmpty()) {
		    IO.getInstance().writeln("Mazo de descartes vacio");
		} else {
			int fromLadder = IO.getInstance().readInt("¿escalera de destino? (1-7):",1,7);
			Card wasteCard = waste.getStackCard().lastElement();
			int wasteValue = wasteCard.getNumber().getCardValue();
			StackLadder escalera = ladders.get(fromLadder - 1);
			if (escalera.getStackCard().isEmpty()) {
				if (wasteValue == 13) {
					escalera.getStackCard().push(waste.getStackCard().pop());
				} else {
				    IO.getInstance().writeln("Carta inválida");
				}
			} else {
				Card ladderCard = escalera.getStackCard().lastElement();
				int ladderCardValue = ladderCard.getNumber().getCardValue();
				if (wasteValue == ladderCardValue - 1) {
					escalera.getStackCard().push(waste.getStackCard().pop());
				} else {
				    IO.getInstance().writeln("Carta inválida");
				}
			}
		}
	}
}