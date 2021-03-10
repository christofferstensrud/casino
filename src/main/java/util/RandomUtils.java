package util;

public class RandomUtils {

    /**
     * Gives a random integer between two integer bounds.
     *
     * @param floor the lower bound inclusive of the random integer.
     * @param ceil the upper bound inclusive of the random integer.
     * @return random integer between floor and ceil
     */
    public static int randomBetween(int floor, int ceil) {
        java.util.Random r = new java.util.Random();
        return r.nextInt(ceil + 1) + floor;
    }

    /**
     * Gives a list of random integer between two integer bounds.
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

}
