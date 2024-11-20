package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(Station station) {
        stations.remove(station);
    }

    public static boolean isStationExist(String name) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }
    
    public static Station findStation(String name) {
        return stations.stream().filter(station -> Objects.equals(station.getName(), name)).findFirst().get();
    }

    public static void clear() {
        stations.clear();
    }
}
