package pacman;

import java.util.Random;

public class Scheduler {
    
    public GameSet parent_GameSet;
    public Skeleton parent_Skeleton;
    public KeyListener child_KeyListener;


    public Scheduler(Skeleton skel, GameSet played)
      {
        parent_Skeleton=skel;
        parent_GameSet=played;

        parent_Skeleton.printp("constructor     : Scheduler");
        Activate();
        parent_Skeleton.printn("constructor end : Scheduler");
      }


    public void Activate()
      {
        parent_Skeleton.printp("summon       : Scheduler:Activate");
        child_KeyListener = new KeyListener(this,parent_Skeleton);

        if (parent_GameSet.GameOver==true) {}
        if (parent_GameSet.child_Level.LevelCompleted==true)
        {
          parent_GameSet.NewLevel();
        }
        parent_Skeleton.printn("summon end   : Scheduler:Activate");
      }

    public void Turn_Monster()            
        {
          parent_Skeleton.printp("summon     : Scheduler:Turn_Monster");
          parent_GameSet.child_Level.child_Labyrinth.TurnMonst();
          parent_Skeleton.printn("summon end : Scheduler:Turn_Monster"); 
        }


    void Turn_Surprise()        
        {
          parent_Skeleton.printp("summon     : Scheduler:Turn_Surprise");

          Random r = new Random();
          int random_number = r.nextInt()%2+1;
          parent_GameSet.child_Level.child_Labyrinth.AddSurprise(random_number);
          parent_Skeleton.printn("summon end : Scheduler:Turn_Surprise"); 
        }


    void Kill_Surprise()            
        {
          parent_Skeleton.printp("summon     : Scheduler:Kill_Surprise");
          parent_GameSet.child_Level.child_Labyrinth.KillSurprise("");
          parent_Skeleton.printn("summon end : Scheduler:Kill_Surprise"); 
        }


    public void Turn_PacMan()            
        {
          parent_Skeleton.printp("summon     : Scheduler:Turn_PacMan");
          parent_GameSet.child_Level.child_Labyrinth.MovePacMan();
          parent_Skeleton.printn("summon end : Scheduler:Turn_PacMan"); 
        }


    void DecrBomb()
        {
          parent_Skeleton.printp("summon     : Scheduler:DecrBomb");
          int c=parent_GameSet.child_Level.child_Labyrinth.PacMan_Object.Bombs;
          if (c!=0)
          {
          parent_GameSet.child_Level.child_Labyrinth.PacMan_Object.SetBomb();
          parent_GameSet.child_Level.child_Labyrinth.AddSurprise(4); //activebomb
          int b=parent_GameSet.child_Level.child_Labyrinth.PacMan_Object.Bombs--;
          parent_Skeleton.println("Bombs     : "+c+" -> "+(c-1));
          Kill_Surprise();
          }
          else
            { parent_Skeleton.println("Bombs          : 0");}

          parent_Skeleton.printn("summon end : Scheduler:DecrBomb"); 
        }
}
