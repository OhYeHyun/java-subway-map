package subway.validator.inputValidator;

import subway.ErrorMessage.ValidatorErrorMessage;

public class NumberValidator {
    private static final int OPTION_START = 1;

    public static int validateOrder(String input) {
        validateIsNumeric(input);
        validateOverZero(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorErrorMessage.MUST_BE_NUMBER.getMessage());
        }
    }

    private static void validateOverZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ValidatorErrorMessage.MUST_BE_POSITIVE.getMessage());
        }
    }
}
