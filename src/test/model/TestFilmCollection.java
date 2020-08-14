package model;

import exceptions.EmptyStringException;
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

    @BeforeEach
    public void runBefore() {
        fc = new FilmCollection();
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

        f6 = new Film("Pulp Fiction", 1994, "Quentin Tarantino",
                "Netflix", 8.9);

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
    public void testDeleteFilm() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        fc.addFilm(f3);
        assertEquals(3,fc.filmCollection.size());
        fc.deleteFilm(f2);
        assertEquals(2,fc.filmCollection.size());
    }

    @Test
    public void testGetFilmAtPosition() {
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        assertEquals(f1,fc.getFilmAtPosition(0));
        assertEquals(f2,fc.getFilmAtPosition(1));

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
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByPlatform = fc.sortedFilmCollectionByPlatform();
        assertEquals(f1,sortedByPlatform.get(0));
        assertEquals(f2,sortedByPlatform.get(1));
        assertEquals(f3,sortedByPlatform.get(2));
        assertEquals(f6,sortedByPlatform.get(3));
        assertEquals(f5,sortedByPlatform.get(4));
        assertEquals(f4,sortedByPlatform.get(5));
    }

    @Test
    public void testSortedFilmCollectionByYearReleased() {
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
    void testViewALLFilms() {
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);

        String allFilms = fc.viewAllFilms(fc.filmCollection);
        assertEquals("" + "Dogville"+"\n" + "Ida" +"\n", allFilms);
    }
}
