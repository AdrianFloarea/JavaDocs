package exercise.comparatorAndComparable;

/**
 * Created by HOME on 7/4/2016.
 */
public class ComparableTest {
    public static void main(String[] args) {
        if(new Pisica("negru","Tom",3).compareTo(new Pisica("alb","Tarzan",2))>=0){
            System.out.println("Prima pisica este mai in varsta sau de aceeasi varsta");
        }else{
            System.out.println("A doua pisica este mai in varsta");
        }
    }
}
