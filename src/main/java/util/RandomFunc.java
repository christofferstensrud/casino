package util;

public class RandomFunc {

    public RandomFunc() {
        //This is a utility class, don't instantiate it!
    }

    public static int randomBetween(int floor, int ceil) {
        java.util.Random r = new java.util.Random();
        return r.nextInt(ceil + 1) + floor;
    }

    public static int[] randomBetweenMultipleTimes(int floor, int ceil, int numberOfTimes){
        int[] randomNumbers = new int[numberOfTimes];

        for (int i = 0; i < numberOfTimes; i++) {
            randomNumbers[i] = randomBetween(floor, ceil);
        }
        return randomNumbers;
    }

}
