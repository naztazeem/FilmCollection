package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


// A collection of films that can be sorted by a given criteria
public class FilmCollection {
    public ArrayList<Film> filmCollection;

    // EFFECTS: constructs an empty list of film collection
    public FilmCollection() {
        filmCollection = new ArrayList<Film>();
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


    // EFFECTS: returns a list of films a user has watched
    public ArrayList<Film> watchedFilms() {
        ArrayList<Film> watchedFilms = new ArrayList<Film>();
        for (Film film: filmCollection) {
            if (film.haveWatched()) {
                watchedFilms.add(film);
            }
        }
        return watchedFilms;
    }

    // EFFECTS: returns a list of films a user hasn't watched
    public ArrayList<Film> toWatchFilms() {
        ArrayList<Film> toWatchFilms = new ArrayList<Film>();
        for (Film film: filmCollection) {
            if (!film.haveWatched()) {
                toWatchFilms.add(film);
            }
        }
        return toWatchFilms;
    }

    // EFFECTS: returns a list of all watched films as a string
    public String viewWatchedFilms(ArrayList<Film> filmCollection) {
        String watchedFilms = "";

        for (Film film : filmCollection) {
            String title = film.getFilmTitle();
            watchedFilms = watchedFilms + title + "\n";
        }
        return watchedFilms;
    }

    // EFFECTS: returns a list of all to-watch films as a string
    public String viewToWatchFilms(ArrayList<Film> filmCollection) {
        String toWatchFilms = "";

        for (Film film : filmCollection) {
            String title = film.getFilmTitle();
            toWatchFilms = toWatchFilms + title + "\n";
        }
        return toWatchFilms;
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

    



}

