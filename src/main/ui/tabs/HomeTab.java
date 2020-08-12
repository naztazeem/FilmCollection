package ui.tabs;

import ui.FilmCollectionGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static ui.FilmCollectionGUI.ADDFILM_TAB_INDEX;


public class HomeTab extends Tab {
    private static final String INIT_GREETING = "Welcome to your film Collection";
    private JLabel greeting;

    public HomeTab() {
        setLayout(new GridLayout(3,1));
        placeGreeting();
        placeAddFilmButton();
        placeFilmsButton();

    }

    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    // EFFECTS: constructs an Add Film button in the home tab that switches to the Add Film tab
    // on the console
    private void placeAddFilmButton() {
        JPanel addFilmBlock = new JPanel();
        JButton addFilmB = new JButton("Add Film");

        addFilmBlock.add(formatButtonRow(addFilmB));

        addFilmB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add Film")) {
                    FilmCollectionGUI.getTabbedPane().setSelectedIndex(ADDFILM_TAB_INDEX);
                }
            }
        });

        this.add(addFilmBlock);
    }


    // EFFECTS: constructs an Add Film button in the home tab that switches to the Add Film tab
    // on the console
    private void placeFilmsButton() {
        JPanel filmsBlock = new JPanel();
        JButton filmsButton = new JButton("Film Collection");

        filmsBlock.add(formatButtonRow(filmsButton));

        filmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Film Collection")) {
                    FilmCollectionGUI.getTabbedPane().setSelectedIndex(ADDFILM_TAB_INDEX);
                }
            }
        });

        this.add(filmsBlock);
    }

}
