package subway.constant;

public enum Service {
    INFO_LINE("---"),
    ADD("%s이 등록되었습니다."),
    DELETE("%s이 삭제되었습니다."),
    FORMAT("%s");

    private static final String PREFIX = "[INFO] ";
    private final String info;

    Service(String info) {
        this.info = info;
    }

    public String getInfo() {
        return PREFIX + info;
    }

    public String getInfo(String target) {
        return String.format(PREFIX + info, target);
    }
}
