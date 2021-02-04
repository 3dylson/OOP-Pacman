package pacman;

public class Config_Handler {

    public Skeleton parent_Skeleton;

    public Config_Handler(Skeleton skel)
      {
        parent_Skeleton=skel;
        parent_Skeleton.printp("constructor     : Config_Handler");
        parent_Skeleton.printn("constructor end : Config_Handler");
      }

    public String SetPlayerName()
      {
        parent_Skeleton.printp("summon          : Config_Handler:SetPlayerName");
        parent_Skeleton.printn("summon end      : Config_Handler:SetPlayerName"); 
        return "Tester";
      }
    
}
