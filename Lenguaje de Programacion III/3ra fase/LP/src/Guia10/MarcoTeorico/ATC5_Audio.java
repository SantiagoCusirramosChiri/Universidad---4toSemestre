package Guia10.MarcoTeorico;

import javax.sound.sampled.*; import javax.swing.*;
import java.io.File;
import java.io.IOException;

class AppAudio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton playButton = new JButton("Reproducir Audio");
        playButton.addActionListener(e-> playAudio("src/Guia10/MarcoTeorico/AudioPonk.wav"));
        frame.add(playButton);
        frame.setVisible(true);
    }
    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream); clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}