import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

public class topKFrequentTest {

    @ParameterizedTest
    @MethodSource("provideData")
    public void testTopKFrequent(int[] nums, int k, int[] output) {

        Assertions.assertArrayEquals(topKFrequent(nums, k), output);
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.keySet().stream().sorted((o1, o2) -> countMap.get(o2) - countMap.get(o1)).limit(k).mapToInt(Integer::intValue).toArray();
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3}, 2, new int[]{3, 2}),
                Arguments.of(new int[]{7, 7}, 1, new int[]{7})
        );
    }


}
