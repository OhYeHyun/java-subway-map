package subway.service;

public enum DisplayInfo {
    INFO_LINE("---"),
    ADDED_STATION("%s이 등록되었습니다."),
    DELETED_STATION("%s이 삭제되었습니다."),
    FORMAT("%s");

    private static final String PREFIX = "[INFO] ";
    private final String info;

    DisplayInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return PREFIX + info;
    }

    public String getInfo(String item) {
        return String.format(PREFIX + info, item);
    }
}
