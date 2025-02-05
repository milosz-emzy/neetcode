import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OneStringSwapTest {

    @Test
    void testAreAlmostEqualIsTrue() {
        String s1 = "bank";
        String s2 = "kanb";
        Assertions.assertThat(areAlmostEqual(s1, s2)).isTrue();
    }

    @Test
    void testAreAlmostEqualIsFalse() {
        String s1 = "attack";
        String s2 = "defend";

        String s3 = "abc";
        String s4 = "abd";

        Assertions.assertThat(areAlmostEqual(s1, s2)).isFalse();
        Assertions.assertThat(areAlmostEqual(s3, s4)).isFalse();
    }

    @Test
    void testAreAlmostEqualForEqualStrings() {
        String s1 = "kelb";
        String s2 = "kelb";
        Assertions.assertThat(areAlmostEqual(s1, s2)).isTrue();
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indexes.add(i);
            }
            if (indexes.size() > 2) return false;
        }


        if (indexes.size() == 1) return false; //abc abd

        return s1.charAt(indexes.get(0)) == s2.charAt(indexes.get(1))
                && s1.charAt(indexes.get(1)) == s2.charAt(indexes.get(0));
    }
}

