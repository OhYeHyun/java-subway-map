package subway.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineInfo {
    public static final int MINIMUM_ORDER = 1;
    public static final int MINIMUM_NUMBER_OF_STATION = 2;

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

    public boolean isStationExistInLineInfo(String name) {
        return stations.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public void addSection(Station station, int order) {
        stations.add(order - 1, station);
    }

    public void deleteSection(Station station) {
        stations.remove(station);
    }

    public boolean canAddStation(int order) {
        // 3개의 역이 있을 때, 4번 째에 추가 가능
        return MINIMUM_ORDER <= order && order <= stations.size() + 1;
    }

    public boolean canDeleteStation() {
        return stations.size() > MINIMUM_NUMBER_OF_STATION;
    }
}
