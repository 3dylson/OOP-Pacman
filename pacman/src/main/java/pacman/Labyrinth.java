package pacman;

public class Labyrinth {
    
    public Level parent_Level;
    public Skeleton parent_Skeleton;

    public int NumberOfDiamonds=10;
    public int NumberOfMonsters;
    public int NumberOfTalented;
    public int Lives=3;

    public Labyrinth(Skeleton skel, Level leve, int _NumberOfMonsters, int _NumberOfTalented)
      {
        parent_Level=leve;
        parent_Skeleton=skel;

        NumberOfMonsters=_NumberOfMonsters;
        NumberOfTalented=_NumberOfTalented;

        GenerateDiam();
        GenerateMonst();
        GeneratePacman();
      }

    public final Monsters Monsters_List[]=new Monsters[20];
    public final Diamond Diamond_List[]=new Diamond[15];
    public final Surprise Surprise_List[]=new Surprise[15];
    public PacMan PacMan_Object;

    void GenerateDiam()        
        {
          parent_Skeleton.printp("summon     : Labyrinth:GenerateDiam"); 
          for (int diam=0; diam<NumberOfDiamonds ;diam++ )
          {
              Diamond_List[diam]=new Diamond(parent_Skeleton);
          }
          parent_Skeleton.printn("summon end : Labyrinth:GenerateDiam"); 
        }

    void GenerateMonst()
        {
          parent_Skeleton.printp("summon     : Labyrinth:GenerateMonst"); 
          for (int monst=0; monst<NumberOfMonsters ;monst++ )
          {
            Monsters_List[monst] = new Monsters(parent_Skeleton);
          }
          parent_Skeleton.printn("summon end : Labyrinth:GenerateMonst"); 
        }

    void GeneratePacman()
      {
          parent_Skeleton.printp("summon     : Labyrinth:GeneratePacMan"); 
          PacMan_Object = new PacMan(parent_Skeleton);
          parent_Skeleton.printn("summon end : Labyrinth:GeneratePacMan"); 
      }

    public void TurnMonst()        
        {
          parent_Skeleton.printp("summon     : Labyrinth:TurnMonst");
          Monsters_List[0].Move();
          CheckCollision();
          parent_Skeleton.printn("summon end : Labyrinth:TurnMonst"); 
        }

    public  void AddSurprise(int type)        
        {
          parent_Skeleton.printp("summon     : Labyrinth:TurnSurprise");
          if (type==0) { Surprise_List[0] = new Bonus(parent_Skeleton); }
          if (type==1) { Surprise_List[0] = new Elixir(parent_Skeleton); }
          if (type==2) { Surprise_List[0] = new Bomb(parent_Skeleton, false); }
          if (type==4) { Surprise_List[0] = new Bomb(parent_Skeleton, true); }
          parent_Skeleton.printn("summon end : Labyrinth:TurnSurprise");
        }

    public  void KillSurprise(String What)        
        {
          parent_Skeleton.printp("summon     : Labyrinth:KillSurprise("+What+")");
          Surprise_List[0].Kill();
          parent_Skeleton.printn("summon end : Labyrinth:KillSurprise("+What+")"); 
        }

    public  void KillMonster()
        {
          parent_Skeleton.printp("summon     : Labyrinth:KillMonster");
          Monsters_List[0].Kill();
          parent_Skeleton.printn("summon end : Labyrinth:KillMonster"); 
        }

    public  void KillDiamand()
        {
          parent_Skeleton.printp("summon     : Labyrinth:KillDiamand");
          Diamond_List[0].Kill();
          parent_Skeleton.printn("summon end : Labyrinth:KillDiamand"); 
        }

    public  void MovePacMan()
        {
          parent_Skeleton.printp("summon     : Labyrinth:MovePacman"); 
          PacMan_Object.Move();
          CheckCollision();
          parent_Skeleton.printn("summon end : Labyrinth:MovePacman"); 
        }


    public  void CheckCollision()
      {
             boolean ExitStatus=false;
             while ( (ExitStatus==false) &&
                     (parent_Level.LevelCompleted==false) && 
                     (parent_Level.parent_GameSet.GameOver==false)
                   )
              {
                System.out.println("\nPath Simulation.");
                System.out.println("1. It wasn't fussy");
                System.out.println("2. PacMan and Monster");
                System.out.println("3. PacMan and Surprise:Bonus");
                System.out.println("4. PacMan and Surprise:Elixir");
                System.out.println("5. PacMan and Surprise:Bomb");
                System.out.println("6. Monster and Surprise:Bomb(active)"); 
                System.out.println("7. PacMan and Diamond");

                switch ( parent_Skeleton.KeyReader(1,7) )
                {
                  case 1: 
                      {
                      ExitStatus=true;
                      break;
                      }

                  case 2:
                      {
                      parent_Skeleton.printp("it crashes       : PacMan and Monster"); 
                      parent_Skeleton.println("lives           : "+Lives+"->"+(Lives-1));
                      Lives--;
                      if (Lives==0)
                      {
                      parent_Level.parent_GameSet.GameOver=true;
                      break;
                      }
                      else
                      {
                      GenerateDiam();                      
                      GeneratePacman();
                      GenerateMonst();
                      }
                      parent_Skeleton.printn("it crashes end    : PacMan and Monster"); 
                      break; 
                      }

                     case 3:
                      {
                      parent_Skeleton.printp("it crashes        : PacMan and Surprise:Bonus");
                      KillSurprise("Bonus");
                      parent_Skeleton.println("Score            : Score+Surprise");
                      parent_Skeleton.printn("it crashes end    : PacMan and Surprise:Bonus"); 
                      break; 
                      }

                     case 4:
                      {
                      parent_Skeleton.printp("it crashes        : PacMan and Surprise:Elixir");
                      KillSurprise("Elixir");
                      parent_Skeleton.println("Lives            : "+Lives+" -> "+(Lives++));
                      parent_Skeleton.printn("it crashes end    : PacMan and Surprise:Elixir"); 
                      break; 
                      }

                     case 5:
                      {
                      parent_Skeleton.printp("it crashes        : PacMan and Surprise:Bomb");
                      KillSurprise("Bomb");
                      parent_Skeleton.println("Bombs            : "+PacMan_Object.Bombs+" -> "+(PacMan_Object.Bombs+1));
                      PacMan_Object.Bombs++;
                      parent_Skeleton.printn("it crashes end    : PacMan and Surprise:Bomb"); 
                      break; 
                      }

                     case 6:
                      {
                      parent_Skeleton.printp("it crashes        : Monster and Bomb(active)");
                      KillSurprise("Bomb");
                      KillMonster();
                      parent_Skeleton.printn("it crashes end    : Monster and Bomba(active)"); 
                      break; 
                      }

                     case 7:
                      {
                      parent_Skeleton.printp("it crashes        : PacMan and Diamond");
                      KillDiamand();
                      parent_Skeleton.println("Diamonds         : "+NumberOfDiamonds+" -> "+(NumberOfDiamonds-1));
                      NumberOfDiamonds--;
                      if (NumberOfDiamonds==0)
                      {
                       parent_Level.LevelCompleted=true;
                      }
                      parent_Skeleton.printn("it crashes end    : PacMan and Diamond"); 
                      break; 
                      }
                }
              }
      }

}
