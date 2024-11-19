package subway.ErrorMessage;

public enum ValidatorErrorMessage {
    ERROR_MESSAGE_BEGINNING("[ERROR] "),
    MUST_BE_NUMBER("숫자로 입력해주세요."),
    MUST_BE_NUMBER_IN_MENU("해당 번호의 메뉴가 존재하지 않습니다."),
    MUST_BE_CHARACTER("문자로 입력해주세요.");

    private final String message;

    ValidatorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_BEGINNING.message + message;
    }
}
