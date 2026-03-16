package PageObjectPages;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WordReportUtil {

    private static ThreadLocal<XWPFDocument> document = new ThreadLocal<>();
    private static ThreadLocal<String> scenarioName = new ThreadLocal<>();

    public static void createWordFile(String name) {
        try {
            scenarioName.set(name.replaceAll(" ", "_"));
            document.set(new XWPFDocument());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addScreenshot(byte[] screenshot, String stepName) {

        try {
            XWPFDocument doc = document.get();
            if (doc == null) {
                throw new IllegalStateException("Document not initialized. Call createWordFile first.");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);

            XWPFParagraph paragraph = doc.createParagraph();
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
            XWPFDocument doc = document.get();
            String name = scenarioName.get();
            if (doc == null || name == null) {
                throw new IllegalStateException("Document or scenario name not initialized.");
            }

            FileOutputStream out = new FileOutputStream(
                    "WordReports/" + name + ".docx");

            doc.write(out);
            out.close();

            // Clean up thread locals
            document.remove();
            scenarioName.remove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}