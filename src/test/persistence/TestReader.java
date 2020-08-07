package persistence;

import model.Film;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestReader {

    @Test
    void testParseFilm() {
        try {
            ArrayList<Film> stringOfFilm1 = Reader.readFilms(new File("data/testReader"));
            Film f1 = stringOfFilm1.get(0);
            assertEquals("Jules et Jim", f1.getFilmTitle());
            assertEquals(1962, f1.getYearReleased());
            assertEquals("Francois Truffaut",f1.getDirector());
            assertEquals("Criterion Collection", f1.getPlatform());
            assertEquals(7.8, f1.getRating());

            ArrayList<Film> stringOfFilm2 = Reader.readFilms(new File("data/testReader"));
            Film f2 = stringOfFilm2.get(1);
            assertEquals("Pulp Fiction",f2.getFilmTitle());
            assertEquals(1994,f2.getYearReleased());
            assertEquals("Quentin Tarantino", f2.getDirector());
            assertEquals("Netflix", f2.getPlatform());
            assertEquals(8.9, f2.getRating());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readFilms(new File("./path/does/not/exist/watched.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
