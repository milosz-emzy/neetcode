import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

//https://neetcode.io/problems/is-palindrome
class ValidPalindromeTest {

    public static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.of("Was it a car or a cat I saw?", true),
                Arguments.of("tab a cat", false),
                Arguments.of("0P", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputs")
    void testIsPalindrome(String s, boolean expectedResult) {
        Assertions.assertEquals(isPalindrome(s), expectedResult);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left=0;
        int right=s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }


}