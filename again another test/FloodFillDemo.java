public class FloodFillDemo 
{
   public static void main(String[] args)
   {
      Grid gr = new Grid();
      gr.fill();
      gr.floodfill(3, 4);
      System.out.println(gr.toString());
   }
}
