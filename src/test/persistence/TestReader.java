package persistence;

import exceptions.EmptyStringException;
import model.Film;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestReader {

    @Test
    void testNonEmptyStringParseFilm() {
        try {
            ArrayList<Film> films1 = Reader.readFilms(new File("data/testReader"));
            Film f1 = films1.get(0);
            assertEquals("Jules et Jim", f1.getFilmTitle());
            assertEquals(1962, f1.getYearReleased());
            assertEquals("Francois Truffaut",f1.getDirector());
            assertEquals("Criterion Collection", f1.getPlatform());
            assertEquals(7.8, f1.getRating());

            ArrayList<Film> films2 = Reader.readFilms(new File("data/testReader"));
            Film f2 = films2.get(1);
            assertEquals("Pulp Fiction",f2.getFilmTitle());
            assertEquals(1994,f2.getYearReleased());
            assertEquals("Quentin Tarantino", f2.getDirector());
            assertEquals("Netflix", f2.getPlatform());
            assertEquals(8.9, f2.getRating());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail("IOException and EmptyStringException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readFilms(new File("./path/does/not/exist/filmcollection.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            // expected
        }
    }
}
