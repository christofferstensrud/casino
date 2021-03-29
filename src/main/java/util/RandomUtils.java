package util;

import java.util.Random;

public class RandomUtils {

    /**
     * Gives a random integer between two integer bounds.
     *
     * @param floor the lower bound inclusive of the random integer.
     * @param ceil the upper bound inclusive of the random integer.
     * @return random integer between floor and ceil
     */
    public static int randomBetween(int floor, int ceil) {
        Random r = new java.util.Random();
        return r.nextInt(ceil + 1) + floor;
    }

    /**
     * Gives a list of random integers between two integer bounds.
     *
     * @param floor the lower bound inclusive of the random integer.
     * @param ceil the upper bound inclusive of the random integer.
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


    // A Function to generate a random permutation of arr[]
    public static <T> T[] randomize(T[] arr, int n)
    {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i+1);

            // Swap arr[i] with the element at random index
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
