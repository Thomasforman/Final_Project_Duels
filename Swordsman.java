public class Swordsman extends GameClass
{
    public Swordsman()
    {
        super(200, 200, 50);
    }
    
    @Override
    public String getDescription()
    {
        return "Swordsman";
    }
    
    @Override
    public void damageTaken(int damage)
    {
        addHealth(-damage);
    }
    
    @Override
    public int damageDealt()
    {
        return getAttack();
    }
}