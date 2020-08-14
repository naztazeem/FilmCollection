package ui.tabs;

import exceptions.EmptyStringException;
import model.Film;
import ui.FilmCollectionGUI;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static ui.FilmCollectionGUI.filmCollection;


public class AddFilmTab extends Tab implements ActionListener {

    JTextField filmTitleInput = new JTextField();
    JTextField yearReleasedInput = new JTextField();
    JTextField directorNameInput = new JTextField();
    JTextField filmPlatformInput = new JTextField();
    JTextField filmRatingInput = new JTextField();

    public AddFilmTab() {

        setLayout(new GridLayout(6, 2));
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

        //adds film button action listener
        addFilmButton.addActionListener(e -> {
            addFilm();
            playSound("data/button-09.wav");
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
            film = new Film(filmTitle);
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }

        filmCollection.addFilm(film);
        FilmCollectionGUI.saveFilms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String sound = "data/button-09.wav";
        playSound(sound);

    }

    // EFFECTS: plays a sound when a user clicks the Add Film button in the Add Film tab
    private void playSound(String sound) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("No sound in this file");
        }

    }

}





