package src.monster;


import java.util.Random;
import src.mainPackage.Protagonist;

public class GoblinKing extends Monster {
	
	Random rand = new Random();
    Protagonist A = new Protagonist();
    //Some field of Specter
    private final String monsterName="Goblin King";
    private final int maxHealth=220, minHealth=210;
    private final int maxDamage=60, minDamage=20;
    private final int dropHealthPotionChance=100;
   
    
    public GoblinKing(String monsterName,
    		int maxHealth,
            int minHealth,
            int maxDamage,
            int minDamage,
            int dropHealthPotionChance)
    {
    	 super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
    }
    
    public GoblinKing()
    {
        this("Goblin King",260, 240, 55, 45, 100);
    }
   
    @Override
    public int ifDropHealthPotions(int hpa)
    {
        
        int i = rand.nextInt(99) + 1;
        if (i <= this.dropHealthPotionChance)
        {
            hpa += 1;
        }
        return hpa;
    }
}
