package model;

public class Genre {
    public String filmGenre;

    // REQUIRES: non-empty String for film genre
    // EFFECTS: constructs a film genre
    public Genre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    // EFFECTS: returns a film genre
    public String getGenre() {
        return filmGenre;
    }

}
