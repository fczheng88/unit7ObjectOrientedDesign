/**
   A coin with a monetary value.
*/
public class Coin implements Comparable<Coin>
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }
   
   public int compareTo(Coin other)
   {
       return (int) (this.value - other.value);
   }
   
   public static void main(String[] args)
   {
       java.util.ArrayList<Coin> list = new java.util.ArrayList<Coin>();
       list.add(new Coin(0.10,"dime"));
       list.add(new Coin(0.25,"quarter"));
       list.add(new Coin(0.01,"penny"));
       list.add(new Coin(0.05,"nickel"));
       System.out.println("original list: "+list);
       java.util.Collections.sort(list);
       System.out.println("sorted list: "+list);
    }
}
