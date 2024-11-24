package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final StationRepository instance = new StationRepository();
    private static final List<Station> stations = new ArrayList<>();

    private StationRepository() {}

    public static StationRepository getInstance() {
        return instance;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void deleteStation(Station station) {
        stations.remove(station);
    }

    public boolean isStationExist(String name) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }
    
    public Station findStation(String name) {
        return stations.stream().filter(station -> Objects.equals(station.getName(), name)).findFirst().get();
    }

    public void clear() {
        stations.clear();
    }
}
