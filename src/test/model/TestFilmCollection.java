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
        try {
            fc = new FilmCollection();
            f1 = new Film("Jules et Jim");
            f2 = new Film("Vivre Sa Vie");
            f3 = new Film("Phantom Thread");
            f4 = new Film("Dogville");
            f5 = new Film("Ida");
            f6 = new Film("Pulp Fiction");

        } catch (EmptyStringException e) {
            fail();
        }

        f1.setYearReleased(1962);
        f1.setDirector("Francois Truffaut");
        f1.setPlatform("Criterion Collection");
        f1.setRating(7.8);

        f2.setYearReleased(1962);
        f2.setDirector("Jean-Luc Godard");
        f2.setPlatform("HBO");
        f2.setRating(8.0);

        f3.setYearReleased(2017);
        f3.setDirector("Paul Thomas Anderson");
        f3.setPlatform("Netflix");
        f3.setRating(7.5);

        f4.setYearReleased(2003);
        f4.setDirector("Lars von Trier");
        f4.setPlatform("YouTube");
        f4.setRating(8.0);

        f5.setYearReleased(2013);
        f5.setDirector("Pawel Pawlikowski");
        f5.setPlatform("Theatre");
        f5.setRating(7.4);

        f6.setYearReleased(1994);
        f6.setDirector("Quentin Tarantino");
        f6.setPlatform("Netflix");
        f6.setRating(8.9);

    }

    @Test
    public void testConstructor() {
        assertEquals(0, FilmCollection.filmCollection.size());
    }

    @Test
    public void testAddFilm() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        fc.addFilm(f3);
        assertEquals(3, FilmCollection.filmCollection.size());
    }

    @Test
    public void testDeleteFilm() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        fc.addFilm(f3);
        assertEquals(3, FilmCollection.filmCollection.size());
        fc.deleteFilm(f2);
        assertEquals(2, FilmCollection.filmCollection.size());
    }

    @Test
    public void testGetFilmAtPosition() {
        fc.addFilm(f1);
        fc.addFilm(f2);
        assertEquals(f1,fc.getFilmAtPosition(0));
        assertEquals(f2,fc.getFilmAtPosition(1));

    }


    @Test
    void testViewALLFilms() {
        fc.addFilm(f4);
        fc.addFilm(f5);

        String allFilms = fc.viewAllFilms(FilmCollection.filmCollection);
        assertEquals("" + "Dogville"+"\n" + "Ida" +"\n", allFilms);
    }

    @Test
    public void testGetSortByTitle() {
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByTitle = fc.getSort().sortByTitle(fc.filmCollection);
        assertEquals(f4,sortedByTitle.get(0));
        assertEquals(f5,sortedByTitle.get(1));
        assertEquals(f1,sortedByTitle.get(2));
        assertEquals(f3,sortedByTitle.get(3));
        assertEquals(f6,sortedByTitle.get(4));
        assertEquals(f2,sortedByTitle.get(5));

    }

    @Test
    public void testGetSortByDirector() {
        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByDirector = fc.getSort().sortByDirector();
        assertEquals(f1,sortedByDirector.get(0));
        assertEquals(f2,sortedByDirector.get(1));
        assertEquals(f4,sortedByDirector.get(2));
        assertEquals(f3,sortedByDirector.get(3));
        assertEquals(f5,sortedByDirector.get(4));
        assertEquals(f6,sortedByDirector.get(5));

    }

    @Test
    public void testGetSortByPlatform() {

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByPlatform = fc.getSort().sortByPlatform();
        assertEquals(f1,sortedByPlatform.get(0));
        assertEquals(f2,sortedByPlatform.get(1));
        assertEquals(f3,sortedByPlatform.get(2));
        assertEquals(f6,sortedByPlatform.get(3));
        assertEquals(f5,sortedByPlatform.get(4));
        assertEquals(f4,sortedByPlatform.get(5));
    }

    @Test
    public void testGetSortByYearReleased() {

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByYear = fc.getSort().sortByYearReleased();
        assertEquals(f3,sortedByYear.get(0));
        assertEquals(f5,sortedByYear.get(1));
        assertEquals(f4,sortedByYear.get(2));
        assertEquals(f6,sortedByYear.get(3));
        assertEquals(f1,sortedByYear.get(4));
        assertEquals(f2,sortedByYear.get(5));
    }

    @Test
    public void testGetSortByRating() {

        fc.filmCollection.add(f1);
        fc.filmCollection.add(f2);
        fc.filmCollection.add(f3);
        fc.filmCollection.add(f4);
        fc.filmCollection.add(f5);
        fc.filmCollection.add(f6);

        ArrayList<Film> sortedByRating = fc.getSort().sortByRating();
        assertEquals(f6,sortedByRating.get(0));
        assertEquals(f2,sortedByRating.get(1));
        assertEquals(f4,sortedByRating.get(2));
        assertEquals(f1,sortedByRating.get(3));
        assertEquals(f3,sortedByRating.get(4));
        assertEquals(f5,sortedByRating.get(5));
    }



}
