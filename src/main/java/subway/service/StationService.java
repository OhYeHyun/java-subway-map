package subway.service;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.Station;
import subway.domain.StationAddedRepository;
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

    private static void checkAddStation(String station) {
        if (StationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_STATION.getMessage());
        }
    }

    private static void checkDeleteStation(String station) {
        if (StationAddedRepository.isStationAddedLine(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_NOT_BE_ADDED_TO_LINE.getMessage());
        }

        if (!StationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }
}
