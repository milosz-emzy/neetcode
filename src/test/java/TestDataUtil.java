import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataUtil {
    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{1, 2}),
                Arguments.of(3, new int[]{1, 2, 3}),
                Arguments.of(4, new int[]{1, 2, 3}),
                Arguments.of(5, new int[]{1, 2, 3, 5}),
                Arguments.of(7, new int[]{1, 2, 3, 5, 7}),
                Arguments.of(7, new int[]{1, 2, 3, 5, 7}),
                Arguments.of(11, new int[]{1, 2, 3, 5, 7, 11}),
                Arguments.of(13, new int[]{1, 2, 3, 5, 7, 11, 13}),
                Arguments.of(16, new int[]{1, 2, 3, 5, 7, 11, 13})
        );
    }
}
