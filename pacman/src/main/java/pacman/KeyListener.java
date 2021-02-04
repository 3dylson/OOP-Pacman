package pacman;

public class KeyListener {
    boolean ExitStatus=false;
    
    public Skeleton parent_Skeleton;
    public Scheduler parent_Scheduler;

    public KeyListener(Scheduler sche, Skeleton skel)
      {
      parent_Scheduler=sche;
      parent_Skeleton=skel;


     parent_Skeleton.printp("constructor     : KeyListener");


      while ( (ExitStatus==false) &&
              (parent_Scheduler.parent_GameSet.child_Level.LevelCompleted==false) && 
              (parent_Scheduler.parent_GameSet.GameOver==false)
             )
      {
        System.out.println("\nKeyListener and Scheduler options.");
        System.out.println("1. Scheduler:Turn_Monster             -> Labyrinth");
        System.out.println("2. Scheduler:Turn_Surprise            -> Labyrinth");
        System.out.println("3. Scheduler:Kill_Surprise            -> Labyrinth");
        System.out.println("4. KeyListener:Keypressed_Direction   -> Scheduler");
        System.out.println("5. KeyListener:Keypressed_Pause       -> Scheduler");
        System.out.println("6. KeyListener:Keypressed_BombOut     -> Scheduler");
        System.out.println("7. Scheduler:End                      -> exit");

        switch ( parent_Skeleton.KeyReader(1,7) )
        {
          case 1: { parent_Scheduler.Turn_Monster(); break; }
          case 2: { parent_Scheduler.Turn_Surprise(); break; }
          case 3: { parent_Scheduler.Kill_Surprise(); break; }
          case 4: { Keypressed_Direction(); break; }
          case 5: { Keypressed_Pause(); break; }
          case 6: { Keypressed_BombOut(); break; }
          case 7: { ExitStatus=true; break; }
        }
      }

      parent_Skeleton.printn("constructor end : KeyListener");
      }


      void Keypressed_Direction()
      {
      parent_Skeleton.printp("summon          : KeyListener:Keypressed_Direction");
      parent_Scheduler.Turn_PacMan();
      parent_Skeleton.printn("summon end      : KeyListener:Keypressed_Direction");
      }


      void Keypressed_Pause()
      {
      parent_Skeleton.printp("summon          : KeyListener:Keypressed_Pause");
      parent_Skeleton.println("Resume/Restart");
      parent_Skeleton.printn("summon end      : KeyListener:Keypressed_Pause");
      }


      void Keypressed_BombOut()
      {
      parent_Skeleton.printp("summon          : KeyListener:Keypressed_BombOut");
      parent_Scheduler.DecrBomb();
      parent_Skeleton.printn("summon end      : KeyListener:Keypressed_BombOut");
      }

}
