import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Stack;
/*
* You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

    Every open bracket is closed by the same type of close bracket.
    Open brackets are closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Return true if s is a valid string, and false otherwise.
* */
class ValidParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"{}", "([{}])"})
    void testValid(String s) {
        Assertions.assertThat(isValid(s)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[(])", "]"})
    void testInvalid(String s) {
        Assertions.assertThat(isValid(s)).isFalse();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.add(c);
            switch (c) {
                case ']' -> {
                    stack.pop();
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    stack.pop();
                    if (stack.empty() || stack.pop() != '{') return false;
                }
                case ')' -> {
                    stack.pop();
                    if (stack.empty() || stack.pop() != '(') return false;
                }
            }
        }
        return stack.empty();
    }
}
