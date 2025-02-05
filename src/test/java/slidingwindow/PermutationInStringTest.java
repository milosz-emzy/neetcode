package slidingwindow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
https://neetcode.io/problems/permutation-string

* You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise.
That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters.
* */
public class PermutationInStringTest {

    @Test
    void testCheckInclusionIsTrue() {
        String s1 = "abc";
        String s2 = "lecabee";
        Assertions.assertThat(checkInclusion(s1, s2)).isTrue();
    }

    @Test
    void testCheckInclusionIsTrue1() {
        String s1 = "adc";
        String s2 = "dcda";
        Assertions.assertThat(checkInclusion(s1, s2)).isTrue();
    }

    @Test
    void testCheckInclusionIsFalse() {
        String s1 = "abc";
        String s2 = "lecaabee";
        Assertions.assertThat(checkInclusion(s1, s2)).isFalse();
    }

    private boolean checkInclusion(String s1, String s2) {
        int slidingWindowsLength = s1.length();
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String substring = s2.substring(i, i + slidingWindowsLength);
            if (hasSameCharacters(substring, s1)) return true;
        }
        return false;
    }

    private boolean hasSameCharacters(String substring, String s1) {
        // bac abc -> true
        // abc abc -> true
        // aac abc -> false

        char[] subChar = substring.toCharArray();
        char[] s1Array = s1.toCharArray();

        Arrays.sort(subChar);
        Arrays.sort(s1Array);

        return Arrays.equals(subChar, s1Array);
    }
}
