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
    
    public static int[] addToArray(int[] arr, int num)
    {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = arr[i] + num;
        }
        return result;
    }
}