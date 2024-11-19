package subway.service;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.Station;
import subway.domain.StationAddedRepository;
import subway.domain.StationRepository;
import subway.view.SubwayOutputView;

public class StationService {

    public static void addStation(String station) {
        if (StationRepository.isStationAlreadyExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_STATION.getMessage());
        }
        StationRepository.addStation(generateStation(station));
    }

    public static void deleteStation(String station) {
        if (StationAddedRepository.isStationAddedLine(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_NOT_BE_ADDED_TO_LINE.getMessage());
        }

        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }

    public static void checkStation() {
        StationRepository.stations().forEach(station -> SubwayOutputView.print(station.getName()));
    }

    private static Station generateStation(String station) {
        return new Station(station);
    }
}
