package codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
class CyclicRotation {
    public int[] solution(int[] array, int k) {
        // Implement your solution here
        if(array.length == k || k == 0) return array;

        // i + k % array.length
        // 01234 k=3, array.length=5
        // 0 +3 % 5= 3
        // 1 +3 % 5 =4
        // 2+3 % 5 = 0
        // 3+3 % 5 = 1
        // 4+3 % 5 = 2
        int n = array.length;

        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            int newIndex = (i+k) % n;

            temp[newIndex] = array[i];
        }

        return temp;
    }
}
