package subway.domain;

import java.util.Collections;
import java.util.List;

public class LineInfo {
    private final Line line;
    private final List<Station> stations;

    public LineInfo(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
