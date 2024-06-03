package app.project;

import app.project.maker.PresentationMaker;
import app.project.maker.ScreenMaker;

import javax.swing.*;
import java.awt.*;

public class PresentationMakerRun {
    public static ScreenMaker screenMaker = new ScreenMaker();
    public static PresentationMaker presentationMaker = new PresentationMaker();

    public static void main(String[] args) {
        screenMaker.makeScreenShots();
        presentationMaker.makePresentation();
        JOptionPane.showMessageDialog(new Frame(), "Presentation_maker завершил свою работу");
        System.exit(0);
    }
}