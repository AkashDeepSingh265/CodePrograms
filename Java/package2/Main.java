package package2;

public class Main {

	public static void main(String[] args)
    {
         System.out.println(Derived.x); 
         System.out.println(Base.x);  //  prints out "3" because the static Derived got built second
    }
}
