package pacman;


public class Bonus extends Surprise {

    int Value=500;

    public Skeleton parent_Skeleton;

    public Bonus(Skeleton skel)
      {
         parent_Skeleton=skel;
         parent_Skeleton.printp("constructor     : Bonus");
         parent_Skeleton.printn("constructor end : Bonus");
      }


    public void Kill()
      {
         parent_Skeleton.printp("summon          : Bonus:Kill");
         parent_Skeleton.printn("summon end      : Bonus:Kill");
      }
    
}
