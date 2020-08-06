package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


// A collection of films that can be sorted by a given criteria
public class FilmCollection implements Saveable {
    public ArrayList<Film> filmCollection;

    // EFFECTS: constructs an empty list of film collection
    public FilmCollection() {
        filmCollection = new ArrayList<>();
    }

    // REQUIRES: a film to add
    // MODIFIES: film collection
    // EFFECTS: adds a film to film collection
    public void addFilm(Film film) {
        filmCollection.add(film);
    }

    // MODIFIES: film collection
    // EFFECTS: removes a film from film collection
    public void deleteFilm(Film film) {
        filmCollection.remove(film);
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


    // EFFECTS: returns sorted film collection alphabetically by title
    public ArrayList<Film> sortedFilmCollectionByTitle() {
        Collections.sort(filmCollection,Film.compareFilmTitle);
        return filmCollection;
    }

    // EFFECTS: sorts film collection alphabetically by director name
    public ArrayList<Film> sortedFilmCollectionByDirector() {
        Collections.sort(filmCollection,Film.compareDirector);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by platform used to watch a film
    public ArrayList<Film> sortedFilmCollectionByPlatform() {
        Collections.sort(filmCollection,Film.comparePlatform);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by year released with latest films on top
    public ArrayList<Film> sortedFilmCollectionByYearReleased() {
        Collections.sort(filmCollection,Film.compareYearReleased);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by rating from best to worst
    public ArrayList<Film> sortedFilmCollectionByRating() {
        Collections.sort(filmCollection, Film.compareRating);
        return filmCollection;
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
            printWriter.print(Reader.DELIMITER);
        }
    }
}

//StringBuilder stringBuilder = new StringBuilder("");
// String saveToString = stringBuilder.toString();
// add film.toString() to your stringbuilder
// String stringToSave = stringbuilder.getString()
// write stringToSave to your text file
// Create a Fiel

