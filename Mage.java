public class Mage extends GameClass
{
    public Mage()
    {
        super(100, 100, 200);
    }
    
    @Override
    public String getDescription()
    {
        return "Mage";
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