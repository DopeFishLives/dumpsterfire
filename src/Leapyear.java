//import java.lang.Intiger;
import java.io.Console;
//System.out.println("");
public class Leapyear
{
    public static void main(String[] args)
    {
        Console cokb = null;
        
        cokb = System.console();
        
        if(cokb != null)
        {
            int val = Integer.parseInt(cokb.readLine("Year: "));
            
            if(((val%4 == 0) || (val%100 == 0)) && (val%400 != 0))
            System.out.println("Oh look, it's a leap year");
            else
            System.out.println("Nope, why didn't you notice that it's not leap year.");
        }
    }
}
