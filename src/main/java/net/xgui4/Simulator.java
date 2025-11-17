package net.xgui4;

import net.xgui4.View.PlayButtonActionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Ceci est l'ébauche de l'applis/jeux
 */
public class Simulator {
    public final static String TITLE = "Computer Builder GUI";
    public final static int WINDOWS_WIDTH = 500;
    public final static int WINDOWS_HEIGHT = 500;
    private final static String PLAY_TITLE = "Play";

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);
        frame.setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel(TITLE, SwingConstants.CENTER);
        JButton playButton = new JButton(PLAY_TITLE);
        ActionListener playButtonAction = new PlayButtonActionView();
        playButton.addActionListener(playButtonAction);
        playButton.setPreferredSize(new Dimension(50, 50));

        // Add components to frame
        frame.add(title, BorderLayout.NORTH);
        frame.add(playButton, BorderLayout.CENTER);
        frame.setVisible(true); 
    }
}