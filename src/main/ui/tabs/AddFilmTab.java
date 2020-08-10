package ui.tabs;

import exceptions.EmptyStringException;
import model.Film;
import ui.FilmCollectionUI;

import javax.swing.*;
import java.awt.*;

import static ui.FilmCollectionUI.filmCollection;


public class AddFilmTab extends Tab {

    JTextField filmTitleInput = new JTextField();
    JTextField yearReleasedInput = new JTextField();
    JTextField directorNameInput = new JTextField();
    JTextField filmPlatformInput = new JTextField();
    JTextField filmRatingInput = new JTextField();

    public AddFilmTab() {

        setLayout(new GridLayout(6,2));
        add(new JLabel("Film Title"));
        add(filmTitleInput);
        add(new JLabel("Year Released"));
        add(yearReleasedInput);
        add(new JLabel("Director"));
        add(directorNameInput);
        add(new JLabel("Platform"));
        add(filmPlatformInput);
        add(new JLabel("Rating"));
        add(filmRatingInput);
        add(new JLabel());

        this.add(addFilmButton(), BorderLayout.SOUTH);

        this.setVisible(true);
    }


    // creates a new panel with an add button
    private JPanel addFilmButton() {
        JPanel add = new JPanel();
        add.setLayout(new BoxLayout(add, BoxLayout.Y_AXIS));

        // creates buttons
        JButton addFilmButton = new JButton("Add Film");

        //add film button action listener
        addFilmButton.addActionListener(e -> {
            addFilm();
        });


        add.add(addFilmButton);
        return add;
    }

    //EFFECTS: creates a film and saves the film to persistence file
    private void addFilm() {
        // gets user input
        String filmTitle = filmTitleInput.getText();
        int yearReleased = Integer.parseInt(yearReleasedInput.getText());
        String directorName = directorNameInput.getText();
        String filmPlatform = filmPlatformInput.getText();
        double filmRating = Double.parseDouble(filmRatingInput.getText());

        // Create a film object
        Film film = null;
        try {
            film = new Film(filmTitle, yearReleased, directorName, filmPlatform, filmRating);
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }

        filmCollection.addFilm(film);
        FilmCollectionUI.saveFilms();
    }
}
