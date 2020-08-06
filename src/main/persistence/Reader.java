package persistence;

import exceptions.EmptyStringException;
import model.Film;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader  that can read account data from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of films parsed from file;
    // throws IOException if an exception is raised when opening / reading from file
    public static ArrayList<Film> readFilms(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as list of Strings with each String
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of films parsed from list of films
    //where each string contains data for one film
    private static ArrayList<Film> parseContent(List<String> fileContent) {
        ArrayList<Film> films = new ArrayList<>();

        for (String line: fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            films.add(parseFilm(lineComponents));
        }
        return films;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 5:
    // 0 represents the filmTitle
    // 1 represents the yearReleased
    // 2 represents the directorName
    // 3 represents the filmPlatform
    // 4 represents the filmRating
    // EFFECTS: returns a film constructed from components
    private static Film parseFilm(List<String> components) {
        String filmTitle = components.get(0);
        int yearReleased = Integer.parseInt(components.get(1));
        String directorName = components.get(2);
        String filmPlatform = components.get(3);
        double filmRating = Double.parseDouble(components.get(4));

        Film film = null;
        try {
            film = new Film(filmTitle);
        } catch (EmptyStringException e) {
            System.out.println("Film title is missing");
        }
        film.setYearReleased(yearReleased);
        film.setDirector(directorName);
        film.setPlatform(filmPlatform);
        film.setRating(filmRating);
        return film;
    }
}
