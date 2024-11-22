package subway.view;

import java.util.Scanner;
import subway.validator.inputValidator.NumberValidator;

public class SubwayInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }

    public static String getOption() {
        SubwayOutputView.selectOption();
        return getInput();
    }

    public static int getOrder() {
        while (true) {
            String number = getInput();
            try {
                return NumberValidator.validateOrder(number);
            } catch (IllegalArgumentException e) {
                SubwayOutputView.print(e.getMessage());
            }
        }
    }
}
