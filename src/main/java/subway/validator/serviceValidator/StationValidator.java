package subway.validator.serviceValidator;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.StationRepository;
import subway.domain.MapRepository;

public class StationValidator {
    private static final int STATION_NAME_LENGTH = 2;

    private final StationRepository stationRepository;
    private final MapRepository mapRepository;

    public StationValidator() {
        this.stationRepository = StationRepository.getInstance();
        this.mapRepository = MapRepository.getInstance();
    }

    public void checkStationToAdd(String station) {
        if (station.length() <= STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(DataErrorMessage.STATION_NAME_LENGTH_INVALID.getMessage());
        }

        if (stationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.ALREADY_EXIST_STATION.getMessage());
        }
    }

    public void checkStationToDelete(String station) {
        if (!stationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }

        if (mapRepository.isStationAddedMap(station)) {
            throw new IllegalArgumentException(DataErrorMessage.CANNOT_DELETE_STATION_ADDED_TO_LINE.getMessage());
        }
    }
}
