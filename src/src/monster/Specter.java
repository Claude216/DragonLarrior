package src.monster;


import java.util.*;
import src.mainPackage.Protagonist;

public class Specter extends Monster
{
    
    Random rand = new Random();
    Protagonist A = new Protagonist();
    //Some field of Specter
    private final String monsterName="Specter";
    private final int maxHealth=45, minHealth=35;
    private final int maxDamage=15, minDamage=0;
    private final int dropHealthPotionChance=35;
   
    
    public Specter(String monsterName,
                    int maxHealth,
                    int minHealth,
                    int maxDamage,
                    int minDamage,
                    int dropHealthPotionChance)
    {
        super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
    }
    
    public Specter()
    {
        this("Specter", 45, 35, 15, 0, 20);
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