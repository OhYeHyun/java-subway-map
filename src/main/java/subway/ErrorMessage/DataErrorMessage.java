package subway.ErrorMessage;

public enum DataErrorMessage {
    STATION_NAME_LENGTH_INVALID("지하철 역은 2글자 이상이어야 합니다."),
    LINE_NAME_LENGTH_INVALID("노선 이름은 2글자 이상이어야 합니다."),

    ALREADY_EXIST_STATION("이미 등록된 역 이름입니다."),
    ALREADY_EXIST_LINE("이미 등록된 노선 이름입니다."),
    NOT_FOUND_STATION("해당 지하철 역이 존재하지 않습니다."),
    NOT_FOUND_LINE("해당 노선이 존재하지 않습니다."),
    CANNOT_DELETE_STATION_ADDED_TO_LINE("노선에 등록된 역은 삭제할 수 없습니다."),
    CANNOT_ADD_ALREADY_ADDED_STATION_TO_LINE("노선에 이미 등록된 역입니다."),

    INVALID_ORDER("해당 순서에 지하철 역을 추가할 수 없습니다."),
    NOT_ENOUGH_STATION_TO_DELETE("해당 노선은 더이상 지하철 역을 삭제할 수 없습니다");

    private static final String PREFIX = System.lineSeparator() + "[ERROR] ";
    private final String message;

    DataErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
