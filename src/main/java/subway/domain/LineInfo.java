package subway.domain;

import java.util.List;

public class LineInfo {
    private final Line line;
    private final List<Station> stations;

    public LineInfo(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }
}
