package util;

import java.util.Random;

public class RandomUtils {

    /**
     * Gives a random integer between two integer bounds.
     *
     * @param floor the lower bound inclusive of the random integer.
     * @param ceil  the upper bound inclusive of the random integer.
     * @return random integer between floor and ceil
     */
    public static int randomBetween(int floor, int ceil) {
        Random r = new Random();
        return r.nextInt(ceil + 1) + floor;
    }

    /**
     * Gives a list of random integers between two integer bounds.
     *
     * @param floor the lower bound inclusive of the random integer.
     * @param ceil  the upper bound inclusive of the random integer.
     * @param numberOfTimes the length of the list.
     * @return list of random integers between floor and ceil
     */
    public static int[] randomBetweenMultipleTimes(int floor, int ceil, int numberOfTimes){
        int[] randomNumbers = new int[numberOfTimes];

        for (int i = 0; i < numberOfTimes; i++) {
            randomNumbers[i] = randomBetween(floor, ceil);
        }
        return randomNumbers;
    }


    /**
     * Generates a random permutation of an array.
     *
     * @param array the array to randomize.
     * @param n     the number of elements to randomize, starting from element number 0 of the array
     * @param <T>   the object type of the array.
     * @return a random permutation of the input array
     */
    public static <T> T[] randomPermutation(T[] array, int n)
    {
        Random r = new Random();

        for (int i = n-1; i > 0; i--) {

            // pick a random index up to i
            int j = r.nextInt(i+1);

            T temp = array[i];
            array[i] = array[j]; // swap the i-th element with the element at the random index
            array[j] = temp;
        }
        return array;
    }
}
