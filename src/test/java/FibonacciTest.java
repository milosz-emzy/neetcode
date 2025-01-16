import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

// fib[i] = fib[i-1] + fib[i-2]
// c = a + b,
public class FibonacciTest {

    @ParameterizedTest
    @MethodSource("provideFibonacciExpData")
    void testFibonacciWithoutArrayWithoutRecursion(int n, int expected) {
        int output = fibonacciWithoutArrayWithoutRecursion(n);
        Assertions.assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciExpData")
    void testFibonacciWithArray(int n, int expected) {
        int output = fibonacciWithArray(n);
        Assertions.assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciExpData")
    void testFibonacciWithRecursion(int n, int expected) {
        int output = fibonacciWithRecursion(n);
        Assertions.assertEquals(expected, output);
    }

    private int fibonacciWithRecursion(int n) {
        if (n <=1) return n;
        return fibonacciWithRecursion(n-1) + fibonacciWithRecursion(n-2);
    }

    private int fibonacciWithArray(int n) {
        if (n <= 1) return n;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    private int fibonacciWithoutArrayWithoutRecursion(int n) {
        if (n <= 1) return n;

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    private static Stream<Arguments> provideFibonacciExpData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8)
        );
    }
}
