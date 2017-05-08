public abstract class GameClass
{
    private int health, attack, recovery;
    
    public GameClass(int baseHealth, int baseAttack, int baseRecovery)
    {
        health = baseHealth;
        attack = baseAttack;
        recovery = baseRecovery;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public int getRecovery()
    {
        return recovery;
    }
    
    public void addHealth(int add)
    {
        health += add;
    }
    
    public void addAttack(int add)
    {
        attack += add;
    }
    
    public void addRecovery(int add)
    {
        recovery += add;
    }
    
    public String getStats()
    {
        return String.format("Health: %d Attack: %d + Recovery: %d", health, attack, recovery);
    }
    
    public abstract int damageDealt();
    public abstract void damageTaken(int damage);
    public abstract String getDescription();
}