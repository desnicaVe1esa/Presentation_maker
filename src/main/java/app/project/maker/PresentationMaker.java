package app.project.maker;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public class PresentationMaker {

    /** Подсчет количества скринов для считывания нейминга */
    private final int screensCount = Objects.requireNonNull(new File("screens").listFiles()).length;

    public PresentationMaker() {}

    public void makePresentation() {
        XSLFSlide slide;
        File image;
        byte[] picture;
        try (XMLSlideShow pptx = new XMLSlideShow();
             FileOutputStream out = new FileOutputStream("presentation/presentation.pptx")) {
            for (int i = 1; i <= screensCount; i++) {
                slide = pptx.createSlide();
                image = new File("screens/slide_" + i + ".png");
                picture = IOUtils.toByteArray(new FileInputStream(image));
                XSLFPictureData idx = pptx.addPicture(picture, PictureData.PictureType.PNG);
                XSLFPictureShape pic = slide.createPicture(idx);
                pic.setAnchor(new Rectangle(0, 0, 1024, 540));
            }
            pptx.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
