import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;


//Find all prime numbers less than or equal to N
public class FindPrimeNumbersTest {

    @ParameterizedTest
    @MethodSource("TestDataUtil#provideTestData")
    public void testFindPrimesLessOrEqualThanGivenNumber(int n, int[] results) {
        int[] primesLimitedBy = findPrimeNumbers(n);
        Assertions.assertArrayEquals(primesLimitedBy, results);
    }

    @ParameterizedTest
    @MethodSource("TestDataUtil#provideTestData")
    public void testFindPrimesLessOrEqualThanGivenNumberWithEratosthenesMethod(int n, int[] results) {
        int[] primesLimitedBy = findPrimeNumbersWithEratosthenesMethod(n);
        Assertions.assertArrayEquals(primesLimitedBy, results);
    }

    private int[] findPrimeNumbers(int n) {
        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                p.add(i);
            }
        }
        return p.stream().mapToInt(value -> value).toArray();
    }

    private boolean isPrime(int checkToBePrime) {
        // from 2 to n-1, in order to avoid % by 1 and itself
        for (int i = 2; i < checkToBePrime; i++) {
            // 4 % 2 == 0  => 4 is not a prime
            if (checkToBePrime % i == 0) {
                return false;
            }
        }
        return true;
    }

    // https://dev.to/paulike/efficient-algorithms-for-finding-prime-numbers-5b2h
    private int[] findPrimeNumbersWithEratosthenesMethod(int n) {
        ArrayList<Integer> p = new ArrayList<>();

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    //example k=2 -> is true -> go to 2nd for loop, then sieve number/indexes calculated by k*i
                    primes[k * i] = false;
                }
            }
        }

        for (int i = 1; i < primes.length; i++) {
            if (primes[i]) {
                p.add(i);
            }
        }

        return p.stream().mapToInt(value -> value).toArray();
    }

}
