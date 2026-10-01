package utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class CalculatorResultReader {

    public static String readResult(TakesScreenshot driver) {

        try {
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);

            BufferedImage image =
                    ImageIO.read(new ByteArrayInputStream(screenshot));

            int screenWidth = image.getWidth();
            int screenHeight = image.getHeight();

            // Result display region
            int x = (int) (screenWidth * 0.68);
            int y = (int) (screenHeight * 0.235);
            int width = (int) (screenWidth * 0.25);
            int height = (int) (screenHeight * 0.10);

            BufferedImage resultArea =
                    image.getSubimage(x, y, width, height);

            // Convert to grayscale
            BufferedImage gray = new BufferedImage(
                    resultArea.getWidth(),
                    resultArea.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY
            );

            Graphics2D graphics = gray.createGraphics();
            graphics.drawImage(resultArea, 0, 0, null);
            graphics.dispose();

            // Enlarge
            BufferedImage enlarged =
                    ImageHelper.getScaledInstance(
                            gray,
                            gray.getWidth() * 5,
                            gray.getHeight() * 5
                    );

            ITesseract tesseract = new Tesseract();

            tesseract.setVariable(
                    "tessedit_char_whitelist",
                    "0123456789.-"
            );

            /*
             * Try multiple page segmentation modes.
             */
            int[] psmModes = {8, 13, 7, 10};

            for (int psm : psmModes) {

                tesseract.setPageSegMode(psm);

                String raw = tesseract.doOCR(enlarged);

                String result = cleanResult(raw);

                System.out.println(
                        "OCR PSM " + psm +
                        " Raw: [" + raw + "]"
                );

                System.out.println(
                        "OCR PSM " + psm +
                        " Clean: [" + result + "]"
                );

                if (!result.isEmpty()) {
                    return result;
                }
            }

            return "";

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to extract calculator result using OCR",
                    e
            );
        }
    }

    private static String cleanResult(String raw) {

        if (raw == null) {
            return "";
        }

        return raw
                .replaceAll("[^0-9.-]", "")
                .trim();
    }
}