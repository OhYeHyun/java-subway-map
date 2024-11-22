package subway.validator.serviceValidator;

import static subway.domain.MapRepository.findLineInfo;
import static subway.domain.MapRepository.isLineInfoExist;
import static subway.domain.StationRepository.isStationExist;

import subway.ErrorMessage.DataErrorMessage;

public class SectionValidator {
    public static void checkLineToAdd(String line) {
        if (!isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }
    }

    public static void checkStationToAdd(String line, String station) {
        if (!isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }

        if (findLineInfo(line).isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.CANNOT_ADD_ALREADY_ADDED_STATION_TO_LINE.getMessage());
        }
    }

    public static void checkOrderToAdd(String line, int order) {
        if (!findLineInfo(line).canAddStation(order)) {
            throw new IllegalArgumentException(DataErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public static void checkLineToDelete(String line) {
        if (!isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }

        if (!findLineInfo(line).canDeleteStation()) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_ENOUGH_STATION_TO_DELETE.getMessage());
        }
    }

    public static void checkStationToDelete(String line, String station) {
        if (!findLineInfo(line).isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }
    }
}
