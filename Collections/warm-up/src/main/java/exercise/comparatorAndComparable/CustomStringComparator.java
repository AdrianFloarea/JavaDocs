package exercise.comparatorAndComparable;

import java.util.Comparator;

/**
 * Created by HOME on 7/4/2016.
 */
public class CustomStringComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
    }
}
