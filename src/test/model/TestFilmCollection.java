package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestFilmCollection {
    private FilmCollection fc;

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
        fc = new FilmCollection();
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
    public void testConstructor() {
        assertEquals(0,fc.filmCollection.size());
    }

    @Test
    public void testAddFilm() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        fc.addFilm(f3);
        assertEquals(3,fc.filmCollection.size());
    }

    @Test
    public void testRemoveFilm() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        fc.addFilm(f3);
        assertEquals(3,fc.filmCollection.size());
        fc.deleteFilm(f2);
        assertEquals(2,fc.filmCollection.size());
    }

    @Test
    public void testSortedFilmCollectionByName() {
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByName = fc.sortedFilmCollectionByTitle();
        assertEquals(f4,sortedByName.get(0));
        assertEquals(f5,sortedByName.get(1));
        assertEquals(f1,sortedByName.get(2));
        assertEquals(f3,sortedByName.get(3));
        assertEquals(f6,sortedByName.get(4));
        assertEquals(f2,sortedByName.get(5));

    }

    @Test
    public void testSortedFilmCollectionByDirector() {
        f1.setDirector("Francois Truffaut");
        f2.setDirector("Jean-Luc Godard");
        f4.setDirector("Lars von Tier");
        f3.setDirector("Paul Thomas Anderson");
        f5.setDirector("Pawel Pawlikowski");
        f6.setDirector("Quentin Tarantino");
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByDirector = fc.sortedFilmCollectionByDirector();
        assertEquals(f1,sortedByDirector.get(0));
        assertEquals(f2,sortedByDirector.get(1));
        assertEquals(f4,sortedByDirector.get(2));
        assertEquals(f3,sortedByDirector.get(3));
        assertEquals(f5,sortedByDirector.get(4));
        assertEquals(f6,sortedByDirector.get(5));

    }

    @Test
    public void testSortedFilmCollectionByPlatform() {
        f1.setPlatform("Criterion Collection");
        f2.setPlatform("Theatre");
        f3.setPlatform("Netflix");
        f4.setPlatform("YouTube");
        f5.setPlatform("Criterion Collection");
        f6.setPlatform("HBO");

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByPlaform = fc.sortedFilmCollectionByPlatform();
        assertEquals(f1,sortedByPlaform.get(0));
        assertEquals(f5,sortedByPlaform.get(1));
        assertEquals(f6,sortedByPlaform.get(2));
        assertEquals(f3,sortedByPlaform.get(3));
        assertEquals(f2,sortedByPlaform.get(4));
        assertEquals(f4,sortedByPlaform.get(5));
    }

    @Test
    public void testSortedFilmCollectionByYearReleased() {
        f1.setYearReleased(1962);
        f2.setYearReleased(1962);
        f3.setYearReleased(2017);
        f4.setYearReleased(2003);
        f5.setYearReleased(2013);
        f6.setYearReleased(1994);

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByYear = fc.sortedFilmCollectionByYearReleased();
        assertEquals(f3,sortedByYear.get(0));
        assertEquals(f5,sortedByYear.get(1));
        assertEquals(f4,sortedByYear.get(2));
        assertEquals(f6,sortedByYear.get(3));
        assertEquals(f1,sortedByYear.get(4));
        assertEquals(f2,sortedByYear.get(5));
    }

    @Test
    public void testSortedFilmCollectionByRating() {
        f1.setRating(7.8);
        f2.setRating(8.0);
        f3.setRating(7.5);
        f4.setRating(8.0);
        f5.setRating(7.4);
        f6.setRating(8.9);

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByRating = fc.sortedFilmCollectionByRating();
        assertEquals(f6,sortedByRating.get(0));
        assertEquals(f2,sortedByRating.get(1));
        assertEquals(f4,sortedByRating.get(2));
        assertEquals(f1,sortedByRating.get(3));
        assertEquals(f3,sortedByRating.get(4));
        assertEquals(f5,sortedByRating.get(5));
    }

    @Test
    public void testWatchedFilms() {
        f1.setHaveWatched(true);
        f2.setHaveWatched(true);
        f3.setHaveWatched(false);
        f4.setHaveWatched(true);
        f5.setHaveWatched(false);
        f6.setHaveWatched(true);

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> watchedFilms = fc.watchedFilms();
        assertTrue(f1.haveWatched());
        assertTrue(f2.haveWatched());
        assertFalse(f3.haveWatched());
        assertTrue(f4.haveWatched());
        assertFalse(f5.haveWatched());
        assertTrue(f6.haveWatched());
        assertEquals(4,watchedFilms.size());

    }

    @Test
    public void testToWatchFilms() {
        f1.setHaveWatched(true);
        f2.setHaveWatched(true);
        f3.setHaveWatched(false);
        f4.setHaveWatched(true);
        f5.setHaveWatched(false);
        f6.setHaveWatched(true);

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> toWatch = fc.toWatchFilms();
        assertFalse(!f1.haveWatched());
        assertFalse(!f2.haveWatched());
        assertTrue(!f3.haveWatched());
        assertFalse(!f4.haveWatched());
        assertTrue(!f5.haveWatched());
        assertFalse(!f6.haveWatched());
        assertEquals(2,toWatch.size());

    }

    @Test
    void testViewWatchedFilms() {
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);


        String watchedFilms = fc.viewWatchedFilms(fc.filmCollection);
        assertEquals("" + "Dogville"+"\n" + "Ida" +"\n", watchedFilms);

    }

    @Test
    void testViewToWatchFilms() {
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);

        String toWatchFilms = fc.viewToWatchFilms(fc.filmCollection);
        assertEquals("" + "Jules et Jim" +"\n"+"Vivre Sa Vie",toWatchFilms);
    }

    
}
