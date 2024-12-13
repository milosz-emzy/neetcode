//import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class GroupAnagramsTest {



    @ParameterizedTest
    @MethodSource("provideData")
    public void testGroupAnagrams(String[] input, String[][] expectedOutputs) {

        List<List<String>> lists = groupAnagrams(input);
        String[][] actual = lists.stream()
                .map(s -> s.toArray(new String[0]))
                .toArray(String[][]::new);

        Assertions.assertArrayEquals(actual, expectedOutputs);
    }

    public List<List<String>> groupAnagrams(String[] inputWords) {
        HashMap<String, List<String>> res = new HashMap<>();

        for (String word : inputWords) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String sortedWord = new String(charArray);

            res.putIfAbsent(sortedWord, new ArrayList<>());
            res.get(sortedWord).add(word);
        }

        return new ArrayList<>(res.values());

    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new String[]{"act", "pots", "tops", "cat", "stop", "hat"},
                        new String[][]{{"act", "cat"}, {"pots", "tops", "stop"}, {"hat"}}),
                Arguments.of(new String[]{"x"}, new String[][]{{"x"}}),
                Arguments.of(new String[]{""}, new String[][]{{""}})
        );
    }
}
