package exercise.comparatorAndComparable;

import java.util.TreeSet;

/**
 * Created by HOME on 7/4/2016.
 */
public class CompareTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet=new TreeSet<String>(new CustomStringComparator());
        treeSet.add("papagal");
        treeSet.add("oaie");
        treeSet.add("apa");
        treeSet.add("bolivian");
        treeSet.add("columbian");
        treeSet.add("danez");
        treeSet.add("englez");

        for(String s:treeSet){
            System.out.println(s);
        }
    }
}
