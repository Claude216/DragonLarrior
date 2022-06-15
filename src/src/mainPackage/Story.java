package src.mainPackage;

import src.monster.*;
import java.util.*;



public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	
	int peter = 0, carlota = 0, golring1 = 0, encounter1 = 0, encounter2 = 0, encounter3 = 0, caveEntrance = 0, goblinSA = 0, encounter4 = 0, caveCore = 0, kk = 0, end = 0;
	int fight=0, usePotion=0, kill=0;
	int eneda = 0, eneh = 0, rolda = 0, rolh = 0;// battle
	int preparation_food=0, preparation_potion=0; 
	
	Random rand = new Random();
	

	
	
	
	
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "Background": background(); break;
		case "RoleAbility": roleAbility(); break;
		case "BenYard": BenYard(); break;
		case "townCenter": townCenter(); break;
		case "Peter": Peter(); break;
		case "Carlota": Carlota(); break;
		case "Golring1": Golring1(); break;
		case "SceneForest": SceneForest(); break;
		case "encounter1": encounter1(); break;
		case "encounter2": encounter2(); break;
		case "bush": bush(); break;
		case "encounter3": encounter3(); break;
		case "caveEntrance": caveEntrance(); break;
		case "goblinSA":goblinSA(); break;
		case "caveCore": caveCore(); break;
		case "Fight1": Fight(game.specter); break;
		case "Fight2": Fight(game.evilWolf); break;
		case "Fight3": Fight(game.gromp); break;
		case "Fight4": Fight(game.goblinM); break;
		case "Fight5": Fight(game.goblinP); break;
		case "kill1": kill(game.specter);break;
		case "kill2": kill(game.evilWolf);break;
		case "kill3": kill(game.gromp);break;
		case "kill4": kill(game.goblinM);break;
		case "kill5": kill(game.goblinP);break;
		case "usePotion": UsePotion(); break;
		case "death": death(); break;
		case "fightG": Fight(game.goblinK); break;
		case "kill6": KillKing(); break;
		case "KillKing": KillKing(); break;
		case "End": End(); break;
		
		}
	}
	
	public void intro() {
		
		ui.mainText.setText("Welcome to DRAGON LARRIOR!\n" + "Before we start, you can choose to know something about the game.\n\n" 
				    	                   + "Or you can also skip that, and start your adventure.");
		ui.choice1.setText("Background");
		ui.choice2.setText("Lion's ability");
		ui.choice3.setText("Skip");
		
		
		game.nextPosition1 = "Background";
		game.nextPosition2 = "RoleAbility";
		game.nextPosition3 = "BenYard";
		
	}
	
	public void background() {
		ui.mainText.setText("The story takes place in a small town under the mountain named Ganpolazon.\n"  
                + "The town has been infested by a dragon named Smog for decades. The dragon will attack the town every nine years.\n" 
                + "There were many braves who came to defeat the dragon, but none of them came back after entering Ganpolazon.\n"
                + "There is only one person who has come back, Ben, who was the assistant of the brave who challenged Smog ten years ago.\n"
                + "However, after coming back from Ganpolazon, he did not leave, but stayed in the town until now.\n "
                + "During this period, he accepted a student, our protagonist Lion.\n " 
                + "He taught Lion how to be a brave, hoping that Lion could successfully defeat the dragon.");
		ui.choice1.setText("Lion's ability");
		ui.choice2.setText("Skip");
		ui.choice3.setText("");
		
		
		game.nextPosition1 = "RoleAbility";
		game.nextPosition2 = "BenYard";
		game.nextPosition3 = "";
		
	}
	
	public void roleAbility() {
		ui.mainText.setText("Under Ben's teaching, Lion learned a lot of fighting skills, which allowed him to discover the opponent's weakness in the battle. His attacks have a certain chance to cause a crit and double the damage.\n" + 
				"\n" + 
				"Lion can enhance his abilities while fighting. Each time he successfully defeats his opponent, he can increase 1~10 points of max health and 1~7 points of damage. "
				+ "You can heal Lion by using potions.");
		ui.choice1.setText("Background");
		ui.choice2.setText("Skip");
		ui.choice3.setText("");
		
		
		game.nextPosition1 = "Background";
		game.nextPosition2 = "BenYard";
		game.nextPosition3 = "";
		
	}
	
	public void BenYard() {
		vm.showRolePanel();
		if (preparation_food == 1 && preparation_potion == 1) {

			
               ui.mainText.setText("Ben:\nIt looks like you are ready, Lion.\n" + 
       				"Your goal this time is to go to Golring and defeat the Goblin King there. \nThis will be your first step to becoming a brave.\n" 
      			  + "My friend Grinlam will wait for you there and he will tell you the route."
      			  + "\n\nLion: \nThen see you, sir. I will come back with victory.");
               ui.choice1.setText("Go to Golring");
               ui.choice2.setText("");
               ui.choice3.setText("");

               game.nextPosition1 = "Golring1";
               game.nextPosition2 = "";
               game.nextPosition3 = "";

		}
		else {

                ui.mainText.setText("Ben:\nLion, today is my final test for you. I will give you three hours to prepare. \nCome here after three hours, and I will give you the goal."
			               + "\n\nLion:\nOkay, sir. I will come here on time.");
                ui.choice1.setText("Town center");
                ui.choice2.setText("");
                ui.choice3.setText("");

                game.nextPosition1 = "townCenter";
                game.nextPosition2 = "";
                game.nextPosition3 = "";

		}
	}

	public void townCenter() {
		if(preparation_food == 1 && preparation_potion == 1) {
		    ui.mainText.setText("Lion:\nOK, now I've got everything I need. \n(Lion looks at the nearby clock tower)" 
		    		          + "It¡¯s almost the appointed time, I have to go to Ben¡¯s house");
		    ui.choice1.setText("Peter's restaurant");
		    ui.choice2.setText("Carlota's magic store ");
		    ui.choice3.setText("Ben's house");

		    game.nextPosition1 = "Peter";
		    game.nextPosition2 = "Carlota";
		    game.nextPosition3 = "BenYard";
		}
		else if ((preparation_food == 1 && preparation_potion != 1) || (preparation_food != 1 && preparation_potion == 1)) {
			ui.mainText.setText("Lion:\nLooks like I need more preparation... ");
			ui.choice1.setText("Peter's restaurant");
            ui.choice2.setText("Carlota's magic store");
			ui.choice3.setText("");

			game.nextPosition1 = "Peter";
			game.nextPosition2 = "Carlota";
			game.nextPosition3 = "";
		}
		else {
			ui.mainText.setText("Lion:\nWhat kind of tasks will Ben give me this time?\nThat really makes me curious" 
                    + "\n\nSo now, Let me think about what should I prepare in advance."
  		          + "\nHum... I think I need to get some solid food and buy more potions.");
            ui.choice1.setText("Peter's restaurant");
            ui.choice2.setText("Carlota's magic store");
			ui.choice3.setText("");

			game.nextPosition1 = "Peter";
			game.nextPosition2 = "Carlota";
			game.nextPosition3 = "";
		}
	}

	public void Peter() {
		if (preparation_food == 0) {
		if (peter == 0) {
			peter ++;
			ui.mainText.setText("(Lion opens the door of the restaurant)\n"
					          + "Peter:\r\n" + 
					          "Madam, you can see the place you mentioned after you go out and turn left. . ."
					          + "\nOh, look who is here, my old friend, the most powerful brave in the future, Lion. "
					          + "\nCome on, Bro, what do you want to eat? Tonkatsu? Roast leg of lamb? Or a special Peter Piggy set meal?");
			ui.choice1.setText("Tonkatsu");
			ui.choice2.setText("Tonkatsu");
			ui.choice3.setText("Tonkatsu");

			game.nextPosition1 = "Peter";
			game.nextPosition2 = "Peter";
			game.nextPosition3 = "Peter";
		}
		else if (peter == 1) {
			peter ++;
			ui.mainText.setText("Peter: \nOh, come on, my friend, why don't you choose the third one?\n"
					+ "\nLion:\nWell, each time your SPECIAL meal really gives me a huge SUPRISE, but this time I can¡¯t do that."
					+ "\nSorry, my bro.\n\n " + "Peter:\nWhy?\n\nLion:\nI'm going to take my final test, and today I come here for some solid food."
					          + "\n\nPeter:\nSolid food? Will Ben send you to a dangerous place again? ");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Peter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (peter == 2) {
			peter ++;
			ui.mainText.setText("Lion:\nI'm not sure where, but dangerous is certain. "
					          + "\n\nPeter:\nAlright, Lion. Just take care of yourself, and enjoy your tonkatsu.\nGive me some time to prepare the solid food you want.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Peter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (peter == 3) {
			peter ++;
			preparation_food = 1;
			ui.mainText.setText("(After 20 min)\nPeter: \nOK, Lion. Here are the solid food."
					          + "\nI have tried to make them delicious, but you know, they are solid food."
					          + "\n\nLion:\nThat's enough, thank you, Peter.");
			ui.choice1.setText("Leave");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "townCenter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		}
		else {
			ui.mainText.setText("Peter:\nLion? Why are you still here?");
			ui.choice1.setText("Leave");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "townCenter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
	}

	public void Carlota() {
		if (preparation_potion == 0) {
		if (carlota == 0) {
			carlota ++;
			ui.mainText.setText("Carlota:\nLion, I know you would come here today...\nMy crystal ball told me everything."
					          + "\n\nLion: Cool, Carlota. Then can you tell me where is Ben going to let me go? "
					          + "\n\nCarlota:\nHum...No, Lion, Ben will be angry with me. Before you leave here, let me divination for you.");
			ui.choice1.setText("Sit down");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Carlota";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (carlota == 1) {
			carlota ++;
			ui.mainText.setText("Carlota:\nHum...You will be fine this time, Lion. Luck is still on your side."
					+ "\nThe only thing you should pay attention to is to avoid letting down your guard."
					+ "\n\nLion:\nThank you, Carlota.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Carlota";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (carlota == 2) {
			carlota ++;
			int h = ui.role.getHealthPotionAmount();
			ui.role.setHealthPotionAmount(h + 2);
			ui.potionNumberLabel.setText(""+ui.role.getHealthPotionAmount());
			preparation_potion = 1;
			ui.mainText.setText("Carlota:\nLion, here is your potions. Don't forget that.\nAnd it's time for you to go."
					          + "\n\nLion:\nSee you, Carlota.");
			ui.choice1.setText("Leave");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "townCenter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		}
		else {
			ui.mainText.setText("Carlota:\nLion, do what you should do, don't waste time here.");
			ui.choice1.setText("Leave");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "townCenter";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
	}
	
	public void Golring1() {
		if (golring1 == 0) {
			golring1 ++;
			ui.mainText.setText("Golring, a small town near Gonpolazon. "
					          + "\nThe legendary hero Pan Gouer once beheaded a terrible monster here, \nand gifted one of his rings to a resident who helped him. "
					          + "\nAfter that, the town changed its name to Golring. This small town is famous for its beautiful scenery, \nand there is an endless stream of travelers who come to visit every year. "
					          + "\nNot long ago, a group of goblins suddenly appeared in the forest near the town. \nThey were in peace with the residents at first.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			
		}
		else if (golring1 == 1) {
			golring1 ++;
			ui.mainText.setText("However, their numbers quickly increased, and they began to harass residents."
					          + "\nAt first, these goblins only stole some livestock, but later, they became more fierce and began to rob residents and passing tourists."
					          + "\nThen, they would even bring people from the small town to their cave."
					          + "\nNone knows what happens to those who were taken away by goblins, but none of them came back...");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (golring1 == 2) {
			golring1 ++;
			ui.mainText.setText("Grinlam:\nLion, goood to see you. Ben always mentioned you to me every time he came here, every time."
					          + "\n\nLion:\nI'm also glad to see you here, Mr.Gouer."
					          + "\n\nGrinlam:\nNo, Lion, don't call me like that, I don't like it. Just call me Grinlam. How is Ben?"
					          + "\n\nLion:\nBen is still very, well, energetic.  "
					          + "\n\nGrinlam:\nYeah, energetic, that is how Ben should be, haha.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (golring1 == 3) {
			golring1 ++;
			ui.mainText.setText("Grinlam:\nSorry, Lion, I forgot that you just came here. Find a hotel to rest first, and come here tomorrow morning.\nI will tell you the route to goblins' cave."
					          + "\n\nLion:\nThank you, Grinlam. I'll be here tomorrow moring.");
			ui.choice1.setText("Go to the main street");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (golring1 == 4) {
			golring1 ++;
			ui.mainText.setText("Lion:\nGolring... I remember I have been here before."
					          + "\n(Lion looked around and sighed)"
					          + "\nThis street used to be bustling, not like it is now...Hotel? Alright, I'm gonna have a rest."
					          + "\n(Lion entered into a hotel)");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (golring1 == 5) {
			golring1 ++;
			ui.mainText.setText("Grinlam:\nLion, hope you had a good rest yesterday. "
					          + "Now I will tell you the way to that goblin cave:\n"
					          + "First, you have to go through the forest, but because of the existence of the goblin, \nsome monsters have appeared in this forest, \nand if you want to reach the goblin cave, you must pass through the habitat of these monsters."
					          + " But don't worry, there is no problem to defeat these monsters with your ability."
					          + "\nMost goblin caves don't have complicated structures, so although I don't know the situation inside the cave, you should be able to successfully enter the core area.\nHowever, Lion, please be careful."
					          + "\nBy the way, the Goblin King wears a bone tooth necklace on his neck. \nBring it back. It will be the proof of your successful mission. "
					          + "\n\nLion:\nThank you, Grinlam. I will be back with the necklace.");
			ui.choice1.setText("Enter the forest");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (golring1 == 6) {
			golring1 ++;
			ui.mainText.setText("(Lion entered the forest)\nGrinlam:\n(Soliloquize)\nLion... How could Ben just give him a task with such level? \nWait, a figure? Ah, I get it. It is really your style, Ben.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "SceneForest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (kk == 3&& golring1 == 7) {
			golring1 ++;
			ui.mainText.setText("Grinlam:\nYou are back! Ben and Lion. Hope you guys alright. "
					          + "\n\nBen:\nThank you my old sport. Don't worry, Lion have already defeated the Goblin King."
					          + "\n\nGrinlam:\nOh really? The whole town will appreciate you, Lion"
					          + "\n\nBen:\nThank you, Grinlam. It's for us to say goodbye."
					          + "\n\nGrinlam:\nGoodbye? Don't you want to have a drink before you leave? ");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if(kk == 3&& golring1 == 8) {
			ui.mainText.setText("Ben:\nNo, no, my old sport. I have to start preparing to deal with Smog. "
					          + "\n\nGrinlam:\nSmog? Ok, I got. Just take care of yourself, and, if there is anything I can help you, just tell me."
					          + "\n\nBen:\nSure, my old sport.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "End";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		
		
	}
	
	public void SceneForest() {
		ui.mainText.setText("Lion:\nThe fog in this forest is very thick, and it gets thicker as I go deeper."
				          + "\nBen once told me that this kind of fog sometimes even affects the compass. \nBut fortunately this time he gave me an enchanted compass."
				          + "\n\n(A bush rustled)"
				          + "\n\n(Lion clenched his sword)\nLion:\nLet's do it.");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");

		game.nextPosition1 = "encounter1";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
	}
		
	public void death() {
		if (caveCore == 2) {
			ui.mainText.setText("Lion knelt down and got up to leave, but suddenly, the Goblin King attacked him and killed him.\n\nLion is dead, game over!");
			ui.choice1.setText("");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else {
		ui.mainText.setText("Lion is dead, game over!");
		ui.choice1.setText("");
		ui.choice2.setText("");
		ui.choice3.setText("");

		game.nextPosition1 = "";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		}
	}
	
	public void encounter1() {
		fight = 1;
		usePotion = 1;
		kill = 1;
		
		if(encounter1 == 0) {
			encounter1 ++;
			game.specter.initializeMonsterHealth();
		ui.mainText.setText("A "+game.specter.getMonsterName()+" shows up!"
				          + "\nIts HP is " +game.specter.getMonsterHealth() +"."
				          + "\n\nWhat do you want to do?");
		ui.choice1.setText("Fight");
		ui.choice2.setText("Drink potion");
		ui.choice3.setText("Run");

		game.nextPosition1 = "Fight1";
		game.nextPosition2 = "usePotion";
		game.nextPosition3 = "encounter2";
		}
		else {
			ui.mainText.setText("The "+game.specter.getMonsterName()+"'s HP is "
					+game.specter.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight1";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "encounter2";
		}
	}

	public void encounter2() {
		fight = 2;
		usePotion = 2;
		kill = 2;
		
		if(encounter2 == 0) {
			encounter2 ++;
			game.evilWolf.initializeMonsterHealth();
		ui.mainText.setText("Lion:\nA specter is not a big deal. Let me see what will appear next... \nWait, I know the smell... It belongs to a wolf.\nNot a normal wolf."
				          + "\n\n---------------------------------------------------------------"
				          + "\n\n---------------------------------------------------------------"
				          + "\n\n\nA "+game.evilWolf.getMonsterName()+" shows up!"
				          + "\nIts HP is " +game.evilWolf.getMonsterHealth() +"."
				          + "\n\nWhat do you want to do?");
		ui.choice1.setText("Fight");
		ui.choice2.setText("Drink potion");
		ui.choice3.setText("Run");

		game.nextPosition1 = "Fight2";
		game.nextPosition2 = "usePotion";
		game.nextPosition3 = "bush";
		}
		else {
			ui.mainText.setText("The "+game.evilWolf.getMonsterName()+"'s HP is "
					+game.evilWolf.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight2";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "bush";
		}
	}
	
	public void bush() {
		ui.mainText.setText("Lion:\nOh look, a piece of bush? I think I just find a good place to take a break."
				          + "\n\n(Lion got into the bush)"
				          + "\n\nLion:\nAccording to what Grinlam said, I am going to the core area soon. \nThe core area of this forest is occupied by Gromp."
				          + "\nGromp... This kind of monsters like frogs really make me uncomfortable."
				          + "\nOK, I can't stay here for too long. Come on! Gromp!");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");

		game.nextPosition1 = "encounter3";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
	}
	
	public void encounter3() {
		fight = 3;
		usePotion = 3;
		kill = 3;
		
		if(encounter3 == 0) {
			encounter3 ++;
			game.gromp.initializeMonsterHealth();
		    ui.mainText.setText("A "+game.gromp.getMonsterName()+" shows up!"
				          + "\nIts HP is " +game.gromp.getMonsterHealth() +"."
				          + "\n\nWhat do you want to do?");
		    ui.choice1.setText("Fight");
		    ui.choice2.setText("Drink potion");
		    ui.choice3.setText("Run");

		    game.nextPosition1 = "Fight3";
		    game.nextPosition2 = "usePotion";
		    game.nextPosition3 = "caveEntrance";
		}
		else {
			ui.mainText.setText("The "+game.gromp.getMonsterName()+"'s HP is "
					+game.gromp.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight3";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "caveEntrance";
		}
	}
	
	public void caveEntrance() {
		
		fight = 4;
		usePotion = 4;
		kill = 4;
		if (caveEntrance == 0) {
			caveEntrance ++;
		ui.mainText.setText("Lion:\nIt seems that I have arrived at the Goblin Cave."
				          + "\n(There is a cave tens of meters in front of Lion, and one or two goblins appear sometimes.)"
				          + "\nHum... I think I have to deal with the goblin minions before I enter the cave. ");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");

		game.nextPosition1 = "caveEntrance";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		}
		else if (caveEntrance == 1){
			caveEntrance ++;
			game.goblinM.initializeMonsterHealth();
			ui.mainText.setText("A "+game.goblinM.getMonsterName()+" shows up!"
			          + "\nIts HP is " +game.goblinM.getMonsterHealth() +"."
			          + "\n\nWhat do you want to do?");
			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight4";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "goblinSA";
		}
		else {
			ui.mainText.setText("The "+game.goblinM.getMonsterName()+"'s HP is "
					+game.goblinM.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			

			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight4";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "goblinSA";
		}
	}
	
	public void goblinSA() {
		
		
		fight = 5;
		usePotion = 5;
		kill = 5;
		if (goblinSA == 0) {
			goblinSA ++;
			ui.mainText.setText("Lion:\nThese goblins are really tough.The next enemy will be more dangerous, \nand I need to be more careful, as Carlota said."
					          + "\nNow I have to avoid fighting for a while to save some energy. By the way, I still have solid food prepared by Peter.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "goblinSA";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if(goblinSA == 1) {
			goblinSA ++;
			int hp = ui.role.getHealth();
			if (hp + 60 > ui.role.getMaxHealth()) {
			    ui.role.setHealth(ui.role.getMaxHealth());
			}
			else {
				ui.role.setHealth(hp + 60);
			}
			ui.hpNumberLabel.setText("" + ui.role.getHealth());
			ui.mainText.setText("(Lion eats some solid food and regains some HP.)"
					          + "\nLion:\nThe bloody smell is so strong that I even can't eat more."
					          + "\nWait, here is a, a sacrificial area? There are so many bones here..."
					          + "\nIs that a human skull??!"
					          + "\n(Lion became very angry, his hand even started to tremble.) ");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "goblinSA";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			
		}
		else if (goblinSA == 2) {
			goblinSA ++;
			game.goblinP.initializeMonsterHealth();
			ui.mainText.setText("A "+game.goblinP.getMonsterName()+" shows up!"
			          + "\nIts HP is " +game.goblinP.getMonsterHealth() +"."
			          + "\n\nWhat do you want to do?");
			ui.choice1.setText("Fight ");
			ui.choice2.setText("Drink Potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight5";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "caveCore";
		}
		else {
			ui.mainText.setText("The "+game.goblinP.getMonsterName()+"'s HP is "
					+game.goblinP.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			ui.choice1.setText("Fight ");
			ui.choice2.setText("Drink Potion");
			ui.choice3.setText("Run");

			game.nextPosition1 = "Fight5";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "caveCore";
		}
	}
	
	public void caveCore() {
		fight = 6;
		usePotion = 6;
		kill = 6;
		
	    if (caveCore == 0) {
			caveCore ++;
			ui.mainText.setText("(Lion drew the sword from the goblin priest's body and continued to go to the core area of the cave)"
					          + "\nLion:\n Hum... After coming out of that place (sacrifice area), the smell of blood has faded a lot, \nbut it still makes me sick."
					          + "\n\n(Lion saw a stone door)\nLion:\nBehind this door, it must be the master of these monsters, the Goblin King."
					          + "\n(The door was carved with simple but unusual designs. At the same time, the bloody smell seemed to materialize,\nand the air even began turn red."
					          + "\n(Lion pushed the door open, and Goblin King sat on his throne. looking down at Lion with a look of contempt in its eyes.)");
			ui.choice1.setText(">");
			ui.choice2.setText("");                                                                                       
			ui.choice3.setText("");

			game.nextPosition1 = "caveCore";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (caveCore == 1) {
			caveCore ++;
			ui.mainText.setText("Goblin King:\nHow dare you come here to challenge me, mole? \nHowever, the fact that you are able to break through here shows that you still have some power."
					          + "\nJoin us or leave right now, I can pretend that what you did to those goblins didn't happen."
					          + "\n\nLion:\n");
			ui.choice1.setText("\"No.\"");
			ui.choice2.setText("\"OK, I will join you.\"");
			ui.choice3.setText("\"OK, I will leave here\"");

			game.nextPosition1 = "caveCore";
			game.nextPosition2 = "death";
			game.nextPosition3 = "death";
		}
		else if (caveCore == 2) {
			caveCore ++;
			game.goblinK.initializeMonsterHealth();
			ui.mainText.setText("(The Goblin King standed up from his seat)\nGoblin King:\nGood, mole. Do you want to leave any words before you die?"
					          + "\n\nLion:\nYeah, I want you to know that, today, is a good day for you, to DIE!!!"
					          + "\n(Lion rushed up with his sword)");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "caveCore";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		
		else {
			
			ui.mainText.setText("The "+game.goblinK.getMonsterName()+"'s HP is "
					+game.goblinK.getMonsterHealth() +"."
							+ "\n\nWhat do you want to do next?");
			ui.choice1.setText("Fight");
			ui.choice2.setText("Drink Potion");
			ui.choice3.setText("");

			game.nextPosition1 = "fightG";
			game.nextPosition2 = "usePotion";
			game.nextPosition3 = "";
		}
		
	}
	
	
	
	
	
	
	
	public void Fight(Monster mon) {
		eneda = mon.getMonsterDamage();
		eneh = mon.getMonsterHealth();
		rolda = ui.role.getDamageAmount();
		rolh = ui.role.getHealth();
		mon.setMonsterHealth(eneh - rolda);
		ui.role.setHealth(rolh - eneda);
		ui.hpNumberLabel.setText(""+ui.role.getHealth());
		ui.mainText.setText("\n\nLion caused "+rolda+" damage to "+mon.getMonsterName()+", and "+mon.getMonsterName()+"'s HP is "+mon.getMonsterHealth()+" now."
				          + "\n\n"+mon.getMonsterName()+" caused "+eneda+" damage to Lion, and Lion's HP is "+ui.role.getHealth()+" now.");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		
		switch(fight) {
		case 1:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
			game.nextPosition1 = "encounter1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			}
			else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
				game.nextPosition1 = "kill1";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			else {
				game.nextPosition1 = "death";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
		}break;
		case 2:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
			game.nextPosition1 = "encounter2";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			}
			else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
				game.nextPosition1 = "kill2";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			else {
				game.nextPosition1 = "death";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			}break;
		case 3:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
			game.nextPosition1 = "encounter3";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			}
			else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
				game.nextPosition1 = "kill3";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			else {
				game.nextPosition1 = "death";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
		}break;
		case 4:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
			game.nextPosition1 = "caveEntrance";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			}
			else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
				game.nextPosition1 = "kill4";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			else {
				game.nextPosition1 = "death";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			} 
		}break;
		case 5:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
			game.nextPosition1 = "goblinSA";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			}
			else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
				game.nextPosition1 = "kill5";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
			else {
				game.nextPosition1 = "death";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
			}
		}break;
		case 6:{
			if (mon.getMonsterHealth() > 0 && ui.role.getHealth() > 0) {
				game.nextPosition1 = "caveCore";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
				}
				else if (mon.getMonsterHealth() <= 0 && ui.role.getHealth() > 0){
					game.nextPosition1 = "kill6";
					game.nextPosition2 = "";
					game.nextPosition3 = "";
				}
				else {
					game.nextPosition1 = "death";
					game.nextPosition2 = "";
					game.nextPosition3 = "";
		}
		}
		}
		
		
	}
	
	public void UsePotion() {
		if (ui.role.getHealth() == ui.role.getMaxHealth()) {
			ui.mainText.setText("Lion¡¯s HP is already at its maximum, there is no need to use health potion.");
			
		}
		else {
			ui.role.useHealthPotion();
			ui.mainText.setText("Lion uses health potion, and his HP now is "+ui.role.getHealth()+".");
			ui.potionNumberLabel.setText(""+ui.role.getHealthPotionAmount());
			ui.hpNumberLabel.setText(""+ui.role.getHealth());
		}
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
        
		switch(usePotion) {
		case 1: game.nextPosition1 = "encounter1"; break;
		case 2: game.nextPosition1 = "encounter2"; break;
		case 3: game.nextPosition1 = "encounter3"; break;
		case 4: game.nextPosition1 = "caveEntrance"; break;
		case 5: game.nextPosition1 = "goblinSA"; break;
		case 6: game.nextPosition1 = "caveCore"; break;
		}
		
	}
	
    public void kill(Monster mon) {
		ui.role.fightingInstinct();
		ui.damageRangeLabel.setText(ui.role.getMinDamage()+"~"+ui.role.getMaxDamage());
		ui.maxHpNumberLabel.setText(""+ui.role.getMaxHealth());
		int hpa = ui.role.getHealthPotionAmount(), h = hpa;
		
		if (mon.ifDropHealthPotions(hpa) == ui.role.getHealthPotionAmount()) {
			ui.mainText.setText("Lion successfully defeats "+mon.getMonsterName()+", and he increases his max HP and damage in this battle.");
		}
		else if (mon.ifDropHealthPotions(hpa) == ui.role.getHealthPotionAmount() + 1){
			ui.mainText.setText("Lion successfully defeats "+mon.getMonsterName()+", and he increases his max HP and damage in this battle."
					          + "\n\n"+mon.getMonsterName()+" drops a health potion!");
			ui.role.setHealthPotionAmount(mon.ifDropHealthPotions(h));
			ui.potionNumberLabel.setText(""+ui.role.getHealthPotionAmount());
		}
		else if (mon.ifDropHealthPotions(hpa) == ui.role.getHealthPotionAmount() + 2) {
			ui.mainText.setText("Lion successfully defeats "+mon.getMonsterName()+", and he increases his max HP and damage in this battle."
			          + "\n\n"+mon.getMonsterName()+" drops two health potions! Lucky!");
			ui.role.setHealthPotionAmount(mon.ifDropHealthPotions(h));
			ui.potionNumberLabel.setText(""+ui.role.getHealthPotionAmount());
		}
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
        switch (kill) {
        case 1: game.nextPosition1 = "encounter2"; break;
		case 2: game.nextPosition1 = "bush"; break;
		case 3: game.nextPosition1 = "caveEntrance"; break;
		case 4: game.nextPosition1 = "goblinSA"; break;
		case 5: game.nextPosition1 = "caveCore"; break;
		case 6: game.nextPosition1 = "KillKing"; break;
        }
	}
	
	public void KillKing() {
		if (kk == 0) {
		kk++;	
		
		ui.mainText.setText("Lion:\nGo to the hell, Goblin King. That is what you derve."
				          + "\n(Lion picked up the toothed necklace)"
				          + "\n\nLion:\nWait, what's this, a scale? It doesn't look like a snake scale."
				          + "\n\nBen:\nGood job! Lion! "
				          + "\n\nLion:\nBen? Why are you here?");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");

		game.nextPosition1 = "KillKing";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		}
		else if (kk == 1) {
			kk ++;
			ui.mainText.setText("Ben:\nI was following you the whole time. You are my only student, I must keep you safe."
					+ "\nNow, give that dragon scale to me. "
					+ "\n\nLion:\nDragon? The scale belongs to a dragon?"
					+ "\n\nBen:\nYes, my boy. Or the goblin you just killed wouldn't be a goblin king.");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "KillKing";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (kk == 2) {
			kk ++;
			ui.mainText.setText("Lion:\nSo you mean that the scale made the goblin a goblin king?"
					          + "\n\nBen:\nYeah, kid, and what you saw in the sacrificial area is how the goblin king improve itself."
					          + "\n\nLion:\n..."
					          + "\n\nBen:\nAlright, Lion, don't pay too much attention on this. Now let's go back to Golring and say goodbye to Grinlam.");
			ui.choice1.setText("Go back to Golring");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "Golring1";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
	}
	
	public void End() {
		if (end == 0) {
			end ++;
			ui.mainText.setText("(On Ben and Lion's way back to Ganpolazon)\nBen:\nLion, before we fight smog, I need you to go to Ozean Kingdom to take something back."
					          + "\n\nLion:\nOzean Kingdom? "
					          + "\n\nBen:\nYeah, kid. That is necessary to you to finally defeat Smog."
					          + "\n\nLion:\nSure, I can do anything as long as I can beat Smog. ");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "End";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (end == 1) {
			end ++;
			ui.mainText.setFont(ui.bigTitleFont);
			ui.mainText.setText("End");
			ui.choice1.setText(">");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "End";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
		else if (end == 2) {
			ui.mainText.setText("           Stay tuned for \n"
					+ "         Dragon Larrior II:\n         Ozean Kingdom");
			ui.choice1.setText("");
			ui.choice2.setText("");
			ui.choice3.setText("");

			game.nextPosition1 = "";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
		}
	}
	 
	
	
	
	
	
	
	
}
