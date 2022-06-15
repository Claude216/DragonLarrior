package src.mainPackage;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.monster.*;


public class Game {

	UI ui = new UI();
    ChoiceHandler cHandler = new ChoiceHandler();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);
    
    
    String nextPosition1, nextPosition2, nextPosition3;
	
	
    Random rand = new Random();
    
    Gromp gromp = new Gromp();
    Evil_Wolf evilWolf = new Evil_Wolf();
    Specter specter = new Specter();
    goblinMinion goblinM = new goblinMinion();
    goblinPriest goblinP = new goblinPriest();
    GoblinKing goblinK = new GoblinKing();
    
    
    
    
    
    
    
    
    
    
	
	public static void main(String[] args) {
		
		new Game();

	}
	
	public Game() {
		
		ui.createUI(cHandler);
		vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "Start":vm.showWelcome(); story.intro(); break;
			case "c1": story.selectPosition(nextPosition1); break;
			case "c2": story.selectPosition(nextPosition2);break;
			case "c3": story.selectPosition(nextPosition3);break;
			
			}
		}
	}
}
