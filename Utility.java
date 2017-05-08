public class Utility
{
    public static int truncate(int num, int min, int max)
    {
        return Math.max(Math.min(num, max), min);
    }
}