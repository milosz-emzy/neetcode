import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StringDecoderEncoderTest {

    @Test
    void test() {
        List<String> strings = List.of("neet", "code", "love", "you");
        String encodedString = encode(strings);
        List<String> decoded = decode(encodedString);

        List<String> strings1 = List.of("we", "say", ":", "yes");
        String encoded1 = encode(strings1);
        List<String> decoded1 = decode(encoded1);

        for (int i = 0; i < strings1.size(); i++) {
            Assertions.assertEquals(strings.get(i), decoded.get(i));
            Assertions.assertEquals(strings1.get(i), decoded1.get(i));
        }
    }

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s.length())
                    .append("#")
                    .append(s);
        }
        return stringBuilder.toString();
    }

    // 2#we3#say1#:3#yes
    // 0123456789
    public List<String> decode(String str) {

        int len;
        List<String> words = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                len = Integer.parseInt(stringBuilder.toString());
                stringBuilder = new StringBuilder();

                words.add(str.substring(i + 1, i + len + 1));
                i = i + len;
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return words;
    }
}