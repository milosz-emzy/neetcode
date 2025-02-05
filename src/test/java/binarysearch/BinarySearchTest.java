package binarysearch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void testSearchValid() {
        int[] input = new int[]{-1, 0, 2, 4, 6, 8};

        Assertions.assertThat(search(input, -1)).isEqualTo(0);
        Assertions.assertThat(search(input, 0)).isEqualTo(1);
        Assertions.assertThat(search(input, 2)).isEqualTo(2);
        Assertions.assertThat(search(input, 4)).isEqualTo(3);
        Assertions.assertThat(search(input, 6)).isEqualTo(4);
        Assertions.assertThat(search(input, 8)).isEqualTo(5);
        Assertions.assertThat(search(input, 3)).isEqualTo(-1);
        Assertions.assertThat(search(input, -999)).isEqualTo(-1);
        Assertions.assertThat(search(input, 1000000)).isEqualTo(-1);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //do not use (left+right)/2, because it may overflow INT range
            // mid = left + ((right-left)/2)
            int middle = left + ((right - left) / 2);
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            }
        }

        return -1;
    }
}
