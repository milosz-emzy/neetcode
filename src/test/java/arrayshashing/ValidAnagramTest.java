package arrayshashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ValidAnagramTest {
    @Test
    void testIsAnagram() {
        String s = "carrace";
        String t = "racecar";

        Assertions.assertTrue(isAnagram(s, t));
        assertThat(isAnagram(s, t)).isTrue();

    }

    public boolean isAnagram(String s, String t) {
        String sortedS = sortStringAlphabetically(s);
        String sortedT = sortStringAlphabetically(t);

        return sortedS.equals(sortedT);
    }

    private String sortStringAlphabetically(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }
}
