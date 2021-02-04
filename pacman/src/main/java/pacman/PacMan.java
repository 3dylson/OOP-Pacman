package pacman;


public class PacMan {
    public Skeleton parent_Skeleton;


    public PacMan(Skeleton skel)
    {
      parent_Skeleton=skel;

      parent_Skeleton.printp("constructor     : PacMan");
      parent_Skeleton.printn("constructor end : PacMan");
    }


    int PosX;
    int PosY;
    int Speed;
    public int Bombs;


    public  void SetBomb()
    {
        parent_Skeleton.printp("to summon     : PacMan:SetBomb");
        parent_Skeleton.printn("to summon end : PacMan:SetBomb"); 
    }


    public  void Move()
      {
        parent_Skeleton.printp("to summon     : PacMan:Move"); 
        parent_Skeleton.printn("to summon end : PacMan:Move");  
      }

}
