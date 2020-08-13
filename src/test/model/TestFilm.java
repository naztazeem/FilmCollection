package model;

import exceptions.EmptyStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFilm {
    private Film f1;
    private Film f2;
    private Film f3;
    private Film f4;
    private Film f5;
    private Film f6;


    @BeforeEach
    public void runBefore() {
        try {
            f1 = new Film("Jules et Jim",1962,"Francois Truffaut",
                    "Criterion Collection",7.8);

            f2 = new Film("Vivre Sa Vie", 1962, "Jean-Luc Godard",
                    "HBO", 8.0);

            f3 = new Film("Phantom Thread",2017,"Paul Thomas Anderson",
                    "Netflix", 7.5);

            f4 = new Film("Dogville",2003,"Lars von Trier",
                    "YouTube", 8.0);

            f5 = new Film("Ida", 2013, "Pawel Pawlikowski",
                    "Theatre", 7.4);

        } catch (EmptyStringException e) {
            fail();
        }

    }

    @Test
    void testConstructor() {
        assertEquals("Jules et Jim", f1.getFilmTitle());
        assertEquals("Vivre Sa Vie", f2.getFilmTitle());
        assertEquals(2017, f3.getYearReleased());
        assertEquals(8.0,f4.getRating());
    }

    @Test
    void testToString() {
        assertEquals("Jules et Jim,1962,Francois Truffaut,Criterion Collection,7.8", f1.toString());

    }

    @Test
    void testGetFilmName() {
        assertEquals("Jules et Jim", f1.getFilmTitle());
    }

    @Test
    void testGetYearReleased() {
       assertEquals(1962, f1.getYearReleased());
       assertEquals(2017, f3.getYearReleased());
    }

    @Test
    void testGetDirectorName() {
        assertEquals("Francois Truffaut",f1.getDirector());
        assertEquals("Jean-Luc Godard",f2.getDirector());
    }

    @Test
    void testGetFilmPlatform() {
        assertEquals("HBO",f2.getPlatform());
        assertEquals("Netflix", f3.getPlatform());
    }

    @Test
    void testGetFilmRating() {
        assertEquals(7.8,f1.getRating());
        assertEquals(8.0,f2.getRating());
    }

    @Test
    void testNonEmptyStringException() {
        try {
            f6 = new Film("Pulp Fiction", 1994, "Quentin Tarantino",
                    "Netflix", 8.9);
        } catch (EmptyStringException e) {
            fail("Empty String Exception should not have been thrown");
        }
    }

    @Test
    void testEmptyStringException() {
        try {
            f6 = new Film("", 1994, "Quentin Tarantino",
                    "Netflix", 8.9);
            fail();
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }
    }
}