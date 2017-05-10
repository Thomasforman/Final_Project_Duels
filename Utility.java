public class Utility
{
    public static int truncate(int num, int min, int max)
    {
        return Math.max(Math.min(num, max), min);
    }
    
    public static int getXOnBoard(int col)
    {
        return col * GameIO.cWidth;
    }
    
    public static int getYOnBoard(int row)
    {
        return row * GameIO.cHeight;
    }
}