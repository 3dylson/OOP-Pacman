package pacman;

public class GameSet {

    public Skeleton parent_Skeleton;
    public Scheduler child_Scheduler;
    public Level child_Level;

    boolean ExitStatus=false;
    public boolean GameOver=false;
    String PlayerName;
    int Level=0;
    int Score=0;
    int Time=0;


    public GameSet(Skeleton skel, String PlayerName)
      {
      parent_Skeleton=skel;
      parent_Skeleton.printp("construtor     : GameSet");
      NewLevel();
      parent_Skeleton.printn("construtor end : GameSet");
      }


    public void NewLevel()
      {
      parent_Skeleton.printp("summon         : GameSet:NewLevel");
      Level++;;
      GenerateLevel(Level);
      Start();
      GameOver();
      parent_Skeleton.printp("summon end     : GameSet:NewLevel");
      }


    public void GenerateLevel(int Level)
        {
        parent_Skeleton.printp("summon       : GameSet:GenerateLevel"); 
        child_Level = new Level(parent_Skeleton, this, Level);
        child_Level.GenerateLab();
        parent_Skeleton.printn("summon end   : GameSet:GenerateLevel"); 
        }


    public void Start()
        {
        parent_Skeleton.printp("summon       : GameSet:Start");
        child_Scheduler = new Scheduler(parent_Skeleton, this);    
        parent_Skeleton.printn("summon end   : GameSet:Start");
        }


    public void GameOver()
        {
          parent_Skeleton.printp("summon     : GameSet:GameOver");
          ExitStatus=true;
          parent_Skeleton.printn("summon end : GameSet:GameOver");
        }

    
}
