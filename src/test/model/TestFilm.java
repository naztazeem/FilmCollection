package model;

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
    private Genre g1;
    private Genre g2;
    private Genre g3;
    private Genre g4;
    private Genre g5;

    @BeforeEach
    public void runBefore() {
        f1 = new Film("Jules et Jim");
        f2 = new Film("Vivre Sa Vie");
        f3 = new Film("Phantom Thread");
        f4 = new Film("Dogville");
        f5 = new Film("Ida");
        f6 = new Film("Pulp Fiction");
        g1 = new Genre("Drama");
        g2 = new Genre("Romance");
        g3 = new Genre("Crime");
        g4 = new Genre("Comedy");
        g5 = new Genre("Thriller");

    }

    @Test
    void testConstructor() {
        assertEquals("Jules et Jim", f1.getFilmTitle());
        assertEquals("Vivre Sa Vie", f2.getFilmTitle());
        assertEquals(0, f3.getYearReleased());
        assertEquals(-1,f4.getRating());
        assertFalse(f5.haveWatched());
        assertEquals(0, f6.genres.size());
    }

    @Test
    void testGetFilmName() {
        assertEquals("Jules et Jim", f1.getFilmTitle());
    }

    @Test
    void testGetYearReleased() {
       f1.setYearReleased(1962);
       assertEquals(1962, f1.getYearReleased());
       f3.setYearReleased(2017);
       assertEquals(2017, f3.getYearReleased());
    }

    @Test
    void testGetDirectorName() {
        f1.setDirector("Francois Truffaut");
        assertEquals("Francois Truffaut",f1.getDirector());
        f2.setDirector("Jean-Luc Godard");
        assertEquals("Jean-Luc Godard",f2.getDirector());
    }

    @Test
    void testGetFilmPlatform() {
        f2.setPlatform("Theatre");
        assertEquals("Theatre",f2.getPlatform());
        f3.setPlatform("Netflix");
        assertEquals("Netflix", f3.getPlatform());
    }

    @Test
    void testGetFilmRating() {
        f1.setRating(7.8);
        assertEquals(7.8,f1.getRating());
        f2.setRating(8.0);
        assertEquals(8.0,f2.getRating());
    }

    @Test
    void testHaveWatched() {
        f1.setHaveWatched(true);
        assertTrue(f1.getHaveWatched());

        f4.setHaveWatched(false);
        assertFalse(f4.getHaveWatched());
    }

    void testAddGenre() {
        f1.addGenre(g1);
        f2.addGenre(g2);
        assertEquals(2,f2.genres.size());
    }
}