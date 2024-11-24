package subway.ErrorMessage;

public enum ValidatorErrorMessage {
    MUST_BE_NUMBER("숫자로 입력해주세요."),
    MUST_BE_POSITIVE("숫자는 1 이상이어야 합니다."),
    MUST_BE_NUMBER_IN_MENU("선택할 수 없는 기능입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ValidatorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
