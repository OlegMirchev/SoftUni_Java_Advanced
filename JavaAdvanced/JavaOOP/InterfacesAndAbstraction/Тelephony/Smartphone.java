package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.Тelephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile("^[^0-9]+$");
        for (String url : urls) {
            if (isValid(url, pattern)) {
                output.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }else {
                output.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        for (String numb : numbers) {
            if (isValid(numb, pattern)) {
                output.append(String.format("Calling... %s", numb)).append(System.lineSeparator());
            }else {
                output.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }

    private boolean isValid(String numb, Pattern pattern) {
        Matcher matcher = pattern.matcher(numb);
        return matcher.find();


//        for (int i = 0; i < numb.length(); i++) {
//            if (!Character.isDigit(numb.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
    }
}
