package subway.validator.inputValidator;

import subway.ErrorMessage.ValidatorErrorMessage;

public class NumberValidator {

    public static int validate(String input) {
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorErrorMessage.MUST_BE_NUMBER.getMessage());
        }
    }
}
