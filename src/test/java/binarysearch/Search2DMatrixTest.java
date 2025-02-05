package binarysearch;/*
* You are given an m x n 2-D integer array matrix and an integer target.

    Each row in matrix is sorted in non-decreasing order.
    The first integer of every row is greater than the last integer of the previous row.

Return true if target exists within matrix or false otherwise.
* */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Search2DMatrixTest {

    @Test
    void testSearchMatrix() {
        int[][] matrix = new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        Assertions.assertThat(searchMatrix(matrix, 1)).isTrue();
        Assertions.assertThat(searchMatrix(matrix, 8)).isTrue();
        Assertions.assertThat(searchMatrix(matrix, 10)).isTrue();
        Assertions.assertThat(searchMatrix(matrix, 14)).isTrue();
        Assertions.assertThat(searchMatrix(matrix, 40)).isTrue();

        Assertions.assertThat(searchMatrix(matrix, 15)).isFalse();
        Assertions.assertThat(searchMatrix(matrix, 0)).isFalse();
        Assertions.assertThat(searchMatrix(matrix, 100000)).isFalse();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            int leftValue = matrix[m][0];
            int rightValue = matrix[m][matrix[m].length - 1];

            if (leftValue <= target && rightValue >= target) {
                //this is matrix with target value
                int lm = 0, rm = matrix[m].length - 1;
                while (lm <= rm) {
                    int mm = lm + ((rm - lm) / 2);
                    int middleMatrixValue = matrix[m][mm];
                    if (middleMatrixValue == target) {
                        return true;
                    }
                    if (middleMatrixValue < target) {
                        lm = mm + 1;
                    }
                    if (middleMatrixValue > target) {
                        rm = mm - 1;
                    }
                }
            }

            if (leftValue < target) {
                l = m + 1;
            }

            if (rightValue > target) {
                r = m - 1;
            }
        }

        return false;
    }
}