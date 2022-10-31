package JavaAdvanced2021.JavaOPP.Exam.restaurant.io;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
