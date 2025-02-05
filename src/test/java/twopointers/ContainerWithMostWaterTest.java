package twopointers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/*
https://neetcode.io/problems/max-water-container
Container With Most Water
You are given an integer array heights where heights[i] represents the height of the ithith bar.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.
*/
public class ContainerWithMostWaterTest {

    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            int area = (right - left) * minHeight;
            max = Math.max(area, max);

            if (heights[left] >= heights[right]) right--;
            if (heights[left] < heights[right]) left++;
        }

        return max;
    }

    static final int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};

    @Test
    @FieldSource()
    void testMaxArea() {
        var output = maxArea(heights);
        Assertions.assertThat(output).isEqualTo(36);
    }

    @ParameterizedTest
    @MethodSource("dataMaxArea")
    void testMaxAreaMethodSource(int[] heights, int expectedArea) {
        var output = maxArea(heights);
        Assertions.assertThat(output).isEqualTo(expectedArea);
    }

    private static Stream<Arguments> dataMaxArea() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 2, 5, 4, 7, 3, 6}, 36),
                Arguments.of(new int[]{2, 2, 2}, 4)
        );
    }
}
