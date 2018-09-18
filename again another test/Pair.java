import java.util.*;
public class Pair
{
    private int x;
    private int y;
    private static int number=1;
    public Pair(int x_coordinate, int y_coordinate)
    {
        x = x_coordinate;
        y = y_coordinate;
    }
    
    public boolean isFree(int row, int column, Grid gr)
    {
        return (gr.value(row, column) == 0);
    }
    
    public int getrow()
    {
        return x;
    }
    
    public int getcolumn()
    {
        return y;
    }
    
    public int getvalue()
    {
        return number;
    }
}
