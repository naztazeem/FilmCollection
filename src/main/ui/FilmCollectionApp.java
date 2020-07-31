package ui;

import model.Film;
import model.FilmCollection;

import java.util.Scanner;

// Film collection application
public class FilmCollectionApp {
    private FilmCollection watched;
    private FilmCollection towatch;
    private Scanner input;

    // EFFECTS: runs the film collection application
    public FilmCollectionApp() {
        runFilmCollection();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runFilmCollection() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        init();
        System.out.println("Welcome to your Film Collection");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);

            }
        }

        System.out.println("\nGoodbye!");
    }

    private void processCommand(String command) {
        if (command.equals("w")) {
            watchedCollection();
        } else if (command.equals("tw")) {
            toWatchCollection();
        } else {
            System.out.println("Selection is not valid.");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        watched = new FilmCollection();
        towatch = new FilmCollection();
    }

    // EFFECTS: displays menu of options for user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tw -> collection of watched films");
        System.out.println("\ttw -> collection of to-watch films");
        System.out.println("\tq -> quit");
    }

    // REQUIRES: watched films option is selected by user
    // EFFECTS: displays watched films menu options to user
    private void watchedCollection() {

        FilmCollection selected = watched;
        String selectedOption = "";  // forces entry into loop

        while (!(selectedOption.equals("v") || selectedOption.equals("a") || selectedOption.equals("r"))) {
            System.out.println("v -> view watched films");
            System.out.println("a -> add a film to watched films");
            System.out.println("d -> delete a film from watch films");

            selectedOption = input.next();
            selectedOption = selectedOption.toLowerCase();
        }

        if (selectedOption.equals("v")) {
            viewWatchedFilms();
        } else if (selectedOption.equals("a")) {
            addWatchedFilm();
        } else {
            deleteWatchedFilm();

        }
    }

    // REQUIRES: user must choose to view watched films sorted by title, year, director, platform, or rating
    // EFFECTS: displays the film collection sorted by user preference
    private void viewWatchedFilms() {
        String selectedOption = "";   // forces entry into loop
        while (!(selectedOption.equals("t") || (selectedOption.equals("y") || selectedOption.equals("d")
                || (selectedOption.equals("p") || (selectedOption.equals("r")))))) {
            System.out.println("t -> view sorted by film title");
            System.out.println("y -> view sorted by year released");
            System.out.println("d -> view sorted by director");
            System.out.println("p -> view sorted by platform");
            System.out.println("r -> view sorted by rating");

            selectedOption = input.next();
            selectedOption = selectedOption.toLowerCase();

        }

        if (selectedOption.equals("t")) {
            System.out.println(watched.viewWatchedFilms(watched.sortedFilmCollectionByTitle()));
        } else if (selectedOption.equals("y")) {
            System.out.println(watched.viewWatchedFilms(watched.filmCollection));
        } else if (selectedOption.equals("d")) {
            System.out.println(watched.viewWatchedFilms(watched.sortedFilmCollectionByDirector()));
        } else if (selectedOption.equals("p")) {
            System.out.println(watched.viewWatchedFilms(watched.sortedFilmCollectionByPlatform()));
        } else {
            System.out.println(watched.viewWatchedFilms(watched.sortedFilmCollectionByRating()));
        }

    }

    // REQUIRES: requires user to enter a film title
    // MODIFIES: watched
    // EFFECTS: adds a film to watched film collection
    private void addWatchedFilm() {
        System.out.println("Enter the film title");
        String title = input.next();
        Film newFilm = new Film(title);
        watched.addFilm(newFilm);

        System.out.println("add film release year");
        int yearReleased = input.nextInt();
        newFilm.setYearReleased(yearReleased);

        System.out.println("add film director's name");
        String directorName = input.next();
        newFilm.setDirector(directorName);

        System.out.println("add platform used to watch this film");
        String filmPlatform = input.next();
        newFilm.setPlatform(filmPlatform);

        System.out.println("add film rating from 1.0 to 10.0");
        double filmRating = input.nextDouble();
        newFilm.setRating(filmRating);

        System.out.print(newFilm.getFilmTitle() + " has been added to your watched");
        System.out.println("film collection.");

    }

    // REQUIRES: film title must already be in the film collection
    // MODIFIES: watched
    // EFFECTS: deletes a film from the watched films collection
    private void deleteWatchedFilm() {
        System.out.println("Enter the film title you want to delete");
        String title = input.next();
        Film deleteFilm = null;

        for (Film film : watched.watchedFilms()) {
            if (film.getFilmTitle().equals(title)) {
                deleteFilm = film;
                System.out.println(deleteFilm.getFilmTitle() + "has been deleted from your watched film collection");

            }
        }
        watched.filmCollection.remove(deleteFilm);
    }

    // EFFECTS: displays menu of options for user
    private void toWatchCollection() {
        FilmCollection selected = towatch;
        String selectedOption = "";

        while (!(selectedOption.equals("v") || selectedOption.equals("a") || selectedOption.equals("r"))) {
            System.out.println("v -> view watched films");
            System.out.println("a -> add a film to watched films");
            System.out.println("d -> delete a film from watch films");

            selectedOption = input.next();
            selectedOption = selectedOption.toLowerCase();
        }

        if (selectedOption.equals("v")) {
            viewToWatchFilms();
        } else if (selectedOption.equals("a")) {
            addToWatchFilm();
        } else {
            deleteToWatchFilm();
        }
    }

    // EFFECTS:
    private void viewToWatchFilms() {
        String selectedOption = "";
        while (!(selectedOption.equals("t") || (selectedOption.equals("y") || selectedOption.equals("d")
                || (selectedOption.equals("p"))))) {
            System.out.println("t -> view sorted by film title");
            System.out.println("y -> view sorted by year released");
            System.out.println("d -> view sorted by director");
            System.out.println("p -> view sorted by platform");

            selectedOption = input.next();
            selectedOption = selectedOption.toLowerCase();
        }

        if (selectedOption.equals("t")) {
            System.out.println(towatch.viewToWatchFilms(towatch.sortedFilmCollectionByTitle()));
        } else if (selectedOption.equals("y")) {
            System.out.println(towatch.viewToWatchFilms(towatch.sortedFilmCollectionByDirector()));
        } else if (selectedOption.equals("d")) {
            System.out.println(towatch.viewToWatchFilms(watched.sortedFilmCollectionByDirector()));
        } else {
            System.out.println(towatch.viewToWatchFilms(towatch.sortedFilmCollectionByPlatform()));
        }
    }

    // MODIFIES: to watch
    // EFFECTS: adds a film to the to watch film collection
    private void addToWatchFilm() {
        System.out.println("Enter the film title");
        String title = input.next();
        Film newFilm = new Film(title);
        towatch.addFilm(newFilm);

        System.out.println("add film release year");
        int yearReleased = input.nextInt();
        newFilm.setYearReleased(yearReleased);

        System.out.println("add film director's name");
        String directorName = input.next();
        newFilm.setDirector(directorName);

        System.out.println("add platform used to watch this film");
        String filmPlatform = input.next();
        newFilm.setPlatform(filmPlatform);

        System.out.println("add film rating from 1.0 to 10.0");
        double filmRating = input.nextDouble();
        newFilm.setRating(filmRating);

        System.out.print(newFilm.getFilmTitle() + " has been added to your to watch");
        System.out.println("film collection.");
    }

    // MODIFIES: to watch
    // EFFECTS: deletes a film from the to watch films collection
    private void deleteToWatchFilm() {
        System.out.println("Enter the film title you want to delete");
        String title = input.next();
        Film deleteFilm = null;

        for (Film film : towatch.toWatchFilms()) {
            if (film.getFilmTitle().equals(title)) {
                deleteFilm = film;
                System.out.println(deleteFilm.getFilmTitle() + "has been deleted from your to watch film collection");

            }
        }
        towatch.filmCollection.remove(deleteFilm);
    }

}
