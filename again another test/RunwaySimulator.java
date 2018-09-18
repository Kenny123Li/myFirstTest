import java.util.*;
/**
   Class for simulating a runway.
*/
public class RunwaySimulator
{
   private Queue<String> land = new LinkedList<>();
   private Queue<String> takeoff = new LinkedList<>();
   /**
      Constructor.
   */
   public RunwaySimulator()
   {
   }

   /**
      Add a flight symbol to the taking off queue.
      @param flightSymbol the flight symbol.
   */
   public void addTakeOff(String flightSymbol)
   {
      takeoff.add(flightSymbol);
   }

   /**
      Add a flight symbol to the landing queue.
      @param flightSymbol the flight symbol.
   */
   public void addLanding(String flightSymbol)
   {
      land.add(flightSymbol);
   }

   /**
      Handle the next action.
   */
   public void handleNextAction()
   {
      if (land.size()==0)
      {
          if(takeoff.size()==0)
            System.out.println("No action to simulate");
          else
            System.out.println(takeoff.remove() + " has taken off");
        }
      else
      {
          System.out.println(land.remove() + " has landed");
        }
        
   }
}
