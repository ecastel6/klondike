package controllers;

import tools.IO;

public class ExitController {
	public void execute() {
		IO.getInstance().writeln("Saliendo de Klondike...");
		System.exit(0);
	}
}
