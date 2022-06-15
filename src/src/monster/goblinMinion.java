package src.monster;


import java.util.*;
import src.mainPackage.Protagonist;

	
	
	public class goblinMinion extends Monster {
	

	
	    
	    Random rand = new Random();
	    Protagonist A = new Protagonist();
	    //Some field of Specter
	    private final String monsterName="Goblin Minion";
	    private final int maxHealth=60, minHealth=40;
	    private final int maxDamage=25, minDamage=0;
	    private final int dropHealthPotionChance=40;
	   
	    
	    public goblinMinion(String monsterName,
	                    int maxHealth,
	                    int minHealth,
	                    int maxDamage,
	                    int minDamage,
	                    int dropHealthPotionChance)
	    {
	        super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
	    }
	    
	    public goblinMinion()
	    {
	        this("Goblin Minion", 60, 40, 25, 0, 40);
	    }
	   
	    @Override
	    public int ifDropHealthPotions(int hpa)
	    {
	        
	        int i = rand.nextInt(99) + 1;
	        if (i < this.dropHealthPotionChance)
	        {
	            hpa += 1;
	        }
	        return hpa;
	    }
	}

