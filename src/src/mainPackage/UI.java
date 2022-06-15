package src.mainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import src.mainPackage.Game.ChoiceHandler;

public class UI {
	
	JFrame window;
	JPanel littleTitlePanel, bigTitlePanel, mainTextPanel, rolePanel, choicePanel, startButtonPanel;
	JLabel littleTitleLabel, bigTitleLabel, 
	    roleNameLabel, roleNameNameLabel, maxHpLabel, maxHpNumberLabel, hpLabel, hpNumberLabel, potionLabel, potionNumberLabel, damageLabel, damageRangeLabel, criticalLabel, criticalChanceLabel;
	Font bigTitleFont = new Font("Times New Roman", Font.PLAIN, 80),
	     littleTitleFont = new Font("Times New Roman", Font.PLAIN, 20),
	     textFont = new Font("Times New Roman", Font.PLAIN, 23),
	     choiceFont = new Font("Times New Roman", Font.PLAIN, 30),
	     roleFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3;
	JTextArea mainText;
	
	Protagonist role = new Protagonist();
	
	
	
	
	public void createUI(ChoiceHandler cHandler) {
		
		//window
		window = new JFrame();
		window.setSize(1600, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		
		
		//Title Screen
		bigTitlePanel = new JPanel();
		bigTitlePanel.setBounds(200, 150, 1200, 200);
		bigTitlePanel.setBackground(Color.BLACK);
		bigTitleLabel = new JLabel("DRAGON LARRIOR");
		bigTitleLabel.setFont(bigTitleFont);
		bigTitleLabel.setForeground(Color.WHITE);
		bigTitlePanel.add(bigTitleLabel);
		
		
		
		//start button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(700, 600, 200, 100);
		startButtonPanel.setBackground(Color.BLACK);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(choiceFont);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("Start");
		startButton.setFocusPainted(false);
		startButtonPanel.add(startButton);
		
		window.add(bigTitlePanel);
		window.add(startButtonPanel);
		
		
		
		
		//Game Screen 
		// little title
		littleTitlePanel = new JPanel();
		littleTitlePanel.setBounds(50, 0, 350, 50);
		littleTitlePanel.setBackground(Color.BLACK);
		window.add(littleTitlePanel);
		
		littleTitleLabel = new JLabel();
		littleTitleLabel.setBounds(0, 0, 350, 50);
		littleTitleLabel.setBackground(Color.BLACK);
		littleTitleLabel.setForeground(Color.WHITE);
		littleTitleLabel.setFont(littleTitleFont);
		littleTitlePanel.add(littleTitleLabel);
		
		
		//main text area
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 50, 1100, 500);
		mainTextPanel.setBackground(Color.BLACK);
		window.add(mainTextPanel);
		
		mainText = new JTextArea();
		mainText.setBounds(50, 50, 1100, 500);
		mainText.setBackground(Color.BLACK);
		mainText.setForeground(Color.WHITE);
		mainText.setFont(textFont);
		mainText.setLineWrap(true);
		mainText.setEditable(false);
		mainTextPanel.add(mainText);
		
		// choice button
		choicePanel = new JPanel();
		choicePanel.setBounds(400, 600, 500, 150);
		choicePanel.setBackground(Color.BLACK);
		choicePanel.setLayout(new GridLayout(3, 1));
		window.add(choicePanel);
		
		//choice 1
		    choice1 = new JButton("choice1");
		    choice1.setBackground(Color.black);
		    choice1.setForeground(Color.white);
		    choice1.setFont(choiceFont);
		    choice1.setFocusPainted(false);
		    choice1.addActionListener(cHandler);
		    choice1.setActionCommand("c1");
		    choicePanel.add(choice1);
		
		//choice 2
		    choice2 = new JButton("choice2");
		    choice2.setBackground(Color.black);
		    choice2.setForeground(Color.white);
		    choice2.setFont(choiceFont);
		    choice2.setFocusPainted(false);
		    choice2.addActionListener(cHandler);
		    choice2.setActionCommand("c2");
		    choicePanel.add(choice2);
				
		//choice 3
		    choice3 = new JButton("choice3");
		    choice3.setBackground(Color.black);
		    choice3.setForeground(Color.white);
		    choice3.setFont(choiceFont);
			choice3.setFocusPainted(false);
			choice3.addActionListener(cHandler);
			choice3.setActionCommand("c3");
			choicePanel.add(choice3);
			
			
	    //role panel
		rolePanel = new JPanel();
		rolePanel.setBounds(1250, 50, 300, 700);
		rolePanel.setLayout(new GridLayout(6, 2));
		rolePanel.setBackground(Color.BLACK);
		rolePanel.setForeground(Color.WHITE);
		window.add(rolePanel);
		
		//role name 
		    roleNameLabel = new JLabel("Name:");
		    roleNameLabel.setForeground(Color.WHITE);
		    roleNameLabel.setFont(roleFont);
		    rolePanel.add(roleNameLabel);
		    
		    roleNameNameLabel = new JLabel("Lion");
		    roleNameNameLabel.setForeground(Color.yellow);
		    roleNameNameLabel.setFont(roleFont);
		    rolePanel.add(roleNameNameLabel);
		    
		//max hp 
		    maxHpLabel = new JLabel("Max HP:");
		    maxHpLabel.setForeground(Color.WHITE);
		    maxHpLabel.setFont(roleFont);
		    rolePanel.add(maxHpLabel);
		    
		    maxHpNumberLabel = new JLabel("" + role.getMaxHealth());
		    maxHpNumberLabel.setForeground(Color.white);
		    maxHpNumberLabel.setFont(roleFont);
		    rolePanel.add(maxHpNumberLabel);
		    
		//current hp
		    hpLabel = new JLabel("HP:");
		    hpLabel.setForeground(Color.WHITE);
		    hpLabel.setFont(roleFont);
		    rolePanel.add(hpLabel);
		    
		    hpNumberLabel = new JLabel("" + role.getHealth());
		    hpNumberLabel.setForeground(Color.white);
		    hpNumberLabel.setFont(roleFont);
		    rolePanel.add(hpNumberLabel);
		    
		// potion amount
		    potionLabel = new JLabel("HP Potion:");
		    potionLabel.setForeground(Color.WHITE);
		    potionLabel.setFont(roleFont);
		    rolePanel.add(potionLabel);
		    
		    potionNumberLabel = new JLabel("" + role.getHealthPotionAmount());
		    potionNumberLabel.setForeground(Color.white);
		    potionNumberLabel.setFont(roleFont);
		    rolePanel.add(potionNumberLabel);
		    
		// damage range
		    damageLabel = new JLabel("Damage:");
		    damageLabel.setForeground(Color.WHITE);
		    damageLabel.setFont(roleFont);
		    rolePanel.add(damageLabel);
		    
		    damageRangeLabel = new JLabel(role.getMinDamage() + "~" + role.getMaxDamage());
		    damageRangeLabel.setForeground(Color.white);
		    damageRangeLabel.setFont(roleFont);
		    rolePanel.add(damageRangeLabel);
		    
		// critical strike chance
		    criticalLabel = new JLabel("Critical:");
		    criticalLabel.setForeground(Color.WHITE);
		    criticalLabel.setFont(roleFont);
		    rolePanel.add(criticalLabel);
		    
		    criticalChanceLabel = new JLabel("" + role.getCriticalStrikeChance() + "%");
		    criticalChanceLabel.setForeground(Color.white);
		    criticalChanceLabel.setFont(roleFont);
		    rolePanel.add(criticalChanceLabel);
		    
			
		    window.setVisible(true);	
		
	}

}
