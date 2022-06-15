package src.mainPackage;
import java.util.Random;

public class Protagonist 
{
    //Ĭ�ϣ����ǣ�Lion, �������ֵ��100�� �˺���Χ��30~50�� �ָ�ҩ������3�� �����ʣ�20%
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
    
    public void fightingInstinct()//Lion ��ÿ�γɹ�սʤ����󣬿��������Լ�������
    {
        int hi = rand.nextInt(13) + 1;//ÿ��ս���������������ֵ���� 1 ��14 ��
        int hd = rand.nextInt(8) + 1;//ÿ��ս�������������������Χ 1 �� 9 ��
        int maxd, mind, maxh;
        maxd = getMaxDamage();
        mind = getMinDamage();
        maxh = getMaxHealth();
        setMaxHealth(maxh + hi);
        setDamageAmountRange(maxd + hd, mind + hd);
        
    }
}