import java.util.*;
public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Pair p;
   Stack<Pair> fl = new Stack<>();

   /**
      Flood fill, starting with the given row and column.
   */
   public void floodfill(int row, int column)
   {
       int o = 1;
       p = new Pair(row, column);//the start of floodfill
       fl.push(p);
       fill(p.getrow(), p.getcolumn(), o);//must fill the row and column first
       o++;
       
      while (o < 101){
          p = fl.pop();
      if(!(p.getrow() == 0) && p.isFree(p.getrow()-1, p.getcolumn(), this))
      {//checks to see if the element north of p is free, if it is, labels it and pushes
          //on stack
          Pair x = new Pair(p.getrow()-1, p.getcolumn());
          fill(x.getrow(), x.getcolumn(), o);
          fl.push(x);
          o++;
        }
        
      if(!(p.getcolumn() == 9) && p.isFree(p.getrow(), p.getcolumn()+1, this))
      {//checks right
          Pair x = new Pair(p.getrow(), p.getcolumn()+1);
          fill(x.getrow(), x.getcolumn(), o);
          fl.push(x);
          o++;
        }
        
      if(!(p.getrow() == 9) && p.isFree(p.getrow()+1, p.getcolumn(), this))
      {//checks down
          Pair x = new Pair(p.getrow()+1, p.getcolumn());
          fill(x.getrow(), x.getcolumn(), o);
          fl.push(x);
          o++;
        }
        
      if(!(p.getcolumn() == 0) && p.isFree(p.getrow(), p.getcolumn()-1, this))
      {//checks left
          Pair x = new Pair(p.getrow(), p.getcolumn()-1);
          fill(x.getrow(), x.getcolumn(), o);
          fl.push(x);
          o++;
        }}
   }
   
   /**
      Makes every box 0 in the box
   */
   public void fill()
   {
      for(int n=0; n<pixels.length; n++)
      {
          for(int x=0; x<pixels[1].length; x++)
          {
              pixels[n][x] = 0;
            }
        }
   }

   public void fill(int row, int column, int number)
   {
       pixels[row][column] = number;
    }
   
   public int value(int row, int column)
   {
       return pixels[row][column];
    }
    
   public boolean still_has_numbers(int r, int column)
   {
       return ((pixels[r+1][column] == 0) || 
                (pixels[r][column+1] == 0) ||
                (pixels[r][column-1] == 0) ||
                (pixels[r-1][column] == 0));
    }
   //@Override
   public String toString()
   {
      String r = "";
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
            r = r + String.format("%4d", pixels[i][j]);
         r = r + "\n";
      }
      return r;
   }
}
