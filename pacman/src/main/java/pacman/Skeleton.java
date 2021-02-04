package pacman;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Skeleton {

    public Skeleton()
      {
        System.out.println("constructor      : Skeleton");
        System.out.println("\nEdylson F.\n");
        Game child_Game = new Game(this);
        System.out.println("constructor vege : Skeleton");
    }

    public String whitespace="";
    public int counter=0;

    public void printp(String xout)
    {
      counter++;
      whitespace+=" ";
      System.out.println(whitespace+xout);
      if (counter==23)
      {
      System.out.println(KeyReader(0,0));
      counter=0;
      }
    }

    public void printn(String xout)
    {
      counter++;
      System.out.println(whitespace+xout);
      whitespace=whitespace.substring(0,whitespace.length()-1);
      if (counter==23)
      {
      System.out.println(KeyReader(0,0));
      counter=0;
      }
    }


    public void println(String xout)
    {
      System.out.println(whitespace+xout);
    }

    public int KeyReader(int from, int to)
    {
         int bill=-1;
         boolean okay=false;

         System.out.println("from "+from+"- to "+to+"- Menu.");

         BufferedReader Y = new BufferedReader(new InputStreamReader(System.in));
         while (okay==false)
           { okay=true;
// input
             try { bill=Integer.parseInt(Y.readLine());}
             catch (Exception e) {okay=false;}  
             if ((bill<from) || (bill>to)) {okay=false;}
// input error
             if (okay==false) {System.out.println("Invalid Menu, from "+from+"- 2to "+to+"- Menu.");}
           }
          return bill;
     }


  public static void main(String[] args)
    {
       Skeleton Skeleton_Object = new Skeleton();
    }
    
}
