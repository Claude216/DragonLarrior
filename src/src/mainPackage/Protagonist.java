package src.mainPackage;
import java.util.Random;

public class Protagonist 
{
    //默认：主角：Lion, 最大生命值：100， 伤害范围：30~50， 恢复药数量：3， 暴击率：20%
	private final String name = "Lion";
    private int health = 100, maxHealth = 100;
    private int maxDamageAmount=45, minDamageAmount=25, damageAmount;
    private int criticalStrikeChance=16;
    private int healthPotionAmount = 3;
    Random rand = new Random();
    
    
    public Protagonist(int health, int maxHealth, 
            int maxDamageAmount, int minDamageAmount, int csc, int healthPotionAmount)
    {
        
        setHealth(health);
        setMaxHealth(maxHealth);
        setDamageAmountRange(maxDamageAmount, minDamageAmount);
        setHealthPotionAmount(healthPotionAmount);
    }
    
    public Protagonist()
    {
        this(100, 100, 45, 25, 20, 3);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setHealth(int h)
    {
        this.health = h;
    }
    
    public void setMaxHealth(int maxh)
    {
        this.maxHealth = maxh;
    }
    
    public int getHealth()
    {
        return this.health;
    }
    
    public int getMaxHealth()
    {
        return this.maxHealth;
    }
    
    public void setDamageAmountRange(int a, int b)
    {
       
            this.maxDamageAmount = a;
            this.minDamageAmount = b;
       
        
        
    }
    
    public int getMaxDamage()
    {
        return this.maxDamageAmount;
    }
    
    public int getMinDamage()
    {
        return this.minDamageAmount;
    }
    
    public int getDamageAmount()
    {
        int i = rand.nextInt(99) + 1;
        if (i > getCriticalStrikeChance())
        {
            return this.damageAmount = rand.nextInt(this.maxDamageAmount - this.minDamageAmount) + this.minDamageAmount + 1;
        }
        else 
        {
            return this.damageAmount = 2 * (rand.nextInt(this.maxDamageAmount - this.minDamageAmount) + this.minDamageAmount + 1);
        }
    }
    
    public void setCriticalStrikeChance(int csc)
    {
        
                this.criticalStrikeChance = csc;
                
            
    }
    
    public int getCriticalStrikeChance()
    {
        return this.criticalStrikeChance;
    }
    
    public void setHealthPotionAmount(int a)
    {
        this.healthPotionAmount = a;
    }
    
    public int getHealthPotionAmount()
    {
        return this.healthPotionAmount;
    }
    
    public void useHealthPotion()//After using health potions, main character can get HP and lose one potion
    {
        if (getHealthPotionAmount() > 0)
        {
            int hpa = getHealthPotionAmount();
            int myHealth = getHealth();
            setHealthPotionAmount(hpa-1);
            if (myHealth + 45 >= this.maxHealth)
            {
                setHealth(this.maxHealth);
            }
            else
            {
                setHealth(myHealth + 45);
            }
            
        }
        
    }
    
    public void fightingInstinct()//Lion 在每次成功战胜怪物后，可以提升自己的能力
    {
        int hi = rand.nextInt(13) + 1;//每次战斗后，随机提升生命值上限 1 到14 点
        int hd = rand.nextInt(8) + 1;//每次战斗后，随机提升攻击力范围 1 到 9 点
        int maxd, mind, maxh;
        maxd = getMaxDamage();
        mind = getMinDamage();
        maxh = getMaxHealth();
        setMaxHealth(maxh + hi);
        setDamageAmountRange(maxd + hd, mind + hd);
        
    }
}