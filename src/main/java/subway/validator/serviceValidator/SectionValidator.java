package subway.validator.serviceValidator;

import static subway.domain.MapRepository.isLineInfoExist;
import static subway.domain.StationRepository.isStationExist;

import subway.ErrorMessage.DataErrorMessage;
import subway.domain.LineInfo;
import subway.domain.MapRepository;

public class SectionValidator {
    public static void checkLineToAdd(String line) {
        if (isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }
    }

    public static void checkStationToAdd(LineInfo lineInfo, String station) {
        if (!isStationExist(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }

        if (lineInfo.isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.CANNOT_ADD_ALREADY_ADDED_STATION_TO_LINE.getMessage());
        }
    }

    public static void checkOrderToAdd(LineInfo lineInfo, int order) {
        if (lineInfo.canAddStation(order)) {
            throw new IllegalArgumentException(DataErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    public static void checkLineToDelete(String line) {
        if (!MapRepository.isLineInfoExist(line)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_LINE.getMessage());
        }

        if (!MapRepository.findLineInfo(line).canDeleteStation()) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_ENOUGH_STATION_TO_DELETE.getMessage());
        }
    }

    public static void checkStationToDelete(LineInfo lineInfo, String station) {
        if (!lineInfo.isStationExistInLineInfo(station)) {
            throw new IllegalArgumentException(DataErrorMessage.NOT_FOUND_STATION.getMessage());
        }
    }
}
