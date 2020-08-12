package ui;

import model.Film;
import model.FilmCollection;
import persistence.Reader;
import persistence.Writer;
import ui.tabs.AddFilmTab;
import ui.tabs.FilmCollectionTab;
import ui.tabs.HomeTab;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FilmCollectionGUI extends JFrame {

    private static final String WATCHED_FILE = "./data/filmcollection.txt";

    public static final int HOME_TAB_INDEX = 0;
    public static final int ADDFILM_TAB_INDEX = 1;
    public static final int FILMCOLLECTION_TAB_INDEX = 2;


    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static JTabbedPane sidebar;
    public static FilmCollection filmCollection;



    //MODIFIES: this
    //EFFECTS: creates FilmCollectionUI, loads film collection, displays sidebar and tabs
    public FilmCollectionGUI() {

        super("Film Collection Console");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Instantiates watched film collection
        filmCollection = new FilmCollection();

        
        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, Films tab, and Watch List tab to this uI
    private void loadTabs() {
        JPanel homeTab = new HomeTab();
        JPanel addFilmTab = new AddFilmTab();
        JPanel filmsTab = new FilmCollectionTab();

        sidebar.add(homeTab,HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");

        sidebar.add(addFilmTab, ADDFILM_TAB_INDEX);
        sidebar.setTitleAt(ADDFILM_TAB_INDEX, "Add Film");

        sidebar.add(filmsTab,FILMCOLLECTION_TAB_INDEX);
        sidebar.setTitleAt(FILMCOLLECTION_TAB_INDEX, "Film Collection");

    }

    //EFFECTS: returns sidebar of this UI
    public static JTabbedPane getTabbedPane() {
        return sidebar;
    }

    // Loads watched film collection data
    public static void loadFilmCollection() {
        try {
            filmCollection = new FilmCollection();
            ArrayList<Film> films = Reader.readFilms(new File(WATCHED_FILE));
            filmCollection.filmCollection = films;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: saves films to WATCHED_FILE
    public static void saveFilms() {
        try {
            Writer watchedWriter = new Writer(new File(WATCHED_FILE));
            watchedWriter.write(filmCollection);
            watchedWriter.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
