package model;


import java.util.ArrayList;
import java.util.Collections;

import static model.FilmCollection.filmCollection;

public class Sort {

    public Sort(ArrayList<Film> s) {

    }
    
    // EFFECTS: returns sorted film collection alphabetically by title
    public ArrayList<Film> sortByTitle(ArrayList<Film> filmCollection) {
        Collections.sort(FilmCollection.filmCollection,Film.compareFilmTitle);
        return FilmCollection.filmCollection;
    }

    // EFFECTS: sorts film collection alphabetically by director name
    public ArrayList<Film> sortByDirector() {
        Collections.sort(filmCollection,Film.compareDirector);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by platform used to watch a film
    public ArrayList<Film> sortByPlatform() {
        Collections.sort(filmCollection,Film.comparePlatform);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by year released with latest films on top
    public ArrayList<Film> sortByYearReleased() {
        Collections.sort(filmCollection,Film.compareYearReleased);
        return filmCollection;
    }

    // EFFECTS: sorts film collection by rating from best to worst
    public ArrayList<Film> sortByRating() {
        Collections.sort(filmCollection, Film.compareRating);
        return filmCollection;
    }

}
