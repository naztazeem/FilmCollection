package exceptions;

import model.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class testEmptyStringException {
    private Film f1;
    private Film f2;

    @Test
    void testNonEmptyString() {
        try {
            f1 = new Film("Ida");
        } catch (EmptyStringException e) {
            fail("EmptyStringException should not have been thrown");
        }
    }

    @Test
    void testEmptyString() {
        try {
            f2 = new Film("");
        } catch (Exception e) {
            // expected
            e.printStackTrace();
        }
    }
}
