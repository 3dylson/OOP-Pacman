package pacman;

public class Monsters {
    
    public Skeleton parent_Skeleton;

    public Monsters(Skeleton skel)
      {
        parent_Skeleton=skel;

        parent_Skeleton.printp("constructor     : Monsters");
        parent_Skeleton.printn("constructor end : Monsters");
      }

    public int XPos;
    public int YPos;
    public int MSpeed;
    public boolean isTalented;
    public boolean isAlive;


    public void Move()
        {
          parent_Skeleton.printp("summon     : Monsters:Move");
          parent_Skeleton.printn("summon end : Monsters:Move");
        }


    public void Kill()
      {
         parent_Skeleton.printp("summon     : Monsters:Kill");
         parent_Skeleton.printn("summon end : Monsters:Kill");
      }
}
