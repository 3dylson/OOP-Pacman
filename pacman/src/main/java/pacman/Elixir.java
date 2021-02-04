package pacman;

public class Elixir extends Surprise {

    public Skeleton parent_Skeleton;

    public Elixir(Skeleton skel)
      {
         parent_Skeleton=skel;
         parent_Skeleton.printp("constructor     : Elixir");
         parent_Skeleton.printn("constructor end : Elixir");
      }

    public void Kill()
      {
         parent_Skeleton.printp("summon          : Elixir:Kill");
         parent_Skeleton.printn("summon end      : Elixir:Kill");
      }
    
}
