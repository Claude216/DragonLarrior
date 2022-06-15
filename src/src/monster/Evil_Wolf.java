package src.monster;

import java.util.*;
import src.mainPackage.Protagonist;


public class Evil_Wolf extends Monster
{
    Random rand = new Random();
    Protagonist A = new Protagonist();
    
    //some fields of the monster
    private final String monsterName="Evil Wolf";
    private final int maxHealth=60, minHealth=40;
    private final int maxDamage=20, minDamage=0;
    private final int dropHealthPotionChance=55;
    
    
    public Evil_Wolf(String monsterName,
                      int maxHealth,
                      int minHealth,
                      int maxDamage,
                      int minDamage,
                      int dropHealthPotionChance)
    { 
        super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
    }
    
    public Evil_Wolf()
    {
        this("Evil Wolf", 60, 40, 20, 0, 55);
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
