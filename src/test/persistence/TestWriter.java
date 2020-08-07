package persistence;

import exceptions.EmptyStringException;
import model.Film;
import model.FilmCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestWriter {
    private static final String TEST_FILE ="data/testWriter.txt";
    private Writer testWriter;
    private FilmCollection fc1 = new FilmCollection();
    private Film f1;
    private Film f2;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));

        try {
            f1 = new Film("Ida");
            f2 = new Film("Amadeus");

        } catch (EmptyStringException e) {
            fail();
        }

        f1.setYearReleased(2013);
        f1.setDirector("Pawel Pawlikowski");
        f1.setPlatform("HBO");
        f1.setRating(7.4);
        fc1.addFilm(f1);

        f2.setYearReleased(1984);
        f2.setDirector("Milos Forman");
        f2.setPlatform("Netflix");
        f2.setRating(8.3);
        fc1.addFilm(f2);

        }


        @Test
    void testWriteFilms() {
        // save film to file
        testWriter.write(fc1);
        testWriter.close();

        // now read them back in and verify that the films have the expected values
        try {
            ArrayList<Film> films = Reader.readFilms(new File(TEST_FILE));
            Film f1 = films.get(0);
            assertEquals("Ida", f1.getFilmTitle());
            assertEquals(2013, f1.getYearReleased());
            assertEquals("Pawel Pawlikowski", f1.getDirector());
            assertEquals("HBO", f1.getPlatform());
            assertEquals(7.4, f1.getRating());

            Film f2 = films.get(1);
            assertEquals("Amadeus",f2.getFilmTitle());
            assertEquals(1984, f2.getYearReleased());
            assertEquals("Milos Forman", f2.getDirector());
            assertEquals(8.3, f2.getRating());

        } catch (IOException e) {
            fail("Exception should not have been thrown");

        }
    }

}
