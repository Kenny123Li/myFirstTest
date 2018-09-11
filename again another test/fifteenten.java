import java.util.*;
public class fifteenten
{
public static void main(String[]args)
{
    int decision = 12;
    Stack<Integer> driveway= new Stack<>();
    Stack<Integer> street= new Stack<>();
    Scanner scan = new Scanner(System.in);
    Integer in;
    while (decision != 0)
    {
        System.out.print(":");
        decision = scan.nextInt();
        if (decision > 0)
        {
            driveway.push(decision);
            System.out.print(driveway);
        }
        
        else if (decision < 0)
        {
            if (driveway.empty()){
                 System.out.println("There are no cars in the driveway.");}
            while (driveway.peek() != (-decision)){
                if (!driveway.empty()){
                street.push(driveway.pop());
                System.out.println("Street: "+street);
                System.out.println("Driveway: "+driveway);}
            }
            driveway.pop();
            while (!street.empty()){
            driveway.push(street.pop());
            System.out.println("Street: "+street);
            System.out.println("Driveway: "+driveway);}
        }
    }
}
}
