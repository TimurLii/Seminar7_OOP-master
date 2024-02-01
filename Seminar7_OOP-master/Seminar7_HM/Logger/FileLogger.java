package Seminar7_HM.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements CalculatorLogger {
    private PrintWriter writer;

    public FileLogger(PrintWriter writer) {
        this.writer = writer;
    }

    public FileLogger(String filename) {
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeLogger();
        }
    }

    @Override
    public void log(String message) {
        writer.println(message);
//        writer.flush();
    }

    public void closeLogger() {
        synchronized (this) {
            if (writer != null) {
                writer.close();
            }
        }
    }

//    public void writeFile(String expression, String nameFile) {
//        try (FileWriter fw = new FileWriter(nameFile, true)) {
//            fw.write(expression + ";");
//            fw.append('\n');
//            fw.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

}
