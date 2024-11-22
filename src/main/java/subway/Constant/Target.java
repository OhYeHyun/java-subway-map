package subway.Constant;

public enum Target {
    STATION_LIST("역 목록"),
    LINE_LIST("노선 목록"),
    MAP_LIST("지하철 노선도"),
    STATION_NAME("역 이름"),
    LINE_NAME("노선 이름"),
    UPWARD_STATION_NAME("노선의 상행 종점역 이름"),
    DOWNWARD_STATION_NAME("노선의 하행 종점역 이름"),
    LINE("노선을"),
    STATION("역이름을"),
    ORDER("순서를"),
    LINE_OF_SECTION("구간의 노선"),
    STATION_OF_SECTION("구간의 역");

    private final String target;

    Target(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
