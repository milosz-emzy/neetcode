package slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


/*
Given a string s, find the length of the longest substring without duplicate characters.

A substring is a contiguous sequence of characters within a string.
* */
public class DistinctSubstringTest {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (!chars.add(s.charAt(right))) {       //add char to char set until they're unique
                chars.remove(s.charAt(left));           //remove duplicated char from left
                left++;                                 //increase left slider after s.charAt(left) has been removed
            }
            maxLength = Math.max(maxLength, chars.size());
        }

        return maxLength;
    }

    @ParameterizedTest
    @MethodSource("data")
    void testLengthOfLongestSubstring(String string, int length) {
        assertThat(lengthOfLongestSubstring(string)).isEqualTo(length);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("xxxx", 1),
                Arguments.of("pppppppppwwkew", 3),
                Arguments.of("pppppppppwwkewwwwwwwwwwwwwwwwwww", 3),
                Arguments.of("zxyzxyz", 3),
                Arguments.of("abcdeffabicdefghjk", 11),
                Arguments.of("abffabic", 5),
                Arguments.of("abcdefzzabcdefghijk", 12),
                Arguments.of("aab", 2),
                Arguments.of("dvdf", 3)
        );
    }
}
