package pacman;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Skeleton {

  public String whitespace = "";
  public int counter = 0;

  public Skeleton() {
    System.out.println("constructor      : Skeleton");
    System.out.println("\nEdylson F.\n");
    new Game(this);
    System.out.println("constructor end  : Skeleton");
  }

  public void printp(String xout) {
    counter++;
    whitespace += " ";
    System.out.println(whitespace + xout);
    if (counter == 23) {
      System.out.println(KeyReader(0, 0));
      counter = 0;
    }
  }

  public void printn(String xout) {
    counter++;
    System.out.println(whitespace + xout);
    whitespace = whitespace.substring(0, whitespace.length() - 1);
    if (counter == 23) {
      System.out.println(KeyReader(0, 0));
      counter = 0;
    }
  }

  public void println(String xout) {
    System.out.println(whitespace + xout);
  }

  public int KeyReader(int from, int to) {
    int range = -1;
    boolean okay = false;

    System.out.println("from " + from + "- to " + to + "- Menu.");

    BufferedReader Y = new BufferedReader(new InputStreamReader(System.in));
    while (okay == false) {
      okay = true;
      // input
      try {
        range = Integer.parseInt(Y.readLine());
      } catch (Exception e) {
        okay = false;
      }
      if ((range < from) || (range > to)) {
        okay = false;
      }
      // input error
      if (okay == false) {
        System.out.println("Invalid Menu, from " + from + "- to " + to + "- Menu.");
      }
    }
    return range;
  }

  public static void main(String[] args) {
    new Skeleton();
  }

}
