import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class CrossLaser extends Obstacle
{
    private int span = 1, damage;
    private long damageTime = (long) 3e9, warningTime = (long) 2e9, creationTime;
    private Player sourcePlayer;
    private boolean warningState = true;
    private Rectangle base;

    public CrossLaser(Rectangle base, int damage, Player source)
    {
        super();
        setCollision(false);
        creationTime = System.nanoTime();
        this.damage = damage;
        this.base = (Rectangle) base.clone();
        Rectangle b1 = new Rectangle((int) (base.getMinX() + (base.getWidth() - span) / 2), 0, span, Constants.WINDOW_HEIGHT);
        Rectangle b2 = new Rectangle(0, (int) (base.getMinY() + (base.getHeight() - span) / 2), Constants.WINDOW_WIDTH, span);
        span = 30;
        bounds.add(b1);
        bounds.add(b2);
        sourcePlayer = source;
    }

    @Override
    public void updateGameState(ArrayList<GamePiece> entities)
    {
        if (System.nanoTime() - creationTime > warningTime && warningState)
        {
            warningState = false;
            creationTime = System.nanoTime();
            Rectangle b1 = new Rectangle((int) (base.getMinX() + (base.getWidth() - span) / 2), 0, span, Constants.WINDOW_HEIGHT);
            Rectangle b2 = new Rectangle(0, (int) (base.getMinY() + (base.getHeight() - span) / 2), Constants.WINDOW_WIDTH, span);
            bounds.clear();
            bounds.add(b1);
            bounds.add(b2);
        }
        if (System.nanoTime() - creationTime > damageTime && !warningState)
        {
            entities.remove(this);
            return;
        }
        for (int i = entities.size() - 1; i >= 0; i--)
        {
            GamePiece g = entities.get(i);
            if (g == this)
            {
                continue;
            }
            if (collide(g) && g instanceof Player && g != sourcePlayer && !warningState)
            {
                doPlayerEffect((Player) g);
            }
        }
    }

    @Override
    public void doPlayerEffect(Player p)
    {
        p.addHealth(-damage);
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        super.drawBounds(g);
    }
}