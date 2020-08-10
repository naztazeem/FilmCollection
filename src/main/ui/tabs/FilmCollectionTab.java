package ui.tabs;

import model.Film;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.FilmCollectionUI.*;
import static ui.FilmCollectionUI.filmCollection;


public class FilmCollectionTab extends Tab implements ActionListener {

    public static DefaultTableModel tableModel;
    public JTable tablePanel;

    String[] columnNames = {"Film Collection"};

    public FilmCollectionTab() {

        //EFFECTS: makes a table
        tableModel = new DefaultTableModel(columnNames, 0);
        tablePanel = new JTable(tableModel);
 //       tablePanel.setAutoCreateRowSorter(true);

        //EFFECTS: instructions to change information in a table
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("double-click to change added information of a film");
        tablePanel.getColumnModel().getColumn(0).setCellRenderer(renderer);
//        tablePanel.getColumnModel().getColumn(1).setCellRenderer(renderer);
//        tablePanel.getColumnModel().getColumn(2).setCellRenderer(renderer);
//        tablePanel.getColumnModel().getColumn(3).setCellRenderer(renderer);
//        tablePanel.getColumnModel().getColumn(4).setCellRenderer(renderer);


        //EFFECTS: creates a scroll bar
        JScrollPane scrollPane = new JScrollPane(tablePanel);


        this.add(deleteFilmButton(), BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // creates a new panel with add and delete buttons
    private JPanel deleteFilmButton() {
        JPanel buttonsBlock = new JPanel();
        buttonsBlock.setLayout(new BoxLayout(buttonsBlock, BoxLayout.LINE_AXIS));

        // creates delete button
        JButton deleteFilmButton = new JButton("Delete Film");
        JButton loadFilmCollectionButton = new JButton("Load Film Collection");

        deleteFilmButton.addActionListener(e -> {
            deleteSelectedFilm();
            saveFilms();
            tableModel.removeRow(tablePanel.getSelectedRow());

        });


        loadFilmCollectionButton.addActionListener(e -> {
            loadFilmCollection();
            FilmCollectionTab.tableModel.setRowCount(0);
            int c = 0;
            while (c < filmCollection.getFilmCollectionSize()) {
                FilmCollectionTab.tableModel.addRow(new Object[]{filmCollection.getFilmPosition(c)});
                c++;
            }
        });

        buttonsBlock.add(loadFilmCollectionButton);
        buttonsBlock.add(deleteFilmButton);
        return buttonsBlock;
    }

    public void deleteSelectedFilm() {
        int i = tablePanel.getSelectedRow();
        Film deleteSelectedFilm = (Film) tablePanel.getValueAt(i, 0);
        filmCollection.deleteFilm(deleteSelectedFilm);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
