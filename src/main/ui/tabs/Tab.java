package ui.tabs;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel {

    //EFFECTS: creates and returns a row with button included
    public JPanel formatButtonRow(JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);

        return panel;
    }
}
