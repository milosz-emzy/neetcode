package stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(isValid(s)).isTrue();
        assertThat(isValidWithMap(s)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[(])", "]"})
    void testInvalid(String s) {
        assertThat(isValid(s)).isFalse();
        assertThat(isValidWithMap(s)).isFalse();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.add(c);
            switch (c) {
                case ']' -> {
                    stack.pop();
                    if (stack.empty() || stack.pop() != '[') return false;
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

    public boolean isValidWithMap(String s) {
        Stack<Character> stack = new Stack<>();
        //key closed, value open
        Map<Character, Character> closed = new HashMap<>();
        closed.put(']', '[');
        closed.put('}', '{');
        closed.put(')', '(');

        for (char c : s.toCharArray()) {
            //if open push to stack
            if (closed.containsValue(c)) {
                stack.push(c);
            }

            // if closed
            if (closed.containsKey(c)) {

                // if closed and stack empty "}"
                if (stack.isEmpty()) {
                    return false;
                }

                // if not matching [} [) {) ...
                if (!stack.pop().equals(closed.get(c))) {
                    return false;
                }
            }
        }

        //if all matches stack should be empty
        return stack.isEmpty();
    }
}
