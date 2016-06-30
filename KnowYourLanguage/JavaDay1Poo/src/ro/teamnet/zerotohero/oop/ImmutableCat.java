package ro.teamnet.zerotohero.oop;

/**
 * Created by user on 6/30/2016.
 */
public final class ImmutableCat {
    private final String culoare;
    private final int varsta;

    private ImmutableCat(String culoare,int varsta){
        this.culoare=culoare;
        this.varsta=varsta;
    }

    public static ImmutableCat getImmutableCat(String culoare, int varsta){
        ImmutableCat immutableCat=new ImmutableCat(culoare,varsta);
        return immutableCat;
    }

    public String getCuloare(){return culoare;}
    public int getVarsta(){return varsta;}
}
