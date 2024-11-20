package subway.validator;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.LineRepository;
import subway.domain.MapRepository;
import subway.domain.StationRepository;

public class BusinessValidator {

    public static void checkStationToAddStation(String station) {
        if (StationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_STATION.getMessage());
        }
    }

    public static void checkStationToDeleteStation(String station) {
        if (!StationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }

        if (!MapRepository.isStationAddedMap(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_NOT_BE_ADDED_TO_LINE.getMessage());
        }
    }

    public static void checkLineToAddLine(String line) {
        if (LineRepository.isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_UNIQUE_LINE.getMessage());
        }
    }

    public static void checkStationToAddLine(String station) {
        if (!StationRepository.isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }

    public static void checkLineToDeleteLine(String line) {
        if (!LineRepository.isLineExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.MUST_BE_EXISTING_STATION.getMessage());
        }
    }
}
