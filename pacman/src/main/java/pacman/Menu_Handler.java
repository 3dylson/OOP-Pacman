package pacman;

public class Menu_Handler {

  public Skeleton parent_Skeleton;

  public Menu_Handler(Skeleton skel, String Chosen) {
    parent_Skeleton = skel;

    parent_Skeleton.printp("constructor     : Menu_Handler");
    Show(Chosen);
    parent_Skeleton.printn("constructor end : Menu_Handler");
  }

  void Show(String Chosen) {
    parent_Skeleton.printp("summon     : Menu_Handler:Show");
    parent_Skeleton.println("display   : " + Chosen);
    parent_Skeleton.printn("summon end : Menu_Handler:Show");
  }

}
