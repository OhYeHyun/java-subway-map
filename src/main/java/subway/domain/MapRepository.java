package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MapRepository {
    private static final List<LineInfo> map = new ArrayList<>();

    public static List<LineInfo> map() {
        return Collections.unmodifiableList(map);
    }

    public static void addLineInfo(LineInfo lineInfo) {
        map.add(lineInfo);
    }

    public static boolean isStationAddedMap(String name) {
        List<Station> stations = stationsAddedToMap();
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    private static List<Station> stationsAddedToMap() {
        Set<Station> stations = new HashSet<>();
        map.forEach((lineInfo) -> stations.addAll(lineInfo.getStations()));

        return stations.stream().toList();
    }
}
