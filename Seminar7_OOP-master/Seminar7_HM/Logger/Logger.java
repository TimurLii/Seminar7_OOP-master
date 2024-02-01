package Seminar7_HM.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class Logger implements CalculatorLogger {

    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    @Override
    public void closeLogger() {
        System.out.println("Closing logger...");
    }

    @Override
    public String toString() {
        return "Logger []";
    }

    public void writeFile(double num1, double  num2, String nameFile) {
        try (FileWriter fw = new FileWriter(nameFile, true)) {
            fw.write("%s" + "%s"+ ";", (int) num1, (int) num2);
            fw.write(num1 + num2 + ";");
            fw.append('\n');
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
