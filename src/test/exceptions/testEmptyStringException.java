package exceptions;

import model.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class testEmptyStringException {
    private Film f1;

    @Test
    void testNonEmptyString() {
        try {
            f1 = new Film("Jules et Jim",1962,"Francois Truffaut",
                    "Criterion Collection",7.8);
        } catch (EmptyStringException e) {
            fail("EmptyStringException should not have been thrown");
        }
    }

}
