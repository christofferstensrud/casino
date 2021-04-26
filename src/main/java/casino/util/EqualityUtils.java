package casino.util;

public class EqualityUtils {

    /**
     * Compares three objects to each other.
     *
     * @param a the first object
     * @param b the second object
     * @param c the third object
     * @param <T> the generic Object class.
     * @return true if all three objects are equal.
     */
    public static <T> boolean checkThreeEqual(T a, T b, T c){ // Generic method so it can check every type.
        return (a == b) && (a == c);
    }
}
