package pl.andus.cAPI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Utils {
    static String os = System.getProperty("os.name").toLowerCase();

    public void OpenWebsite(String siteUrl) {
        try {
            Desktop.getDesktop().browse(new URL(siteUrl).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String CheckOSRunning() {
        if (isWin()) {
            Logging.info("Running on Windows " + "(" + os + ")");
        } else if (isMac()) {
            Logging.info("Running on MacOS" + "(" + os + ")");
        } else if (isUnix()) {
            Logging.info("Running on Unix/Linux" + "(" + os + ")");
        } else if (isSol()) {
            Logging.info("Running on Solaris" + "(" + os + ")");
        }

        return os;
    }

    public static boolean isWin() {
        return (os.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (os.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (os.indexOf("nix") >= 0
                || os.indexOf("nux") >= 0
                || os.indexOf("aix") >= 0);
    }

    public static boolean isSol() {
        return (os.indexOf("sunos") >= 0);
    }

    public static BufferedImage flipImage(BufferedImage src) {
        BufferedImage bufferedImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-bufferedImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(src, null);
        return bufferedImage;
    }
}
