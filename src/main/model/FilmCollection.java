package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;


// A collection of films that can be sorted by a given criteria
public class FilmCollection implements Saveable {
    public static ArrayList<Film> filmCollection;
    public Sort sort;

    // EFFECTS: constructs an empty list of film collection
    public FilmCollection() {
        filmCollection = new ArrayList<>();
        sort = new Sort(filmCollection);
    }


    // REQUIRES: a film to add
    // MODIFIES: film collection
    // EFFECTS: adds a film to film collection
    public void addFilm(Film film) {
        filmCollection.add(film);
    }

    // MODIFIES: film collection
    // EFFECTS: removes a film from film collection
    public void deleteFilm(Object film) {
        filmCollection.remove(film);
    }

    // EFFECTS: gets sort
    public Sort getSort() {
        return sort;
    }


    //EFFECTS: returns film at a position in a film collection
    public Film getFilmAtPosition(int filmNumber) {
        return filmCollection.get(filmNumber);
    }


    //EFFECTS: returns a list of all films as a string
    public String viewAllFilms(ArrayList<Film> films) {
        StringBuilder allFilms = new StringBuilder();

        for (Film film: films) {
            String filmTitle = film.getFilmTitle();
            allFilms.append(filmTitle).append("\n");
        }
        return allFilms.toString();
    }


    @Override
    public void save(PrintWriter printWriter) {
        for (Film film : filmCollection) {
            printWriter.print(film.getFilmTitle());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(film.getYearReleased());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(film.getDirector());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(film.getPlatform());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(film.getRating());
            printWriter.print("\n");
        }

    }
}


