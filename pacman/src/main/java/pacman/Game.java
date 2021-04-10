package pacman;

public class Game {

  public Skeleton parent_Skeleton;
  public String PlayerName;

  boolean ExitStatus = false;

  public Game(Skeleton skel) {
    parent_Skeleton = skel;

    parent_Skeleton.printp("constructor     : Game");

    while (ExitStatus == false) {
      System.out.println("\nGame Menu.");
      System.out.println("1. Game:Initialize           -> GameSet");
      System.out.println("2. Game:Menu_Handler(HST)    -> Menu_Handler");
      System.out.println("3. Game:Menu_Handler(Help)   -> Menu_Handler");
      System.out.println("4. Game:Menu_Handler(Credits)-> Menu_Handler");
      System.out.println("5. Game:Config_Handler       -> Config_Handler");
      System.out.println("6. Game:Exit                 -> exit");

      switch (parent_Skeleton.KeyReader(1, 6)) {
      case 1: {
        Initialize();
        break;
      }
      case 2: {
        Menu_Handler("HST");
        break;
      }
      case 3: {
        Menu_Handler("Help");
        break;
      }
      case 4: {
        Menu_Handler("Credits");
        break;
      }
      case 5: {
        Config_Handler();
        break;
      }
      case 6: {
        Exit();
        break;
      }
      }
    }
    parent_Skeleton.printn("constructor end : Game");
  }

  void Exit() {
    parent_Skeleton.printp("summon        : Exit");
    ExitStatus = true;
    parent_Skeleton.printn("summon end    : Exit");
  }

  void Initialize() {
    parent_Skeleton.printp("summon        : Game:Initialize");
    new GameSet(parent_Skeleton, PlayerName);
    parent_Skeleton.printn("summon end    : Game:Initialize");
  }

  void Config_Handler() {
    parent_Skeleton.printp("summon        : Game:Config_Handler");
    Config_Handler Config_Handler_Object = new Config_Handler(parent_Skeleton);
    PlayerName = Config_Handler_Object.SetPlayerName();
    parent_Skeleton.println("PlayerName   : " + PlayerName);
    parent_Skeleton.printn("summon end    : Game:Config_Handler");
  }

  void Menu_Handler(String Choosen) {
    parent_Skeleton.printp("summon        : Game:Menu_Handler(" + Choosen + ")");
    new Menu_Handler(parent_Skeleton, Choosen);
    parent_Skeleton.printn("summon        : Game:Menu_Handler(" + Choosen + ")");
  }
}
