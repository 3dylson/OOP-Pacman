package pacman;

public class Menu_Handler {

    public Skeleton parent_Skeleton;

    public Menu_Handler(Skeleton skel, String Choosen)
      {
        parent_Skeleton=skel;

        parent_Skeleton.printp("constructor     : Menu_Handler");
        Show(Choosen);
        parent_Skeleton.printn("constructor end : Menu_Handler");
      }


    void Show(String Choosen)
      {
        parent_Skeleton.printp("summon     : Menu_Handler:Show");
        parent_Skeleton.println("display   : "+Choosen);
        parent_Skeleton.printn("summon end : Menu_Handler:Show");
      }
    
}
