package pacman;

public class Level {
    
    public GameSet parent_GameSet;
    public Labyrinth child_Labyrinth;
    public Skeleton parent_Skeleton;

    boolean ExitStatus=false;

    public boolean LevelCompleted=false;

    int Monster;
    int Talented;
    int Spd;

    public Level(Skeleton skel, GameSet play, int Level)
      {
        parent_Skeleton=skel;
        parent_GameSet=play;

        parent_Skeleton.printp("constructor     : Level");
        Monster=Level*2;
        Talented=Monster-1;
        Spd=1;
        parent_Skeleton.printn("constructor end : Level");
      }

    public void GenerateLab()
        {
          parent_Skeleton.printp("summon        : Level:GenerateLab");
          child_Labyrinth = new Labyrinth(parent_Skeleton, this, Monster, Talented);
          parent_Skeleton.printn("summon end    : Level:GenerateLab"); 
        }
    
}
