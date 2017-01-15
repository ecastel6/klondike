package controllers;

import java.util.Hashtable;

import models.Card;
import models.StackCard;
import models.CardSuit;
import tools.IO;

public class WasteToFoundationController {

	private StackCard waste;
	private Hashtable<CardSuit, StackCard> foundations;

	public WasteToFoundationController(StackCard waste, Hashtable<CardSuit, StackCard> foundations) {
		this.waste = waste;
		this.foundations = foundations;
	}

	public void execute() {
		if (waste.getStackCard().isEmpty()) {
		    IO.getInstance().writeln("Mazo de descartes vacío");
		} else {
			Card wasteCard = waste.getStackCard().lastElement();
			CardSuit wasteSuit = wasteCard.getSuit();
			int wasteValue = wasteCard.getNumber().getCardValue();
			StackCard suitArray = foundations.get(wasteSuit);
			if (suitArray.getStackCard().isEmpty()) {
				if (wasteValue == 1) {
					suitArray.getStackCard().push(waste.getStackCard().pop());
				} else {
				    IO.getInstance().writeln("La primera carta debe ser un AS");
				}
			} else {
				Card suitCard = suitArray.getStackCard().lastElement();
				int suitValue = suitCard.getNumber().getCardValue();
				if (wasteValue == suitValue + 1) {
					suitArray.getStackCard().push(waste.getStackCard().pop());
				} else {
				    IO.getInstance().writeln("Palo erróneo");
				}
			}
		}
	}
}