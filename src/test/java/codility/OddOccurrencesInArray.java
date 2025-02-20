package codility;// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
class OddOccurrencesInArray {
    public int solution(int[] numbers) {
        // Implement your solution here
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            boolean isAdded = set.add(number);
            if (!isAdded) {
                set.remove(number);
            }
        }
        return set.iterator().next();
    }
}
