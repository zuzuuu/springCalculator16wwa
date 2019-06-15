package pl.sda.springcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private Matcher matcher;

    public double calculate(String sentValue){
        Pattern pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");   // - \\d - cyfry, \\D - nie-cyfry, + - wiele znaków
        Matcher matcher = pattern.matcher(sentValue);

        if (matcher.matches()) {
            String firstValue = matcher.group(1);
            String sign = matcher.group(2).trim();  // trim - wywala białe znaki jak spacje, tab itp.
            String secondValue = matcher.group(3);

            Integer first = Integer.valueOf(firstValue);
            Integer second = Integer.valueOf(secondValue);  //rzutowanie

            if (sign.equals("+")){
                return first + second;
            }
        }
        return 0;
    }
}