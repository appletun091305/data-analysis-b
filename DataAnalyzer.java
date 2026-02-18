import java.util.ArrayList;
public class DataAnalyzer {
    private static int searchList(ArrayList<Integer> numbers, int targetNumber) {
        int minIndex  = 0;
        int maxIndex = numbers.size() - 1;
        while (minIndex <= maxIndex) {
            int middleIndex = (int) Math.floor((minIndex + maxIndex) / 2);
            if (targetNumber == numbers.get((int) middleIndex)) {
                return (int) middleIndex;
            } else if (targetNumber < numbers.get((int) middleIndex)) {
                maxIndex = (int) middleIndex - 1;
            } else {
                minIndex = (int) middleIndex + 1;
            }
        }
        return -1;
    }
    private static int linearSearch(ArrayList<Integer> numbers, int targetNumber) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == targetNumber) {
                return i;
            }
        }
        return -1;
    }
    private static int binarySearch(ArrayList<Integer> numbers, int targetNumber) {
        int minIndex = 0;
        int maxIndex = numbers.size() - 1;

        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;

            if (targetNumber == numbers.get(middleIndex)) {
                return middleIndex;
            } else if (targetNumber < numbers.get(middleIndex)) {
                maxIndex = middleIndex - 1;
            } else {
                minIndex = middleIndex + 1;
            }
        }
        return -1;
    }
    private static ArrayList<Integer> reverseList(ArrayList<Integer> numbers) {
        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int temp = numbers.get(left);
            numbers.set(left, numbers.get(right));
            numbers.set(right, temp);

            left++;
            right--;
        }
        return numbers;
    }
    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        ArrayList<Integer> a = new ArrayList<Integer>();

        a.add(1);
        a.add(3);
        a.add(5);
        a.add(7);
        a.add(9);

        int targetNumber = 5;

        System.out.println("Original List: " + a);
        System.out.println();

        // ── Test searchList ──
        long startTime = System.nanoTime();
        int result = dataAnalyzer.searchList(a, targetNumber);
        long duration = System.nanoTime() - startTime;

        if (result != -1) {
            System.out.println("[searchList]    Target " + targetNumber + " found at index: " + result);
        } else {
            System.out.println("[searchList]    Target " + targetNumber + " not found in the list.");
        }
        System.out.println("Time taken: " + duration + " nanoseconds  |  " + (duration / 1000000.0) + " milliseconds\n");

        // ── Test Linear Search ──
        startTime = System.nanoTime();
        int linearResult = linearSearch(a, targetNumber);
        long linearDuration = System.nanoTime() - startTime;

        if (linearResult != -1) {
            System.out.println("[Linear Search] Target " + targetNumber + " found at index: " + linearResult);
        } else {
            System.out.println("[Linear Search] Target " + targetNumber + " not found.");
        }
        System.out.println("Time taken: " + linearDuration + " nanoseconds  |  " + (linearDuration / 1000000.0) + " milliseconds\n");

        // ── Test Binary Search ──
        startTime = System.nanoTime();
        int binaryResult = binarySearch(a, targetNumber);
        long binaryDuration = System.nanoTime() - startTime;

        if (binaryResult != -1) {
            System.out.println("[Binary Search] Target " + targetNumber + " found at index: " + binaryResult);
        } else {
            System.out.println("[Binary Search] Target " + targetNumber + " not found.");
        }
        System.out.println("Time taken: " + binaryDuration + " nanoseconds  |  " + (binaryDuration / 1000000.0) + " milliseconds\n");

        // ── Test Reverse List ──
        startTime = System.nanoTime();
        ArrayList<Integer> reversed = reverseList(a);
        long reverseDuration = System.nanoTime() - startTime;

        System.out.println("[Reverse List]  Reversed list: " + reversed);
        System.out.println("Time taken: " + reverseDuration + " nanoseconds  |  " + (reverseDuration / 1000000.0) + " milliseconds");
    }
}