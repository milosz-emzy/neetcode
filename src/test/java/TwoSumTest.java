import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

public class TwoSumTest {
    /*
    * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

    You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

    Return the answer with the smaller index first.
    **/
    @ParameterizedTest
    @MethodSource("provideInputs")
    public void testTwoSum(int[] nums, int target, int[] expectedOutput) {
        Assertions.assertThat(twoSum(nums, target)).containsExactly(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("provideInputs")
    public void testTwoSumByHashMap(int[] nums, int target, int[] expectedOutput) {
        Assertions.assertThat(twoSumHashMap(nums, target)).containsExactly(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("dataTwoSumSortedArray")
    public void tesTwoSumSortedArray(int[] nums, int target, int[] expectedOutput) {
        Assertions.assertThat(twoSumSortedArray(nums, target)).containsExactly(expectedOutput);
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 6}, 7, new int[]{0, 1}),
                Arguments.of(new int[]{4, 5, 6}, 10, new int[]{0, 2}),
                Arguments.of(new int[]{5, 5}, 10, new int[]{0, 1})
        );
    }

    private static Stream<Arguments> dataTwoSumSortedArray() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4}, 3, new int[]{1, 2})
        );
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{3, 4, 5, 6};
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int num = nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[]{
                        hashMap.get(diff),
                        i
                };
            }
            hashMap.put(num, i);
        }

        return new int[]{};
    }

    public int[] twoSumSortedArray(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        while(numbers[left] + numbers[right] != target) {
            if(numbers[left]+ numbers[right] > target) right--;
            if(numbers[left]+ numbers[right] < target) left++;
        }

        return new int[]{left+1, right+1};

    }
}
