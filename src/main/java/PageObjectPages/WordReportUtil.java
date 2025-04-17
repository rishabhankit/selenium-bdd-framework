package PageObjectPages;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WordReportUtil {

    public static XWPFDocument document;
    public static String scenarioName;

    public static void createWordFile(String name) {
        try {
            scenarioName = name.replaceAll(" ", "_");
            document = new XWPFDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addScreenshot(byte[] screenshot, String stepName) {

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            run.setBold(true);
            run.setText("Step : " + stepName);
            run.addBreak();

            run.setText("Time : " + time);
            run.addBreak();
            run.addBreak();

            InputStream pic = new ByteArrayInputStream(screenshot);

            run.addPicture(
                    pic,
                    Document.PICTURE_TYPE_PNG,
                    "step.png",
                    Units.toEMU(500),
                    Units.toEMU(300)
            );

            run.addBreak();
            run.addBreak();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveWordFile() {
        try {

            FileOutputStream out = new FileOutputStream(
                    "WordReports/" + scenarioName + ".docx");

            document.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}