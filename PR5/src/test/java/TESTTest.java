import org.example.TEST;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TESTTest {

    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', true",
            "'TEST', true",
            "'abcTES', false",
            "'', false",
            "'TETEST', true",
            "'TES', false",
            "'TESTTEST', true",
            "'abcTEabcST', false",
            "'aTbEcSdT', false",
            "'TETESTST', true",
            "'TEST', false",
            "'TETESTST', false",
            "'TEabcST', true"
    })
    public void testContainsTEST(String input, boolean expected) {
        TEST test = new TEST();
        assertEquals(expected, test.containsTEST(input));
    }
}
