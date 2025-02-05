import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class ReversePolishNotationTest {

    @Test
    void testEvalRPN() {
        String[] tokens = new String[]{"1", "2", "+", "3", "*", "4", "-"};

        Assertions.assertThat(evalRPN(tokens)).isEqualTo(5);
    }

    @Test
    void testEvalRPN1() {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        Assertions.assertThat(evalRPN(tokens)).isEqualTo(22);
    }

    @Test
    void testEvalRPN2() {
        String[] tokens = new String[]{"4","13","5","/","+"};

        Assertions.assertThat(evalRPN(tokens)).isEqualTo(6);
    }

    @Test
    void testEvalRPN3() {
        String[] tokens = new String[]{"2","1","+","3","*"};

        Assertions.assertThat(evalRPN(tokens)).isEqualTo(9);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(left + right);
                }
                case "-" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(left - right);
                }
                case "*" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(left * right);
                }
                case "/" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.add(left / right);
                }
                default -> stack.add(Integer.valueOf(token)); //default is number
            }
            System.out.println(stack);
        }


        return stack.pop();
    }
}