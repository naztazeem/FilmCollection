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

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));

        try {
            f1 = new Film("Ida");
        } catch (EmptyStringException e) {
            fail();
        }
        f1.setYearReleased(2013);
        f1.setDirector("Pawel Pawlikowski");
        f1.setPlatform("Theatre");
        f1.setRating(7.4);
        fc1.addFilm(f1);
    }


    @Test
    void testWriteFilms() {
        // save film to file
        testWriter.write(fc1);
        testWriter.close();

        // now read them back in and verify that the films have the expected values
        try {
            ArrayList<Film> films = Reader.readFilms(new File(TEST_FILE));
            Film fx = films.get(0);
            assertEquals("Ida", f1.getFilmTitle());
            assertEquals(2013, f1.getYearReleased());
            assertEquals("Pawel Pawlikowski", f1.getDirector());
            assertEquals("Theatre", f1.getPlatform());
            assertEquals(7.4, f1.getRating());
            assertEquals(1, films.size());

        } catch (IOException e) {
            e.printStackTrace();

        } catch (EmptyStringException e) {
            e.printStackTrace();
        }
    }
}
