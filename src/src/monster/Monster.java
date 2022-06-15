package src.monster;


import java.util.*;
import src.mainPackage.Protagonist;


public abstract class Monster 
{
    Random rand = new Random();
    Protagonist A = new Protagonist();
    //Some field of Specter
    private final String monsterName;
    private final int maxHealth, minHealth;
    private final int maxDamage, minDamage;
    private final int dropHealthPotionChance;
    private int monsterHealth, monsterDamage;
    
    //constructor
    public Monster(String monsterName,
                    int maxHealth,
                    int minHealth,
                    int maxDamage,
                    int minDamage,
                    int dropHealthPotionChance)
    {
        this.monsterName = monsterName;
        this.maxHealth = maxHealth;
        this.minHealth = minHealth;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.dropHealthPotionChance = dropHealthPotionChance;
    }
    
    public String getMonsterName()
    {
        return this.monsterName;
    }
    
    public void initializeMonsterHealth()
    {
        this.monsterHealth = rand.nextInt(this.maxHealth - this.minHealth) + this.minHealth + 1;
    }
    
    public void setMonsterHealth(int h)
    {
        this.monsterHealth = h;
    }
    
    public int getMonsterHealth()
    {
        return this.monsterHealth;
    }
    
    public int getMonsterDamage()
    {
        this.monsterDamage = rand.nextInt(this.maxDamage - this.minDamage) + this.minDamage + 1;
        return this.monsterDamage;
    }
    
    public int ifDropHealthPotions(int hpa)
    {
        
        int i = rand.nextInt(99) + 1;
        if (i < this.dropHealthPotionChance)
        {
            hpa++; 
        }
        return hpa;
    }
}