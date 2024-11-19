package subway.ErrorMessage;

public enum DataErrorMessage {
    ERROR_MESSAGE_BEGINNING("[ERROR] "),
    MUST_BE_EXISTING_STATION("해당 지하철 역이 존재하지 않습니다."),
    MUST_BE_UNIQUE_STATION("이미 존재하는 지하철 역입니다.");

    private final String message;

    DataErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_BEGINNING.message + message;
    }
}
