package pacman;

public class Diamond {

    public Skeleton parent_Skeleton;

    public Diamond(Skeleton skel)
      {
        parent_Skeleton=skel;

        parent_Skeleton.printp("constructor     : Diamond");
        parent_Skeleton.printn("constructor end : Diamond");
      }


    public void Kill()
      {
         parent_Skeleton.printp("summon         : Diamond:Kill");
         parent_Skeleton.printn("summon end     : Diamond:Kill");
      }
    
}
