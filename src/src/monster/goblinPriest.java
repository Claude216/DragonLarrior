package src.monster;

import java.util.Random;

import src.mainPackage.Protagonist;

public class goblinPriest extends Monster {

	 Random rand = new Random();
	    Protagonist A = new Protagonist();
	    //Some field of Specter
	    private final String monsterName="Goblin Priest";
	    private final int maxHealth=60, minHealth=40;
	    private final int maxDamage=25, minDamage=0;
	    private final int dropHealthPotionChance=50;
	   
	    
	    public goblinPriest(String monsterName,
	                    int maxHealth,
	                    int minHealth,
	                    int maxDamage,
	                    int minDamage,
	                    int dropHealthPotionChance)
	    {
	        super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
	    }
	    
	    public goblinPriest()
	    {
	        this("Goblin Priest", 70, 55, 35, 0, 45);
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
