package app.project.maker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;

public class ScreenMaker {

    /**
     * Контейнер для URL'ов с контентом
     */
    public static final String[] urls = new String[]{
            "https://github.com/desnicaVe1esa"
    };

    /**
     * Дефолтные параметры
     */
    public static int x = 213;
    public static int y = 162;
    public static int width = 282;
    public static int height = 220;

    public ScreenMaker() {
    }

    public void makeScreenShots() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        URI uri;
        Rectangle rectangle;
        Robot robot;
        BufferedImage bufferedImage;
        /* Для создания неймнига */
        int count = 1;
        /*-----------------------*/
        for (String url : urls) {
            try {
                uri = new URI(url);
                Desktop.getDesktop().browse(uri);
                robot = new Robot(gs[0]);
                robot.setAutoWaitForIdle(true);
                /* Динамическое изменение параметров */
                changeParams(url);
                /*-----------------------------------*/
                rectangle = new Rectangle(x, y, gs[0].getDisplayMode().getWidth() - width, gs[0].getDisplayMode().getHeight() - height);
                /* Пауза для прогрузки страницы */
                Thread.sleep(2000);
                /*------------------------------*/
                bufferedImage = robot.createScreenCapture(rectangle);
                ImageIO.write(bufferedImage, "png", new File("screens/slide_" + count + ".png"));
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /** Изменение области захвата изображения */
    private static void changeParams(String url) {
        switch (url) {
            case "https://github.com/desnicaVe1esa" -> {
                y = 0;
                x = 0;
                width = 380;
            }
        }
    }
}
