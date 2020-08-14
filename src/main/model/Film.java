package model;

import exceptions.EmptyStringException;

import java.util.Comparator;

// a film with a name, year released, director, platform, and rating
public class Film {

    private String filmTitle;
    private int yearReleased;
    private String directorName;
    private String filmPlatform;
    private double filmRating;


    // EFFECTS: Constructs a new Film with a film title
    public Film(String filmTitle) throws EmptyStringException {
        if (filmTitle.isEmpty()) {
            throw new EmptyStringException();
        }

        this.filmTitle = filmTitle;
        yearReleased = 0;
        directorName = "";
        filmPlatform = "";
        filmRating = 0.0;
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


    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                filmTitle,yearReleased,directorName,filmPlatform,filmRating);
    }


    // EFFECTS: compares titles of two films by first alphabet
    public static Comparator<Film> compareFilmTitle = new Comparator<Film>() {
        @Override
        public int compare(Film film1, Film film2) {

            return (film1.getFilmTitle().compareTo(film2.getFilmTitle()));
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
            return film1.getDirector().compareTo(film2.getDirector());
        }
    };

    // EFFECTS: compares platform used to watch a film
    public static Comparator<Film> comparePlatform = new Comparator<Film>() {
        @Override
        public int compare(Film platform1, Film platform2) {
            return platform1.getPlatform().compareTo(platform2.getPlatform());
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




