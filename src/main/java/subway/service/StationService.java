package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class StationService {

    public static void addStation(String station) {
        StationRepository.addStation(generateStation(station));
    }

    public static void deleteStation(String station) {
        StationRepository.deleteStation(station);
    }

    public static void displayStation() {
        StationRepository.stations().forEach(station -> SubwayOutputView.print(station.getName()));
    }

    private static Station generateStation(String station) {
        return new Station(station);
    }
}
