package src.mainPackage;

public class VisibilityManager {

	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		// show title and start button
		ui.bigTitlePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// hide choice button and main text area and role field
		ui.choicePanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.rolePanel.setVisible(false);
		ui.littleTitlePanel.setVisible(false);
		
	}
	
	public void showRolePanel() {
		
		ui.rolePanel.setVisible(true);
	}
	
	public void showWelcome() {
		
		// hide title and start button
		ui.bigTitlePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		// show choice button and main text area and role field
		ui.choicePanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.littleTitlePanel.setVisible(true);
	}
}
