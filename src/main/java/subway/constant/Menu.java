package subway.constant;

public enum Menu {
    MAIN("메인", new String[]{"역 관리", "노선 관리", "구간 관리", "지하철 노선도 출력"}, false),
    STATION("역 관리", new String[]{"역 등록", "역 삭제", "역 조회"}, true),
    LINE("노선 관리", new String[]{"노선 등록", "노선 삭제", "노선 조회"}, true),
    SECTION("구간 관리", new String[]{"구간 등록", "구간 삭제"}, true);

    private final String title;
    private final String[] options;
    private final boolean includeBack;

    Menu(String title, String[] options, boolean includeBack) {
        this.title = title;
        this.options = options;
        this.includeBack = includeBack;
    }

    public String getTitle() {
        return title;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isIncludeBack() {
        return includeBack;
    }
}
