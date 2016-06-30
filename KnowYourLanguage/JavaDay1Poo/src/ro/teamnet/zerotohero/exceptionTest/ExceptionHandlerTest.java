package ro.teamnet.zerotohero.exceptionTest;

/**
 * Created by HOME on 6/30/2016.
 */
public class ExceptionHandlerTest {
    static void useCoolString(String string) throws CoolException{
        String [] v=string.split(" ");
        if(v[v.length-1].equals("cool")){
            System.out.println("The String '"+string+"' is a cool String ;)");
        }else{
            throw new CoolException("String not cool!!!");
        }
    }

    static String coolifyString(String string){
        if(string==null){return "cool";}
        return string+" cool";
    }

    public static void main(String[] args) {
        String [] strings={"some String that is cool", "some String that is not", null};

        for (int i=0;i<3;i++) {
            try {
                useCoolString(strings[i]);
            } catch (CoolException | NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("coolifing string...");
                System.out.println("Coolified string: "+coolifyString(strings[i]));
            } finally {

            }
        }
    }
}
