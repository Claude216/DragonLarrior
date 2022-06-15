package src.monster;

public class Gromp extends Monster
{
    private final String monsterName="Gromp";
    private final int maxHealth=80, minHealth=70;
    private final int maxDamage=35, minDamage=5;
    private final int dropHealthPotionChance=80;
    public Gromp(String monsterName,
                      int maxHealth,
                      int minHealth,
                      int maxDamage,
                      int minDamage,
                      int dropHealthPotionChance)
    { 
        super(monsterName, maxHealth, minHealth, maxDamage, minDamage, dropHealthPotionChance);
    }
    
    public Gromp()
    {
        this("Gromp", 80, 70, 35, 5, 80);
    }
    
@Override    
    public int ifDropHealthPotions(int hpa)
    {
        
        int i = rand.nextInt(99) + 1;
        int r = rand.nextInt(99) + 1;
        if (i < this.dropHealthPotionChance)
        {
            if (r < 10)
            {
                hpa += 2;
                
            }
            else
            {
                hpa += 1;
               
            }
             
        }
        return hpa;
    }
}
