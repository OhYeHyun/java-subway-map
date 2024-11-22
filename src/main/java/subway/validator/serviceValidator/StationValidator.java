package subway.validator.serviceValidator;

import static subway.domain.MapRepository.isStationAddedMap;
import static subway.domain.StationRepository.isStationExist;

import subway.ErrorMessage.DataErrorMessage;

public class StationValidator {
    public static final int STATION_NAME_LENGTH = 2;

    public static void checkStationToAdd(String station) {
        if (station.length() <= STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(DataErrorMessage.STATION_NAME_LENGTH_INVALID.getMessage());
        }

        if (isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.ALREADY_EXIST_STATION.getMessage());
        }
    }

    public static void checkStationToDelete(String station) {
        if (!isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }

        if (isStationAddedMap(station)) {
            throw new IllegalArgumentException(DataErrorMessage.CANNOT_DELETE_STATION_ADDED_TO_LINE.getMessage());
        }
    }
}
