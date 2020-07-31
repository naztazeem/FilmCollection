package model;

import java.util.ArrayList;
import java.util.Comparator;

// a film with a name, year released, director, genre, rating, watched status, and a platform used to watch
public class Film {

    private String filmTitle;
    private int yearReleased;
    private String directorName;
    private String filmPlatform;
    private double filmRating;
    private boolean haveWatched;
    public ArrayList<Genre> genres;


    // REQUIRES: a non-empty String for film title
    // EFFECTS: Constructs a new Film with a film title
    public Film(String filmTitle)  {
        this.filmTitle = filmTitle;
        yearReleased = 0;
        directorName = "";
        filmPlatform = "";
        filmRating = -1;
        haveWatched = false;
        genres = new ArrayList<Genre>();
    }

    // MODIFIES: this
    // EFFECTS: sets year in which the film was released
    public void setYearReleased(int year) {
        this.yearReleased = year;
    }

    // MODIFIES: this
    // EFFECTS: sets director for a film
    public void setDirector(String director) {
        this.directorName = director;
    }

    // MODIFIES: this
    // EFFECTS: sets platform used to watch a film
    public void setPlatform(String platform) {
        this.filmPlatform = platform;
    }

    // MODIFIES: this
    // EFFECTS: sets rating for this film
    public void setRating(double rating) {
        this.filmRating = rating;
    }

    // MODIFIES: this
    // EFFECTS: sets whether or not a user has watched a film
    public void setHaveWatched(boolean watched) {
        this.haveWatched = watched;
    }


    // EFFECTS: returns the title of this film
    public String getFilmTitle() {
        return filmTitle;
    }

    // EFFECTS: returns the year in which this film was released
    public int getYearReleased() {
        return yearReleased;
    }

    // EFFECTS: returns the name of director of this film
    public String getDirector() {
        return directorName;
    }

    // EFFECTS: returns platform used to watch this film
    public String getPlatform() {
        return filmPlatform;
    }

    // EFFECTS: returns rating from 0.0 to 10.0
    public double getRating() {
        return filmRating;
    }


    // EFFECTS: returns true if a user has watched this film, otherwise returns false
    public boolean haveWatched() {
        if (haveWatched == true) {
            return true;
        } else {
            return false;
        }

    }

    // EFFECTS: getter for haveWatched
    public boolean getHaveWatched() {
        return haveWatched;
    }

    // REQUIRES: a non-empty String for genre
    // MODIFIES: this
    // EFFECTS: adds a genre for a film
    public void addGenre(Genre genre) {
        genres.add(genre);
    }




    // EFFECTS: compares titles of two films by first alphabet
    public static Comparator<Film> compareFilmTitle = new Comparator<Film>() {
        @Override
        public int compare(Film film1, Film film2) {
            return (int) (film1.getFilmTitle().compareTo(film2.getFilmTitle()));
        }
    };

    // EFFECTS: compares year released of two films
    public static Comparator<Film> compareYearReleased = new Comparator<Film>() {
        @Override
        public int compare(Film film1, Film film2) {
            if (film1.getYearReleased() < film2.getYearReleased()) {
                return 1;
            } else if (film1.getYearReleased() == film2.getYearReleased()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    // EFFECTS: compares names of two film directors by first alphabet
    public static Comparator<Film> compareDirector = new Comparator<Film>() {
        @Override
        public int compare(Film film1, Film film2) {
            return (int) (film1.getDirector().compareTo(film2.getDirector()));
        }
    };

    // EFFECTS: compares platform used to watch a film
    public static Comparator<Film> comparePlatform = new Comparator<Film>() {
        @Override
        public int compare(Film platform1, Film platform2) {
            return (int) (platform1.getPlatform().compareTo(platform2.getPlatform()));
        }
    };

    // EFFECTS: compares ratings of two films
    public static Comparator<Film> compareRating = new Comparator<Film>() {
        @Override
        public int compare(Film film1, Film film2) {
            if (film1.getRating() < film2.getRating()) {
                return 1;
            } else if (film1.getRating() == film2.getRating()) {
                return 0;
            } else {
                return -1;
            }
        }
    };
}




