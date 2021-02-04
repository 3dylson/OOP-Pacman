package pacman;


public class Bomb extends Surprise {

    public Skeleton parent_Skeleton;

    
        public Bomb(Skeleton skel, boolean isActive)
          {
            parent_Skeleton=skel;
    
            if (isActive==false)
            {
            parent_Skeleton.printp("constructor     : Bomb");
            parent_Skeleton.printn("constructor end : Bomb");
            }
            else
            {
            parent_Skeleton.printp("constructor     : Bomb_active");
            parent_Skeleton.printn("constructor end : Bomb_active");
            }
          }
    
        public void Kill()
          {
            parent_Skeleton.printp("summon          : Bomb:Kill");
            parent_Skeleton.printn("summon end      : Bomb:Kill");
          }
    
}
