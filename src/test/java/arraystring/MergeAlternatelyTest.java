package arraystring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeAlternatelyTest {
    private String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charWordOneArray = word1.toCharArray();
        char[] charWordTwoArray = word2.toCharArray();

        for (int i = 0; i < charWordOneArray.length; i++) {
            char s1 = charWordOneArray[i];
            stringBuilder.append(s1);
            if (i < word2.length()) {
                char s2 = charWordTwoArray[i];
                stringBuilder.append(s2);
            }
        }
        if (word2.length() > word1.length()) {
            //add remaining chars from word2
//        stringBuilder.append(word2.substring(word1.length(), word2.length())); it's the same
            stringBuilder.append(word2, word1.length(), word2.length());
        }
        return stringBuilder.toString();

    }

    public String mergeAlternatelySmartWay(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder merged = new StringBuilder();

        int i = 0;
        while (i < len1 || i < len2) {
            if (i < len1) merged.append(word1.charAt(i));
            if (i < len2) merged.append(word2.charAt(i));

            i++;
        }

        return merged.toString();
    }


    @ParameterizedTest
    @MethodSource("data")
    void testMergeAlternately(String word1, String word2, String expectedWord) {
        Assertions.assertThat(mergeAlternately(word1, word2)).isEqualTo(expectedWord);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("ab", "pqrs", "apbqrs"),
                Arguments.of("abcd", "pq", "apbqcd")
        );
    }


}
